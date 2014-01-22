package webTravel;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

@ViewScoped
public class AddPacchettoBean {
	
	
	private int dest;
	
	private int par;
	@EJB
    private PacchettoMgr paccMgr;
	private PacchettoDTO paccDTO;
	private List<MezzoDTO> mezziLisAnd;
	private List<MezzoDTO> mezziLisRit;
	

	private List<AlbergoDTO>albergoLis;
	private List<EscursioneDTO>esclis;
	private EscursioneDTO[] escScelte;
	private List<LuogoDTO> luogoLis;
    
	private int mezzoA=-1;
    private int mezzoB=-1;
    private int i=500;
   
   
    private int hotel=-1;
    private Date dataA;
    
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
	public List<MezzoDTO> getMezziLisRit() {
		return mezziLisRit;
	}
	public void setMezziLisRit(List<MezzoDTO> mezziLisRit) {
		this.mezziLisRit = mezziLisRit;
	}
	private Date dataP;
    private int luogoA;
    private int luogoP;
    private LuogoDTO luogoAppoggio;
    @EJB
    private MezzoMgr mezzoMgr;
    @EJB
    private EscursioneMgr escMgr;
    @EJB
    private AlbergoMgr albMgr;
    @EJB
    private LuogoMgr luogoMgr;
    
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
	
	public List<MezzoDTO> getMezziLisAnd() {
		return mezziLisAnd;
	}
	public void setMezziLisAnd(List<MezzoDTO> mezziLis) {
		this.mezziLisAnd = mezziLis;
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
		dest =Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idD"));
    	par =Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idP"));
		//System.out.println("entro");
        setLuogoLis(luogoMgr.getLuoghi());
        setLuogoAppoggio(luogoMgr.getCittaFromId(dest));
        setAlbergoLis(albMgr.getAlbergoByLuogo(luogoAppoggio.getCitta()));		 
		setMezziLisAnd(mezzoMgr.getMezzoViaggioAndata(par, dest));
		setMezziLisRit(mezzoMgr.getMezzoViaggioAndata(dest, par));
		
       // System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);
		setEsclis(escMgr.getEscursioniLuogo(luogoAppoggio.getCitta()));
    }
	
	
    
public String add() {
	
	//System.out.println("mezzoa:"+mezzoA+"mezzoB"+mezzoB+"esc scelta"+escScelte[0].getId());
	//System.out.println("mezzoa:"+mezzoA+"mezzoB"+mezzoB+"esc scelta"+escScelte[0].getId());System.out.println("mezzoa:"+mezzoA+"mezzoB"+mezzoB+"esc scelta"+escScelte[0].getId());System.out.println("mezzoa:"+mezzoA+"mezzoB"+mezzoB+"esc scelta"+escScelte[0].getId());System.out.println("mezzoa:"+mezzoA+"mezzoB"+mezzoB+"esc scelta"+escScelte[0].getId());System.out.println("mezzoa:"+mezzoA+"mezzoB"+mezzoB+"esc scelta"+escScelte[0].getId());System.out.println("mezzoa:"+mezzoA+"mezzoB"+mezzoB+"esc scelta"+escScelte[0].getId());
		ArrayList<Integer>esc=new ArrayList<Integer>();
		Integer a=1;
		paccDTO.setIdLuogo(dest);
		paccDTO.setIdMezzoAndata(mezzoA);
		paccDTO.setIdMezzoRitorno(mezzoB);
		
		for(int i=0;i<escScelte.length;i++)
		{	
			esc.add(escScelte[i].getId());
			
		}
		paccMgr.save(paccDTO,esc);
		return "index?faces-redirect=true";
	}
    
}

