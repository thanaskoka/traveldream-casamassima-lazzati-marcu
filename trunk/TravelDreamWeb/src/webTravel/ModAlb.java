package webTravel;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.AlbergoMgr;
import model.LuogoMgr;
import model.dto.AlbergoDTO;
import model.dto.LuogoDTO;

@ManagedBean(name="modAlb")

@ViewScoped
public class ModAlb {
	
	
	@EJB
	private AlbergoMgr alMgr;
	@EJB
	private LuogoMgr luogoMgr;
	private int luogo=-1;
	private AlbergoDTO al;
	




	private String nome;
	private int stelle;
	private int idAl;
	private List<LuogoDTO> elelis;
	private List<AlbergoDTO> allis;
	
	



	@PostConstruct
    public void init()
    {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	
		idAl=Integer.parseInt(request.getParameter("id"));
		
		
		setAl(alMgr.getNomeById(idAl));
		
        setElelis(luogoMgr.getLuoghiAl());
        luogo=al.getIdLuogo();
    }
	
	public void update() throws IOException{
		
		alMgr.updateAlbergo(al);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("showEditAlbergo.xhtml");
		
		
	}
	
	
	
	
	

	public AlbergoMgr getAlMgr() {
		return alMgr;
	}

	public void setAlMgr(AlbergoMgr alMgr) {
		this.alMgr = alMgr;
	}

	public LuogoMgr getLuogoMgr() {
		return luogoMgr;
	}

	public void setLuogoMgr(LuogoMgr luogoMgr) {
		this.luogoMgr = luogoMgr;
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

	public List<LuogoDTO> getElelis() {
		return elelis;
	}

	public void setElelis(List<LuogoDTO> elelis) {
		this.elelis = elelis;
	}

	public List<AlbergoDTO> getAllis() {
		return allis;
	}

	public void setAllis(List<AlbergoDTO> allis) {
		this.allis = allis;
	}
	public int getIdAl() {
		return idAl;
	}




	public void setIdAl(int idAl) {
		this.idAl = idAl;
	}




	
	public AlbergoDTO getAl() {
		return al;
	}




	public void setAl(AlbergoDTO al) {
		this.al = al;
	}

	

}
