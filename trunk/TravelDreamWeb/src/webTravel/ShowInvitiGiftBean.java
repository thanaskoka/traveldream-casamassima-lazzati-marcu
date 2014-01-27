package webTravel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.AlbergoMgr;
import model.EscursioneMgr;
import model.GiftlistMgr;
import model.LuogoMgr;
import model.MezzoMgr;
import model.PacchettoMgr;
import model.StoricopagamentiMgr;
import model.pacchettoConvert;
import model.dto.AlbergoDTO;
import model.dto.EscursioneDTO;
import model.dto.GiftlistDTO;
import model.dto.LuogoDTO;
import model.dto.PacchettoDTO;
import model.dto.StoricoPagamentiDTO;

@ManagedBean(name="invitiGifBean")

@RequestScoped
public class ShowInvitiGiftBean {
	
	private int par;
	private int idGif;
	@EJB
    private PacchettoMgr paccMgr;
	@EJB
    private LuogoMgr luogoMgr;
	@EJB
    private EscursioneMgr escMgr;
	@EJB
    private AlbergoMgr albMgr;	
	@EJB
    private MezzoMgr mezzoMgr;	
	@EJB
    private GiftlistMgr giftMgr;	
	@EJB
	private StoricopagamentiMgr stormgr;
	
	private List<GiftlistDTO>giflis;
	private PacchettoDTO paccDTO;
	private LuogoDTO luoDTO;
	private AlbergoDTO albDTO;
	private List<PacchettoDTO> packLis;
	private List<EscursioneDTO> escLis;
	private ArrayList<pacchettoConvert>pacchetticonv;
	private pacchettoConvert pacc;
	private StoricoPagamentiDTO storicDto;
	
	private pacchettoConvert selectPack;
	private String destinazione;
	private Date dataP;
	private String user;
	public ShowInvitiGiftBean() {
		paccDTO = new PacchettoDTO();
	}
	
	public int getPar() {
		return par;
	}
	public void setPar(int par) {
		this.par = par;
	}
	public PacchettoMgr getPaccMgr() {
		return paccMgr;
	}
	public void setPaccMgr(PacchettoMgr paccMgr) {
		this.paccMgr = paccMgr;
	}
	public PacchettoDTO getPaccDTO() {
		return paccDTO;
	}
	public void setPaccDTO(PacchettoDTO paccDTO) {
		this.paccDTO = paccDTO;
	}
	public List<PacchettoDTO> getPackLis() {
		return packLis;
	}
	public void setPackLis(List<PacchettoDTO> packLis) {
		this.packLis = packLis;
	}
	
	public String getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	public Date getDataP() {
		return dataP;
	}
	public void setDataP(Date dataP) {
		this.dataP = dataP;
	}
	public List<EscursioneDTO> getEscLis() {
		return escLis;
	}

	public void setEscLis(List<EscursioneDTO> escLis) {
		this.escLis = escLis;
	}
	@PostConstruct
    public void init()
    {	pacchetticonv=new ArrayList<pacchettoConvert>();
		FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        user = externalContext.getUserPrincipal().getName();
        
       
        giflis=giftMgr.returnIdPaccs(user);
        packLis=new ArrayList<PacchettoDTO>();
        for(int i=0;i<giflis.size();i++)
        {
        	packLis.add(paccMgr.getPacchettoById((giflis.get(i).getIdPack())));
        	
        	
        }
        
        for(int i=0;i<packLis.size();i++)
		{	
			pacc=new pacchettoConvert();
			pacc.setId(packLis.get(i).getIdPacchetto());
			pacc.setAlbergo((albMgr.getNomeById(packLis.get(i).getIdAlbergo()).getNome()));
			pacc.setVoloAndata((mezzoMgr.returnData(packLis.get(i).getIdMezzoAndata()).getDataInizio()));
			pacc.setVoloRitorno((mezzoMgr.returnData(packLis.get(i).getIdMezzoRitorno()).getDataInizio()));
			pacc.setIdAlb(packLis.get(i).getIdAlbergo());
			pacc.setLuogo((luogoMgr.getCittaFromId(packLis.get(i).getIdLuogo()).getCitta()));
			pacchetticonv.add(pacc);
		}
	
    }
	
	
	
	public ArrayList<pacchettoConvert> getPacchetticonv() {
		return pacchetticonv;
	}

	public void setPacchetticonv(ArrayList<pacchettoConvert> pacchetticonv) {
		this.pacchetticonv = pacchetticonv;
	}

	public pacchettoConvert getPacc() {
		return pacc;
	}

	public void setPacc(pacchettoConvert pacc) {
		this.pacc = pacc;
	}

	public pacchettoConvert getSelectPack() {
		return selectPack;
	}

	public void setSelectPack(pacchettoConvert selectPack) {
		this.selectPack = selectPack;
	}

	
	
	public void showEscursioniPacc(){
		escLis=new ArrayList<EscursioneDTO>();
		setEscLis(escMgr.getEscursioniPacchetto(selectPack.getId()));
		
		
	}
	
	public void pagavolo() throws IOException{
		int giftid=giftMgr.returnIdGif(selectPack.getId(), user).getIdGiftlist();
		FacesMessage msg = null;  
		if( stormgr.findVoloPagato(giftid, 1)==0){
			storicDto=new StoricoPagamentiDTO();
			storicDto.setViaggio((byte) 1);
			storicDto.setGiftId(giftid);
			storicDto.setUserId(user);
			stormgr.save(storicDto);
			msg = new FacesMessage("Hai appena Pagato il volo al tuo amico");  
			
		}
		else
		{
			msg = new FacesMessage( "Il volo � gia stato pagato,cambia!");  
			
			
		}
		FacesContext.getCurrentInstance().addMessage(null, msg); 
		
	}
	public void pagaalbergo() throws IOException{
		FacesMessage msg = null; 
		int giftid=giftMgr.returnIdGif(selectPack.getId(), user).getIdGiftlist();
		if( stormgr.findAlbergoPagato(giftid)==0){
			storicDto=new StoricoPagamentiDTO();
			storicDto.setAlbergo((byte) 1);
			storicDto.setGiftId(giftid);
			storicDto.setUserId(user);
			stormgr.save(storicDto);
			msg = new FacesMessage("Hai appena Pagato l'albergo al tuo amico");  
		}
		else
		{
			msg = new FacesMessage( "L'albergo � gia stato pagato,cambia!"); 
			
			
		}
		FacesContext.getCurrentInstance().addMessage(null, msg); 
		
	}
	public void pagaescursioni() throws IOException{
		FacesMessage msg = null;
		int giftid=giftMgr.returnIdGif(selectPack.getId(), user).getIdGiftlist();
		if((escMgr.getEscursioniPacchetto(selectPack.getId()).size()>0)){
		if( stormgr.findEscursionePagata(giftid, 1)==0){
			storicDto=new StoricoPagamentiDTO();
			storicDto.setEscursione((byte) 1);
			storicDto.setGiftId(giftid);
			storicDto.setUserId(user);
			stormgr.save(storicDto);
			msg = new FacesMessage("Hai appena Pagato le escursioni al tuo amico");  
		}
		else
		{
			msg = new FacesMessage( "Escursioni sono gia state pagate,cambia!"); 
			
			
		}
		}
		else 
			msg = new FacesMessage( "Non ci sono escursioni associate a questo pacchetto!!"); 
		
		FacesContext.getCurrentInstance().addMessage(null, msg);  
		
	}

}


