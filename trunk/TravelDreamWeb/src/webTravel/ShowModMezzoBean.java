package webTravel;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	private int idmezzo=-1;
	
	private MezzoDTO mezzoselect;
	public MezzoDTO getMezzoselect() {
		return mezzoselect;
	}




	public void setMezzoselect(MezzoDTO mezzoselect) {
		this.mezzoselect = mezzoselect;
	}




	public int getIdmezzo() {
		return idmezzo;
	}




	public void setIdmezzo(int idmezzo) {
		this.idmezzo = idmezzo;
	}




	public List<LuogoDTO> getElelis() {
		return elelis;
	}




	public void setElelis(List<LuogoDTO> elelis) {
		this.elelis = elelis;
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

}