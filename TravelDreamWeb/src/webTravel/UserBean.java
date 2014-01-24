package webTravel;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.UserMgr;

@ManagedBean
@RequestScoped
public class UserBean {
	
	@EJB
	private UserMgr userMgr;
	
	public String getName() {
		return userMgr.getUserDTO().getFirstName();
	}
	
	public String getEmail() {
		return userMgr.getUserDTO().getEmail();
	}
}
