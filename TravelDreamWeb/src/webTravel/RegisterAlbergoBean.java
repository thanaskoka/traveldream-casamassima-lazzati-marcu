package webTravel;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.AlbergoMgr;
import model.LuogoMgr;
import model.dto.AlbergoDTO;
import model.dto.LuogoDTO;

@ManagedBean(name="registerAlbergoBean")
@RequestScoped
public class RegisterAlbergoBean {
	@EJB
	private AlbergoMgr alMgr;

	private AlbergoDTO al;
	@EJB
	private LuogoMgr luogoMgr;
	private int luogo=-1;
	
	private String nome;
	private int stelle;
	
	private List<LuogoDTO> elelis;
	
	public RegisterAlbergoBean () {
		al = new AlbergoDTO();
	}

	
	public int getLuogo() {
		return luogo;
	}

	public void setLuogo(int luogo) {
		this.luogo = luogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStelle() {
		return stelle;
	}

	public void setStelle(int stelle) {
		this.stelle = stelle;
	}


	public AlbergoDTO getAl() {
		return al;
	}


	public void setAl(AlbergoDTO al) {
		this.al = al;
	}


	public LuogoMgr getLuogoMgr() {
		return luogoMgr;
	}


	public void setLuogoMgr(LuogoMgr luogoMgr) {
		this.luogoMgr = luogoMgr;
	}
	
	

	@PostConstruct
    public void init()
    {
        setElelis(luogoMgr.getLuoghiAl());
    }
	
	
	public List<LuogoDTO> getElelis() {
		return elelis;
	}

	public void setElelis(List<LuogoDTO> elelis) {
		this.elelis = elelis;
	}
	
	public String register() {
		
		al.setIdLuogo(luogo);
		al.setNome(nome);
		al.setNumeroStelle(stelle);	
		alMgr.save(al);
		return "sceltaInserimento?faces-redirect=true";
	}
}
