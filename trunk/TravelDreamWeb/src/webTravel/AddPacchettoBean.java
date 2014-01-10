package webTravel;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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



@ManagedBean(name="addPackBean")
@RequestScoped
public class AddPacchettoBean {
	
	
	@EJB
    private PacchettoMgr paccMgr;
	private PacchettoDTO paccDTO;
	private List<MezzoDTO> mezziLis;
	private List<AlbergoDTO>albergoLis;
	private List<EscursioneDTO>esclis;
	private EscursioneDTO[] escScelte;
	private List<LuogoDTO> luogoLis;
    public 	List<LuogoDTO> getLuogoLis() {
		return luogoLis;
	}
	public void setLuogoLis(List<LuogoDTO> elelis) {
		this.luogoLis = elelis;
	}

	private int mezzoA=-1;
    private int mezzoB=-1;
    private int dest=-1;
    private int hotel=-1;
    @EJB
    private MezzoMgr mezzoMgr;
    @EJB
    private EscursioneMgr escMgr;
    @EJB
    private AlbergoMgr albMgr;
    @EJB
    private LuogoMgr luogoMgr;
    
    public AddPacchettoBean() {
		paccDTO = new PacchettoDTO();
	}
	
	public PacchettoDTO getPaccDTO() {
		return paccDTO;
	}
	public void setPaccDTO(PacchettoDTO paccDTO) {
		this.paccDTO = paccDTO;
	}
	public List<EscursioneDTO> getEsclis() {
		return esclis;
	}
	public void setEsclis(List<EscursioneDTO> esclis) {
		this.esclis = esclis;
	}
	
	public List<MezzoDTO> getMezziLis() {
		return mezziLis;
	}
	public void setMezziLis(List<MezzoDTO> mezziLis) {
		this.mezziLis = mezziLis;
	}
	public List<AlbergoDTO> getAlbergoLis() {
		return albergoLis;
	}
	public void setAlbergoLis(List<AlbergoDTO> albergoLis) {
		this.albergoLis = albergoLis;
	}
	
	public EscursioneDTO[] getEscScelte() {
		return escScelte;
	}
	public void setEscScelte(EscursioneDTO[] escScelte) {
		this.escScelte = escScelte;
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
	public MezzoMgr getMezzoMgr() {
		return mezzoMgr;
	}
	public void setMezzoMgr(MezzoMgr mezzoMgr) {
		this.mezzoMgr = mezzoMgr;
	}
	public EscursioneMgr getEscMgr() {
		return escMgr;
	}
	public void setEscMgr(EscursioneMgr escMgr) {
		this.escMgr = escMgr;
	}
	public AlbergoMgr getAlbMgr() {
		return albMgr;
	}
	public void setAlbMgr(AlbergoMgr albMgr) {
		this.albMgr = albMgr;
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
        setEsclis(escMgr.getEscursioniAl());
        setAlbergoLis(albMgr.getAlbergoAl());
        setLuogoLis(luogoMgr.getLuoghiAl());
        setMezziLis(mezzoMgr.getMezzo());
        
    }
    
public String add() {
		ArrayList<Integer>esc=new ArrayList<Integer>();
		Integer a=1;
		paccDTO.setIdLuogo(dest);
		paccDTO.setIdMezzoAndata(mezzoA);
		paccDTO.setIdMezzoRitorno(mezzoB);
		
		for(int i=0;i<escScelte.length;i++)
		{	System.out.println("sono al ciclo"+i);
			esc.add(escScelte[i].getId());
			System.out.println("sono al ciclo"+i);
		}
		paccMgr.save(paccDTO,esc);
		return "sceltaInserimento?faces-redirect=true";
	}
    
}
