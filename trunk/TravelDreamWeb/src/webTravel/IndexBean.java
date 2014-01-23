package webTravel;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.LuogoMgr;
import model.PacchettoMgr;
import model.dto.MezzoDTO;
import model.dto.PacchettoDTO;


@ManagedBean(name="indexBean")

@ViewScoped
public class IndexBean {
	
	
	private int par;
	@EJB
    private PacchettoMgr paccMgr;
	@EJB
    private LuogoMgr luogoMgr;
	private PacchettoDTO paccDTO;
	private List<PacchettoDTO> packLis;
	private PacchettoDTO selectPack;
	private String destinazione;
	private Date dataP;
	
	public IndexBean() {
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
	public PacchettoDTO getSelectPack() {
		return selectPack;
	}
	public void setSelectPack(PacchettoDTO selectPack) {
		this.selectPack = selectPack;
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
	@PostConstruct
    public void init()
    {	
		//dest =Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idD"));
    	//par =Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idP"));
		//System.out.println("entro");
		//int idluogo=luogoMgr.getidAereoportiFromcitta("roma").getId();
		//setPackLis(paccMgr.getPacchettiLuogoData(idluogo, dataP));
    }
	
	
	
	public void findPack(){
		System.out.println("sono quiiii");
		System.out.println("sono quiiii");System.out.println("sono quiiii");System.out.println("sono quiiii");System.out.println("sono quiiii");System.out.println("sono quiiii");System.out.println("sono quiiii");System.out.println("sono quiiii");System.out.println("sono quiiii");
		
		int idluogo=luogoMgr.getidAereoportiFromcitta(destinazione).getId();
		setPackLis(paccMgr.getPacchettiLuogoData(idluogo, dataP));
		
	
	}

}
