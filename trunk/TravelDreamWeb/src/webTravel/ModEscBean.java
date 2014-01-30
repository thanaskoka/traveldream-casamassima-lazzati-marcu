package webTravel;

import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.EscursioneMgr;
import model.dto.EscursioneDTO;

@ManagedBean(name="modEsc")

@ViewScoped
public class ModEscBean {
	
	
	
	@EJB
	EscursioneMgr escmgr;
	
	EscursioneDTO escDto;
	
	Date dateP;
	Date dateA;
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

	int idEsc;
	
	@PostConstruct
    public void init()
    {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	
		idEsc=Integer.parseInt(request.getParameter("id"));
		
		
		setEscDto(escmgr.getEscId(idEsc));
		dateA=escDto.getDataInizio();
		dateP=escDto.getDataFine();
        
    }
	
	public EscursioneDTO getEscDto() {
		return escDto;
	}

	public void setEscDto(EscursioneDTO escDto) {
		this.escDto = escDto;
	}

	public void update() throws IOException{
		escDto.setDataInizio(dateA);
		escDto.setDataFine(dateP);
		escmgr.updateEscursione(escDto);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("showEditEscursione.xhtml");
		
		
	}
}
