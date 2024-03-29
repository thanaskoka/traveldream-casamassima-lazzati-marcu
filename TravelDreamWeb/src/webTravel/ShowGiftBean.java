package webTravel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.AlbergoMgr;
import model.EscursioneMgr;
import model.GiftlistMgr;
import model.LuogoMgr;
import model.MezzoMgr;
import model.PacchettoMgr;
import model.pacchettoConvert;
import model.dto.AlbergoDTO;
import model.dto.EscursioneDTO;
import model.dto.LuogoDTO;
import model.dto.PacchettoDTO;

@ManagedBean(name="showGifBean")
@ViewScoped
public class ShowGiftBean {

	  private int id;
	  private int idg;
	private int par;
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
	  private GiftlistMgr gifMgr;
	
	private PacchettoDTO paccDTO;
	private LuogoDTO luoDTO;
	private AlbergoDTO albDTO;
	private List<PacchettoDTO> packLis;
	private List<EscursioneDTO> escLis;
	private ArrayList<pacchettoConvert>pacchetticonv;
	private pacchettoConvert pacc;

	private pacchettoConvert selectPack;
	private String destinazione;
	private Date dataP;
	private String user;
	public ShowGiftBean() {
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
  {	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
  	
	idg=Integer.parseInt(request.getParameter("idG"));	
	id=gifMgr.returnIdPacc(idg).getIdPack();
      
		
		packLis=new ArrayList<PacchettoDTO>();
      pacchetticonv=new ArrayList<pacchettoConvert>();
		packLis.add(paccMgr.getPacchettoById(id));
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
		setEscLis(escMgr.getEscursioniPacchetto(pacchetticonv.get(0).getId()));
		
		
	}
	
	public String procedi(){
		
		 /*int id=(selectPack.getId()+100)*2;
		 int idAl=(selectPack.getIdAlb()+100)*2;*/
		
		return "user/showInvitiGift?faces-redirect=true&user=true";
	}
	 


}



