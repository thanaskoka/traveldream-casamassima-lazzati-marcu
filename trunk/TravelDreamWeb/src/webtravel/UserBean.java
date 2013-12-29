package webtravel;



import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import usermanager.UserMgr;

@ManagedBean
@RequestScoped
public class UserBean {
	
	@EJB
	private UserMgr userMgr;
	
	public String getName() {
		return userMgr.getUserDTO().getFirstName();
	}
}
