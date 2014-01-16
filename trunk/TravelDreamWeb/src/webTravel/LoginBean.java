package webTravel;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.inject.Inject;



import org.primefaces.context.RequestContext;

import model.UserMgr;
import model.dto.UserDTO;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {  
          
    private String username;  
      
    private String password;  
    
    @Inject
    private UserDTO userSession; 
    
    @EJB
    private UserMgr userManager;
      
    public UserDTO getUserSession(){
        return this.userSession;
    }
    
    public void setUserSession(UserDTO userSession){
        this.userSession=userSession;
    }
    
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public String login() {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false; 
        userSession = userManager.returnUser(username, password);
        if(userSession!=null) {
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);  
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
        }  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
        /*if (userSession.getDip()){
                return ("/employee/index?faces-redirect=true");
        }*/
        return ("user/index?faces-redirect=true");
       
    }  
} 