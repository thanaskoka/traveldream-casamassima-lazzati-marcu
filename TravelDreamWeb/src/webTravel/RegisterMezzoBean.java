package webTravel;

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
	private int LuogoArrivo;
	
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
	private List<LuogoDTO> elelis;
	
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
		mezzoMgr.save(mezzo);
		return "sceltaInserimento?faces-redirect=true";
	}

}
