package webTravel;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="invitaAmicoBean")

@ViewScoped
public class InvitaAmicoBean {

	
	private Emailer email;
	private String amico1;
	private String amico2;
	private String amico3;
	private String amico4;
	private ArrayList<String> Amici;
	private int idPacc;
	private String url;
	
	
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
		
		//Amici=new ArrayList<String>();
		idPacc=Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		url="http://localhost:8080/TravelDreamWeb/showPack.xhtml?id="+idPacc;
	
	}
	
	
	public void invita(){
		
		if(amico1!=null)
			email=new Emailer(amico1,"Invito a vedere il mio pacchetto","Guarda il pacchetto che ho appena acquistato su TravelDream e ,se vuoi,acquistalo pure tu!!"+url);
		if(amico2!=null)
			email=new Emailer(amico2,"Invito a vedere il mio pacchetto","Guarda il pacchetto che ho appena acquistato su TravelDream e ,se vuoi,acquistalo pure tu!!"+url);
		if(amico3!=null)
			email=new Emailer(amico3,"Invito a vedere il mio pacchetto","Guarda il pacchetto che ho appena acquistato su TravelDream e ,se vuoi,acquistalo pure tu!!"+url);
		if(amico4!=null)	
			email=new Emailer(amico1,"Invito a vedere il mio pacchetto","Guarda il pacchetto che ho appena acquistato su TravelDream e ,se vuoi,acquistalo pure tu!!"+url);
		
		
		/*for(int i=0;i<Amici.size();i++)
		{
			if(Amici.get(i)!=null)
				email=new Emailer(Amici.get(i),"Invito a vedere il mio pacchetto","Guarda il pacchetto che ho appena acquistato su TravelDream e ,se vuoi,acquistalo pure tu!!"+url);
			
		}*/
	}
	
	
	
}
