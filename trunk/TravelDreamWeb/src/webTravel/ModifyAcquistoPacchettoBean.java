package webTravel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.AcquistapacchettoMgr;
import model.AlbergoMgr;
import model.EscursioneMgr;
import model.LuogoMgr;
import model.MezzoMgr;
import model.PacchettoMgr;
import model.dto.AcquistapacchettoDTO;
import model.dto.AlbergoDTO;
import model.dto.EscursioneDTO;
import model.dto.LuogoDTO;
import model.dto.MezzoDTO;
import model.dto.PacchettoDTO;

@ManagedBean(name="modifyPackBean")

@ViewScoped
public class ModifyAcquistoPacchettoBean {
	
	private int numPartecipanti;
    private int numMaxPosti;
    private int numMaxCamere;
    private float costoTotale;
    private int luogoA=2;
    private int luogoP=4;
    private int mezzoA=-1;
    private int mezzoB=-1;
    private int hotel=-1;
    private Date dataA;
    private Date dataP;
    private LuogoDTO luogoAppoggio;
    private int idPacchettoAcquistato;
    
    @EJB
    private MezzoMgr mezzoMgr;
    @EJB
    private EscursioneMgr escMgr;
    @EJB
    private AlbergoMgr albMgr;
    @EJB
    private LuogoMgr luogoMgr;
    @EJB
    private PacchettoMgr paccMgr;
    @EJB
    private AcquistapacchettoMgr acqpackMgr;
    
	private PacchettoDTO paccDTO;
	private AcquistapacchettoDTO acqpackDTO;
	private List<MezzoDTO> mezziLisAnd;
	private List<MezzoDTO> mezziLisRit;
	private List<AlbergoDTO>albergoLis;
	private List<EscursioneDTO>esclis;
	private EscursioneDTO[] escScelte;
	private List<LuogoDTO> luogoLis;
    
	
	public ModifyAcquistoPacchettoBean() {
		paccDTO = new PacchettoDTO();
		acqpackDTO = new AcquistapacchettoDTO();
	}
	
	
    public int getIdPacchettoAcquistato() {
		return idPacchettoAcquistato;
	}


	public void setIdPacchettoAcquistato(int idPacchettoAcquistato) {
		this.idPacchettoAcquistato = idPacchettoAcquistato;
	}


	public AcquistapacchettoDTO getAcqpackDTO() {
		return acqpackDTO;
	}


	public void setAcqpackDTO(AcquistapacchettoDTO acqpackDTO) {
		this.acqpackDTO = acqpackDTO;
	}


	public int getNumPartecipanti() {
		return numPartecipanti;
	}
	public void setNumPartecipanti(int numPartecipanti) {
		this.numPartecipanti = numPartecipanti;
	}
	public int getNumMaxPosti() {
		return numMaxPosti;
	}
	public void setNumMaxPosti(int numMaxPosti) {
		this.numMaxPosti = numMaxPosti;
	}
	public int getNumMaxCamere() {
		return numMaxCamere;
	}
	public void setNumMaxCamere(int numMaxCamere) {
		this.numMaxCamere = numMaxCamere;
	}
	public float getCostoTotale() {
		return costoTotale;
	}
	public void setCostoTotale(float costoTotale) {
		this.costoTotale = costoTotale;
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
	public int getHotel() {
		return hotel;
	}
	public void setHotel(int hotel) {
		this.hotel = hotel;
	}
	public PacchettoDTO getPaccDTO() {
		return paccDTO;
	}
	public void setPaccDTO(PacchettoDTO paccDTO) {
		this.paccDTO = paccDTO;
	}
	public List<MezzoDTO> getMezziLisAnd() {
		return mezziLisAnd;
	}
	public void setMezziLisAnd(List<MezzoDTO> mezziLisAnd) {
		this.mezziLisAnd = mezziLisAnd;
	}
	public List<MezzoDTO> getMezziLisRit() {
		return mezziLisRit;
	}
	public void setMezziLisRit(List<MezzoDTO> mezziLisRit) {
		this.mezziLisRit = mezziLisRit;
	}
	public List<AlbergoDTO> getAlbergoLis() {
		return albergoLis;
	}
	public void setAlbergoLis(List<AlbergoDTO> albergoLis) {
		this.albergoLis = albergoLis;
	}
	public List<EscursioneDTO> getEsclis() {
		return esclis;
	}
	public void setEsclis(List<EscursioneDTO> esclis) {
		this.esclis = esclis;
	}
	public List<LuogoDTO> getLuogoLis() {
		return luogoLis;
	}
	public void setLuogoLis(List<LuogoDTO> luogoLis) {
		this.luogoLis = luogoLis;
	}
	public EscursioneDTO[] getEscScelte() {
		return escScelte;
	}
	public void setEscScelte(EscursioneDTO[] escScelte) {
		this.escScelte = escScelte;
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
	public LuogoDTO getLuogoAppoggio() {
		return luogoAppoggio;
	}
	public void setLuogoAppoggio(LuogoDTO luogoAppoggio) {
		this.luogoAppoggio = luogoAppoggio;
	}
	
	
	
	
	
	
	
	@PostConstruct
    public void init()
    {	
		//dest =Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idD"));
    	//par =Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idP"));
		//System.out.println("entro");
		 setLuogoLis(luogoMgr.getLuoghi());
		 findAll();
    }
	private void findAll(){
		    setLuogoAppoggio(luogoMgr.getCittaFromId(luogoA));
	        setAlbergoLis(albMgr.getAlbergoByLuogo(luogoAppoggio.getCitta()));		 
			setMezziLisAnd(mezzoMgr.getMezzoViaggioAndataR(luogoA, luogoP,dataP));
			setMezziLisRit(mezzoMgr.getMezzoViaggioAndataA(luogoP, luogoA,dataA));
			
	       // System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);System.out.println("dest"+dest);
			setEsclis(escMgr.getEscursioniLuogo(luogoAppoggio.getCitta(),dataA,dataP));
	}
	
	
    
	public String modify() {
		ArrayList<Integer>esc=new ArrayList<Integer>();
		acqpackDTO = acqpackMgr.getAcquistapacchettoById(idPacchettoAcquistato);
		paccDTO = paccMgr.getPacchettoById(acqpackDTO.getIdPacchetto());
		
		for(int i=0;i<escScelte.length;i++)
			esc.add(escScelte[i].getId());
		
		//se il pacchetto non è ancora stato modificato creo un nuovo record nel database
		if(paccDTO.getIsModify() == 0){
			PacchettoDTO newpaccDTO = new PacchettoDTO();
			newpaccDTO.setIdLuogo(paccDTO.getIdLuogo());
			newpaccDTO.setTitolo(paccDTO.getTitolo());
			newpaccDTO.setIdAlbergo(hotel);
			newpaccDTO.setIdMezzoAndata(mezzoA);
			newpaccDTO.setIdMezzoRitorno(mezzoB);
			newpaccDTO.setIsModify((byte)1);
					
			paccMgr.save(newpaccDTO,esc);
		}
		//altrimenti modifico il record esistente
		else{
			paccDTO.setIdAlbergo(hotel);
			paccDTO.setIdMezzoAndata(mezzoA);
			paccDTO.setIdMezzoRitorno(mezzoB);
						
			paccMgr.update(paccDTO, esc);
		}
		return "index?faces-redirect=true";
	}
	
}
