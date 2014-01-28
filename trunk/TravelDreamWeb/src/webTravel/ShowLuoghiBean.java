package webTravel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.LuogoMgr;
import model.dto.LuogoDTO;

@ManagedBean(name="showLuoghi")
@RequestScoped

public class ShowLuoghiBean {
	
	@EJB 
	private LuogoMgr luogoMgr;
	
	private List<LuogoDTO> luoghilis;
	
	@PostConstruct
    public void init()
    {	
        setLuoghilis(luogoMgr.getTuttiLuoghi());
    }

	public List<LuogoDTO> getLuoghilis() {
		return luoghilis;
	}

	public void setLuoghilis(List<LuogoDTO> luoghilis) {
		this.luoghilis = luoghilis;
	}
	

}
