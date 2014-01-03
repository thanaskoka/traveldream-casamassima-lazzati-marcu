package webTravel;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.MezzoMgr;

import model.dto.MezzoDTO;

@ManagedBean(name="registerMezzoBean")
@RequestScoped
public class RegisterMezzoBean {
	

	@EJB
	private MezzoMgr mezzoMgr;

	private MezzoDTO mezzo;
	
	public RegisterMezzoBean() {
		mezzo = new MezzoDTO();
	}

	public MezzoDTO getUser() {
		return mezzo;
	}

	public void setUser(MezzoDTO m) {
		this.mezzo = m;
	}
	
	public String register() {
		mezzoMgr.save(mezzo);
		return "sceltaInserimento?faces-redirect=true";
	}

}
