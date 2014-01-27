package webTravel;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.AderiscegiftlistMgr;
import model.GiftlistMgr;
import model.PartecipaPacchettoMgr;
import model.dto.AderiscegiftlistDTO;
import model.dto.GiftlistDTO;
import model.dto.PartecipaPacchettoDTO;

@ManagedBean(name="giftBean")

@ViewScoped
public class GiftListBean {

	private Emailer email;
	private String amico1;
	private String amico2;
	private String amico3;
	private String amico4;
	private ArrayList<String> Amici;
	private int idPacc;
	private int idGift;
	private String url;
	 @EJB
	 PartecipaPacchettoMgr ppMgr;
	 @EJB
	 GiftlistMgr gifMgr;
	 @EJB
	 AderiscegiftlistMgr adegifMgr;
	 
	 GiftlistDTO gifDTO;
	 AderiscegiftlistDTO adegifDTO;
	
	public String getAmico1() {
		return amico1;
	}


	public void setAmico1(String amico1) {
		this.amico1 = amico1;
	}


	public String getAmico2() {
		return amico2;
	}


	public void setAmico2(String amico2) {
		this.amico2 = amico2;
	}


	public String getAmico3() {
		return amico3;
	}


	public void setAmico3(String amico3) {
		this.amico3 = amico3;
	}


	public String getAmico4() {
		return amico4;
	}


	public void setAmico4(String amico4) {
		this.amico4 = amico4;
	}


	public ArrayList<String> getAmici() {
		return Amici;
	}


	public void setAmici(ArrayList<String> amici) {
		Amici = amici;
	}
	
	@PostConstruct
	public void init(){
		
		String user;
		FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        user = externalContext.getUserPrincipal().getName();
		idPacc=Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		gifDTO=new GiftlistDTO();
		gifDTO.setIdPack(idPacc);
		gifDTO.setIdUser(user);
		gifMgr.save(gifDTO);
		idGift=gifMgr.returnLast().getIdGiftlist();
		url="http://localhost:8080/TravelDreamWeb/showGift.xhtml?id="+idGift;
	
	}
	
	
	public void invita(){
		PartecipaPacchettoDTO ppDto;
		if(!(amico1.isEmpty())){
			email=new Emailer(amico1,"Invito a regalarmi una parte del mio sogno","Guarda la mia giftlist e,se vuoi,contribuisci !!"+url);
			adegifDTO=new AderiscegiftlistDTO();
			adegifDTO.setIdGift(idGift);
			adegifDTO.setIdUtente(amico1);
			adegifMgr.save(adegifDTO);
		}
		if(!(amico2.isEmpty())){
			email=new Emailer(amico2,"Invito a regalarmi una parte del mio sogno","Guarda la mia giftlist e,se vuoi,contribuisci !!"+url);
			adegifDTO=new AderiscegiftlistDTO();
			adegifDTO.setIdGift(idGift);
			adegifDTO.setIdUtente(amico2);
			adegifMgr.save(adegifDTO);
		}
		if(!(amico3.isEmpty())){
			email=new Emailer(amico3,"Invito a regalarmi una parte del mio sogno","Guarda la mia giftlist e,se vuoi,contribuisci !!"+url);
			adegifDTO=new AderiscegiftlistDTO();
			adegifDTO.setIdGift(idGift);
			adegifDTO.setIdUtente(amico3);
			adegifMgr.save(adegifDTO);
		}
		if(!(amico4.isEmpty())){
			email=new Emailer(amico4,"Invito a regalarmi una parte del mio sogno","Guarda la mia giftlist e,se vuoi,contribuisci !!"+url);
			adegifDTO=new AderiscegiftlistDTO();
			adegifDTO.setIdGift(idGift);
			adegifDTO.setIdUtente(amico4);
			adegifMgr.save(adegifDTO);
		}
			
		
		
		/*for(int i=0;i<Amici.size();i++)
		{
			if(Amici.get(i)!=null)
				email=new Emailer(Amici.get(i),"Invito a vedere il mio pacchetto","Guarda il pacchetto che ho appena acquistato su TravelDream e ,se vuoi,acquistalo pure tu!!"+url);
			
		}*/
	}
	
	
	
}
