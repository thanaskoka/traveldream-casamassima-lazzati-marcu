package webTravel;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import model.LuogoMgr;
import model.MezzoMgr;
import model.dto.LuogoDTO;
import model.dto.MezzoDTO;
@ManagedBean(name="showMezzoModBean")
@RequestScoped
public class ShowModMezzoBean {
	
	
	@EJB
	private MezzoMgr mezzoMgr;

	private MezzoDTO mezzo;
	@EJB
	private LuogoMgr luogoMgr;
	private int LuogoArrivo=-1;
	private int LuogoPartenza=-1;
	private Date dateP;
	private Date dateA;
	private List<LuogoDTO> elelis;
	private List<MezzoDTO> carsSmall; 
	
	
	public List<LuogoDTO> getElelis() {
		return elelis;
	}




	public void setElelis(List<LuogoDTO> elelis) {
		this.elelis = elelis;
	}
	
	@PostConstruct
    public void init()
    {
        setCarsSmall(mezzoMgr.getMezzo());
        setElelis(luogoMgr.getLuoghi());
    }




	public MezzoMgr getMezzoMgr() {
		return mezzoMgr;
	}




	public void setMezzoMgr(MezzoMgr mezzoMgr) {
		this.mezzoMgr = mezzoMgr;
	}




	public MezzoDTO getMezzo() {
		return mezzo;
	}




	public void setMezzo(MezzoDTO mezzo) {
		this.mezzo = mezzo;
	}




	public LuogoMgr getLuogoMgr() {
		return luogoMgr;
	}




	public void setLuogoMgr(LuogoMgr luogoMgr) {
		this.luogoMgr = luogoMgr;
	}




	public int getLuogoArrivo() {
		return LuogoArrivo;
	}




	public void setLuogoArrivo(int luogoArrivo) {
		LuogoArrivo = luogoArrivo;
	}




	public int getLuogoPartenza() {
		return LuogoPartenza;
	}




	public void setLuogoPartenza(int luogoPartenza) {
		LuogoPartenza = luogoPartenza;
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




	public List<MezzoDTO> getCarsSmall() {
		return carsSmall;
	}




	public void setCarsSmall(List<MezzoDTO> carsSmall) {
		this.carsSmall = carsSmall;
	}
	
	public void onEdit(RowEditEvent event) {  
        
    }  
      
    public void onCancel(RowEditEvent event) {  
       
    }  
	
	

}
