package webTravel;

import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.MezzoMgr;
import model.dto.MezzoDTO;

@ManagedBean(name="modMezzo")

@ViewScoped
public class ModMezzoBean {
	
	
	@EJB 
	MezzoMgr mezzoMgr;
	
	MezzoDTO mezzoDto;
	Date dateP;
	Date dateA;
	int idMezzo;
	
	
	@PostConstruct
    public void init()
    {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	
		idMezzo=Integer.parseInt(request.getParameter("id"));
		
		
		setMezzoDto(mezzoMgr.returnData(idMezzo));
		dateP=mezzoDto.getDataInizio();
		dateA=mezzoDto.getDataFine();
        
    }
	public void update() throws IOException{
		mezzoDto.setDataInizio(dateP);
		mezzoDto.setDataFine(dateA);
		mezzoMgr.update(mezzoDto);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("showEditMezzo.xhtml");
		
		
	}
	
	
	
	
	
	
	
	
	
	public Date getDateP() {
		return dateP;
	}

	public void setDateP(Date dateP) {
		this.dateP = dateP;
	}

	public Date getDateA() {
		return dateA;
	}

	public void setDateA(Date dateA) {
		this.dateA = dateA;
	}


	public MezzoDTO getMezzoDto() {
		return mezzoDto;
	}

	public void setMezzoDto(MezzoDTO mezzoDto) {
		this.mezzoDto = mezzoDto;
	}
}
