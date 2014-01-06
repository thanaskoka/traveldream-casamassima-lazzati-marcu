package webTravel;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.LuogoMgr;
import model.MezzoMgr;
import model.dto.MezzoDTO;
import model.dto.LuogoDTO;
@ManagedBean(name="registerMezzoBean")
@RequestScoped
public class RegisterMezzoBean {
	

	@EJB
	private MezzoMgr mezzoMgr;

	private MezzoDTO mezzo;
	@EJB
	private LuogoMgr luogoMgr;
	private int LuogoArrivo=-1;
	private int LuogoPartenza=-1;
	private Date dateP;
	private Date dateA;
	

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

	public Integer getLuogoPartenza() {
		return LuogoPartenza;
	}

	public void setLuogoPartenza(Integer luogoPartenza) {
		LuogoPartenza = luogoPartenza;
	}

	private List<LuogoDTO> elelis;
	
	public int getLuogoArrivo() {
		return LuogoArrivo;
	}

	public void setLuogoArrivo(int luogoArrivo) {
		LuogoArrivo = luogoArrivo;
	}
	

	@PostConstruct
    public void init()
    {
        setElelis(luogoMgr.getLuoghi());
    }
	
	
	public List<LuogoDTO> getElelis() {
		return elelis;
	}

	public void setElelis(List<LuogoDTO> elelis) {
		this.elelis = elelis;
	}

	public RegisterMezzoBean() {
		mezzo = new MezzoDTO();
	}

	public MezzoDTO getUser() {
		return mezzo;
	}

	public void setUser(MezzoDTO m) {
		this.mezzo = m;
	}
	
	public String register() {
		
		mezzo.setIdLuogoArrivo(LuogoArrivo);
		mezzo.setIdLuogoPartenza(LuogoPartenza);
		mezzo.setDataInizio(dateP);
		mezzo.setDataFine(dateA);
	
		mezzoMgr.save(mezzo);
		return "sceltaInserimento?faces-redirect=true";
	}

}
