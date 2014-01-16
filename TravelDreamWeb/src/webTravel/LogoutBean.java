package webTravel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class LogoutBean {
        
        public String logout() {
        	
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");System.out.println("ho fatto logout");
            return "/home?faces-redirect=true";
          }


}
