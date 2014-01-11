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
	
	private int opt1,opt2,opt3;
    
	
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
	
	

	public int getOpt1() {
		return opt1;
	}


	public void setOpt1(int opt1) {
		this.opt1 = opt1;
	}


	public int getOpt2() {
		return opt2;
	}


	public void setOpt2(int opt2) {
		this.opt2 = opt2;
	}


	public int getOpt3() {
		return opt3;
	}


	public void setOpt3(int opt3) {
		this.opt3 = opt3;
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
		alMgr.save(al);
		return "sceltaInserimento?faces-redirect=true";
	}
}
