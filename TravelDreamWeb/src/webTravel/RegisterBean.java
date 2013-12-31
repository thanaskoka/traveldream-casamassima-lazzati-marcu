package webTravel;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.UserMgr;
import model.dto.UserDTO;

@ManagedBean(name="registerBean")
@RequestScoped
public class RegisterBean {
	
	@EJB
	private UserMgr userMgr;

	private UserDTO user;
	
	public RegisterBean() {
		user = new UserDTO();
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public String register() {
		userMgr.save(user);
		return "home?faces-redirect=true";
	}
}
