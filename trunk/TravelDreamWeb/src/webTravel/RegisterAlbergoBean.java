package webTravel;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.AlbergoMgr;
import model.CameraMgr;
import model.LuogoMgr;
import model.dto.AlbergoDTO;
import model.dto.CameraDTO;
import model.dto.LuogoDTO;

@ManagedBean(name="registerAlbergoBean")
@RequestScoped
public class RegisterAlbergoBean {
	@EJB
	private AlbergoMgr alMgr;

	private AlbergoDTO al;
	
	@EJB
	private LuogoMgr luogoMgr;
	
	@EJB
	private CameraMgr camMgr;
	
	private int luogo=-1;
	
	private String nome;
	private int stelle;
	
	private int opt1,opt2,opt3;
	
	private float costo1,costo2,costo3;
    
	
	private List<LuogoDTO> elelis;
	private List<AlbergoDTO> allis;
	
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

	
	public float getCosto1() {
		return costo1;
	}


	public void setCosto1(float costo1) {
		this.costo1 = costo1;
	}


	public float getCosto2() {
		return costo2;
	}


	public void setCosto2(float costo2) {
		this.costo2 = costo2;
	}


	public float getCosto3() {
		return costo3;
	}


	public void setCosto3(float costo3) {
		this.costo3 = costo3;
	}


	@PostConstruct
    public void init()
    {
        setElelis(luogoMgr.getLuoghiAl());
        setAllis(alMgr.getAlbergoAl());
    }
	
	
	
	public List<AlbergoDTO> getAllis() {
		return allis;
	}


	public void setAllis(List<AlbergoDTO> allis) {
		this.allis = allis;
	}


	public List<LuogoDTO> getElelis() {
		return elelis;
	}

	public void setElelis(List<LuogoDTO> elelis) {
		this.elelis = elelis;
	}
	
	public String register() {
		CameraDTO cam;
		al.setIdLuogo(luogo);
		alMgr.save(al);
		for(int i = 0; i < opt1; i++){
			cam = new CameraDTO();
			cam.setIdAlbergo(allis.get(allis.size()-1).getId());
			cam.setCostoPersoneCam(costo1);;
			cam.setNrCamera(i+1);
			cam.setNumPersCam(1);
			camMgr.save(cam);
		}
		for(int i = 0; i < opt2; i++){
			cam = new CameraDTO();
			cam.setIdAlbergo(allis.get(allis.size()-1).getId());
			cam.setCostoPersoneCam(costo2);;
			cam.setNrCamera(i+1);
			cam.setNumPersCam(2);
			camMgr.save(cam);
		}
		for(int i = 0; i < opt3; i++){
			cam = new CameraDTO();
			cam.setIdAlbergo(allis.get(allis.size()-1).getId());
			cam.setCostoPersoneCam(costo3);;
			cam.setNrCamera(i+1);
			cam.setNumPersCam(3);
			camMgr.save(cam);
		}
		return "index?faces-redirect=true";
	}
}
