package webTravel;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;

import org.primefaces.event.RowEditEvent;

import model.AlbergoMgr;
import model.EscursioneMgr;
import model.LuogoMgr;
import model.dto.AlbergoDTO;
import model.dto.EscursioneDTO;
import model.dto.LuogoDTO;


@ManagedBean(name="showAlbergoModBean")
@RequestScoped
public class showModAlbergoBean {

	@EJB
	private AlbergoMgr albergoMgr;
	private AlbergoDTO albergo; 
	@EJB
	private LuogoMgr luogoMgr;
	
	
	private int id;
	private int idLuogo;
	private String nome;
	private int numeroStelle;
	
	private List<LuogoDTO> elelis;
	private List<AlbergoDTO> carsSmall;
	private AlbergoDTO selectalb;
	public AlbergoDTO getSelectalb() {
		return selectalb;
	}
	public void setSelectalb(AlbergoDTO selectalb) {
		this.selectalb = selectalb;
	}
	public AlbergoMgr getAlbergoMgr() {
		return albergoMgr;
	}
	public void setAlbergoMgr(AlbergoMgr albergoMgr) {
		this.albergoMgr = albergoMgr;
	}
	public AlbergoDTO getAlbergo() {
		return albergo;
	}
	public void setAlbergo(AlbergoDTO albergo) {
		this.albergo = albergo;
	}
	public LuogoMgr getLuogoMgr() {
		return luogoMgr;
	}
	public void setLuogoMgr(LuogoMgr luogoMgr) {
		this.luogoMgr = luogoMgr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdLuogo() {
		return idLuogo;
	}
	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroStelle() {
		return numeroStelle;
	}
	public void setNumeroStelle(int numeroStelle) {
		this.numeroStelle = numeroStelle;
	}
	public List<LuogoDTO> getElelis() {
		return elelis;
	}
	public void setElelis(List<LuogoDTO> elelis) {
		this.elelis = elelis;
	}
	public List<AlbergoDTO> getCarsSmall() {
		return carsSmall;
	}
	public void setCarsSmall(List<AlbergoDTO> carsSmall) {
		this.carsSmall = carsSmall;
	}
	
	@PostConstruct
    public void init()
    {
        setCarsSmall(albergoMgr.getAlbergoAl());
        setElelis(luogoMgr.getLuoghiAl());
    }
	
	public void modify() throws IOException{
		
		int idalb=selectalb.getId();
	
		FacesContext.getCurrentInstance().getExternalContext().redirect("modAl.xhtml?id="+idalb);
	}
	
	public void delete() throws IOException{
		int idalb=selectalb.getId();
		albergoMgr.cancellaAlbergo(idalb);
		FacesContext.getCurrentInstance().getExternalContext().redirect("showEditAlbergo.xhtml");
	}
	
	
}
