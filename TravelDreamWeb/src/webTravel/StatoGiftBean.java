package webTravel;

import java.util.ArrayList;
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
import model.StatoPagamento;
import model.StoricopagamentiMgr;
import model.pacchettoConvert;
import model.dto.GiftlistDTO;
import model.dto.PacchettoDTO;
import model.dto.StoricoPagamentiDTO;

@ManagedBean(name="statoGiftBean")
@ViewScoped
public class StatoGiftBean {
	
	
	@EJB
	private StoricopagamentiMgr stormgr;
	@EJB
	private PacchettoMgr paccMgr;
	@EJB
	private GiftlistMgr giftMgr;
	@EJB
    private LuogoMgr luogoMgr;
	@EJB
    private EscursioneMgr escMgr;
	@EJB
    private AlbergoMgr albMgr;	
	@EJB
    private MezzoMgr mezzoMgr;	
	private GiftlistDTO gifDTO;
	private PacchettoDTO paccDto;
	private List<PacchettoDTO>packLis;
	private List<GiftlistDTO>giflis;
	private List<pacchettoConvert>paccconv;
	private pacchettoConvert paccSel;
	private pacchettoConvert pacc;
	private StatoPagamento statoPag;
	private String user;
	private StoricoPagamentiDTO storicDto;
	
	@PostConstruct
	public void init() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		user = externalContext.getUserPrincipal().getName();
		setGiflis(giftMgr.getGiftlistUser(user));
		packLis=new ArrayList<PacchettoDTO>();
		for(int i=0;i<giflis.size();i++){
			
			packLis.add(paccMgr.getPacchettoById(giflis.get(i).getIdPack()));
		}
		paccconv=new ArrayList<pacchettoConvert>();
		for(int i=0;i<packLis.size();i++)
		{	
			pacc=new pacchettoConvert();
			pacc.setId(packLis.get(i).getIdPacchetto());
			pacc.setAlbergo((albMgr.getNomeById(packLis.get(i).getIdAlbergo()).getNome()));
			pacc.setVoloAndata((mezzoMgr.returnData(packLis.get(i).getIdMezzoAndata()).getDataInizio()));
			pacc.setVoloRitorno((mezzoMgr.returnData(packLis.get(i).getIdMezzoRitorno()).getDataInizio()));
			pacc.setIdAlb(packLis.get(i).getIdAlbergo());
			pacc.setIdgif(packLis.get(i).getIdGif());
			pacc.setLuogo((luogoMgr.getCittaFromId(packLis.get(i).getIdLuogo()).getCitta()));
			paccconv.add(pacc);
		}
		
		
	}
	
	
	
	public void showStato(){
		statoPag=new StatoPagamento();
		if( stormgr.findVoloPagato(paccSel.getIdgif(), 1)==0){
			statoPag.setViaggio("NON PAGATO");
		}
		else
			statoPag.setViaggio("PAGATO");
		
		if( stormgr.findAlbergoPagato(paccSel.getIdgif())==0){
			statoPag.setAlbergo("NON PAGATO");
		}
		else
			statoPag.setAlbergo("PAGATO");
		if( stormgr.findEscursionePagata(paccSel.getIdgif(), 1)==0){
			statoPag.setEscursioni("NON PAGATO");
		}
		else
			statoPag.setEscursioni("PAGATO");
		
		
		
	}
	public StatoPagamento getStatoPag() {
		return statoPag;
	}



	public void setStatoPag(StatoPagamento statoPag) {
		this.statoPag = statoPag;
	}



	public void pagaTutto(){
		if( stormgr.findVoloPagato(paccSel.getIdgif(), 1)==0){
			storicDto=new StoricoPagamentiDTO();
			storicDto.setViaggio((byte) 1);
			storicDto.setGiftId((paccSel.getIdgif()));
			storicDto.setUserId(user);
			stormgr.save(storicDto);
			
			
		}
		if( stormgr.findAlbergoPagato(paccSel.getIdgif())==0){
			storicDto=new StoricoPagamentiDTO();
			storicDto.setAlbergo((byte) 1);
			storicDto.setGiftId(paccSel.getIdgif());
			storicDto.setUserId(user);
			stormgr.save(storicDto);}
		
		if((escMgr.getEscursioniPacchetto(paccSel.getId()).size()>0)){
			if( stormgr.findEscursionePagata(paccSel.getIdgif(), 1)==0){
				storicDto=new StoricoPagamentiDTO();
				storicDto.setEscursione((byte) 1);
				storicDto.setGiftId(paccSel.getIdgif());
				storicDto.setUserId(user);
				stormgr.save(storicDto);
				
			}
			
		}
		
		
	}
	
	public List<pacchettoConvert> getPaccconv() {
		return paccconv;
	}

	public void setPaccconv(List<pacchettoConvert> paccconv) {
		this.paccconv = paccconv;
	}

	public pacchettoConvert getPaccSel() {
		return paccSel;
	}

	public void setPaccSel(pacchettoConvert paccSel) {
		this.paccSel = paccSel;
	}


	public GiftlistDTO getGifDTO() {
		return gifDTO;
	}

	public void setGifDTO(GiftlistDTO gifDTO) {
		this.gifDTO = gifDTO;
	}

	public PacchettoDTO getPaccDto() {
		return paccDto;
	}

	public void setPaccDto(PacchettoDTO paccDto) {
		this.paccDto = paccDto;
	}

	public List<PacchettoDTO> getPaccLis() {
		return packLis;
	}

	public void setPaccLis(List<PacchettoDTO> paccLis) {
		this.packLis = paccLis;
	}

	public List<GiftlistDTO> getGiflis() {
		return giflis;
	}

	public void setGiflis(List<GiftlistDTO> giflis) {
		this.giflis = giflis;
	}

}
