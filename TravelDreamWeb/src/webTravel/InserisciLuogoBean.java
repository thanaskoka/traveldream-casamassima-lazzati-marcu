package webTravel;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.LuogoMgr;
import model.TipologiaLuogo;
import model.dto.LuogoDTO;

@ManagedBean(name="registerLuogoBean")
@RequestScoped
public class InserisciLuogoBean {
	
	
	@EJB 
	private LuogoMgr luogoMgr;
	
	private LuogoDTO luogoDto;
	
	private ArrayList<TipologiaLuogo> tipologie;
	private String tipoogiascelta;
	private TipologiaLuogo tip;
	
	


	@PostConstruct
    public void init()
    { 	tipologie=new ArrayList<TipologiaLuogo>();
		luogoDto=new LuogoDTO();
        tip=new TipologiaLuogo();
        tip.setDescrizione("ALBERGO");
        tip.setId(1);
        tipologie.add(tip);
        tip=new TipologiaLuogo();
        tip.setDescrizione("ESCURSIONE");
        tip.setId(2);
        tipologie.add(tip);
        tip=new TipologiaLuogo();
        tip.setDescrizione("AEREOPORTO");
        tip.setId(3);
        tipologie.add(tip);
    }
	

	public LuogoDTO getLuogoDto() {
		return luogoDto;
	}

	public void setLuogoDto(LuogoDTO luogoDto) {
		this.luogoDto = luogoDto;
	}

	public ArrayList<TipologiaLuogo> getTipologie() {
		return tipologie;
	}

	public void setTipologie(ArrayList<TipologiaLuogo> tipologie) {
		this.tipologie = tipologie;
	}
	public String getTipoogiascelta() {
		return tipoogiascelta;
	}


	public void setTipoogiascelta(String tipoogiascelta) {
		this.tipoogiascelta = tipoogiascelta;
	}
	
	public void save() throws IOException{
		luogoDto.setDescrizione(tipoogiascelta);
		luogoMgr.save(luogoDto);
		FacesContext.getCurrentInstance().getExternalContext().redirect("luoghiLis.xhtml");
		
	}

}
