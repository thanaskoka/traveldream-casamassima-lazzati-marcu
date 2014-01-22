package webTravel;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import model.AlbergoMgr;
import model.EscursioneMgr;
import model.LuogoMgr;
import model.MezzoMgr;
import model.PacchettoMgr;
import model.dto.AlbergoDTO;
import model.dto.EscursioneDTO;
import model.dto.LuogoDTO;
import model.dto.MezzoDTO;
import model.dto.PacchettoDTO;



@ManagedBean(name="invioLuogo")
@ViewScoped
public class InvioLuogoBean {
	
	
	
	private Date dataP;
    private int luogoA;
    private int luogoP;
    private LuogoDTO luogoAppoggio;
    private int mezzoA=-1;
    private int mezzoB=-1;
    private int dest=-1;
    private int par=-1;
    private int hotel=-1;
    private Date dataA;
    private List<EscursioneDTO>esclis;
	private List<LuogoDTO> luogoLis;
    @EJB
    private LuogoMgr luogoMgr;

    public int getPar() {
		return par;
	}
	public void setPar(int par) {
		this.par = par;
	}
    public Date getDataA() {
		return dataA;
	}
	public void setDataA(Date dataA) {
		this.dataA = dataA;
	}
	public Date getDataP() {
		return dataP;
	}
	public void setDataP(Date dataP) {
		this.dataP = dataP;
	}
	public int getLuogoA() {
		return luogoA;
	}
	public void setLuogoA(int luogoA) {
		this.luogoA = luogoA;
	}
	public int getLuogoP() {
		return luogoP;
	}
	public void setLuogoP(int luogoP) {
		this.luogoP = luogoP;
	}
	
	
    
    public LuogoDTO getLuogoAppoggio() {
		return luogoAppoggio;
	}
	public void setLuogoAppoggio(LuogoDTO luogoAppoggio) {
		this.luogoAppoggio = luogoAppoggio;
	}
	public 	List<LuogoDTO> getLuogoLis() {
		return luogoLis;
	}
	public void setLuogoLis(List<LuogoDTO> elelis) {
		this.luogoLis = elelis;
	}

    public InvioLuogoBean() {
		
	}
	
	
	public List<EscursioneDTO> getEsclis() {
		return esclis;
	}
	public void setEsclis(List<EscursioneDTO> esclis) {
		this.esclis = esclis;
	}
	
	
	public int getMezzoA() {
		return mezzoA;
	}
	public void setMezzoA(int mezzoA) {
		this.mezzoA = mezzoA;
	}
	public int getMezzoB() {
		return mezzoB;
	}
	public void setMezzoB(int mezzoB) {
		this.mezzoB = mezzoB;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public int getHotel() {
		return hotel;
	}
	public void setHotel(int hotel) {
		this.hotel = hotel;
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
        
        setLuogoLis(luogoMgr.getLuoghi());
        
        
    }
	
	
    
public String add() {
	return "AddPacchetto?faces-redirect=true&idD="+dest+"&idP="+par;
	
		
	}
    
}
