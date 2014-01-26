package webTravel;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import model.EscursioneMgr;
import model.LuogoMgr;
import model.dto.EscursioneDTO;
import model.dto.LuogoDTO;


@ManagedBean(name="showEscursioneModBean")
@RequestScoped
public class ShowModEscursioneBean {
	
	
	@EJB
	private EscursioneMgr escursioneMgr;
	private EscursioneDTO escursione; 
	@EJB
	private LuogoMgr luogoMgr;
	
	private int idEscursione=-1;
	private int costoPerEsc;
	private String infoEsc;
	private Date dataFine;
	private Date dataInizio;
	private int idLuogo=-1;
	private int postiDisponibili;
	
	private List<LuogoDTO> elelis;
	private List<EscursioneDTO> carsSmall;
	
	
	public EscursioneMgr getEscursioneMgr() {
		return escursioneMgr;
	}
	public void setEscursioneMgr(EscursioneMgr escursioneMgr) {
		this.escursioneMgr = escursioneMgr;
	}
	public EscursioneDTO getEscursione() {
		return escursione;
	}
	public void setEscursione(EscursioneDTO escursione) {
		this.escursione = escursione;
	}
	public LuogoMgr getLuogoMgr() {
		return luogoMgr;
	}
	public void setLuogoMgr(LuogoMgr luogoMgr) {
		this.luogoMgr = luogoMgr;
	}
	public int getIdEscursione() {
		return idEscursione;
	}
	public void setIdEscursione(int idEscursione) {
		this.idEscursione = idEscursione;
	}
	public int getCostoPerEsc() {
		return costoPerEsc;
	}
	public void setCostoPerEsc(int costoPerEsc) {
		this.costoPerEsc = costoPerEsc;
	}
	public String getInfoEsc() {
		return infoEsc;
	}
	public void setInfoEsc(String infoEsc) {
		this.infoEsc = infoEsc;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public int getIdLuogo() {
		return idLuogo;
	}
	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}
	public int getPostiDisponibili() {
		return postiDisponibili;
	}
	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}
	public List<LuogoDTO> getElelis() {
		return elelis;
	}
	public void setElelis(List<LuogoDTO> elelis) {
		this.elelis = elelis;
	}
	public List<EscursioneDTO> getCarsSmall() {
		return carsSmall;
	}
	public void setCarsSmall(List<EscursioneDTO> carsSmall) {
		this.carsSmall = carsSmall;
	} 
	
	@PostConstruct
    public void init()
    {
        setCarsSmall(escursioneMgr.getEscursioniAl());
        setElelis(luogoMgr.getLuoghiEsc());
    }
	
	
}
		
		