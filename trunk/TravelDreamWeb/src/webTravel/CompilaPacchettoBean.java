package webTravel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.CamerePacchettoMgr;
import model.PacchettoMgr;
@ManagedBean(name="compilaBean")

@ViewScoped
public class CompilaPacchettoBean {
	
	
	@EJB
    private PacchettoMgr paccMgr;
	@EJB
	private CamerePacchettoMgr camPackMgr;
	
	
	
        
	private int n1=1;
	private int n2;
	private int n3;
	private int idpacc;
	private int numPers=1;
	
	
	
	
	
	public int getNumPers() {
		return numPers;
	}
	public void setNumPers(int numPers) {
		this.numPers = numPers;
	}
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	public int getN3() {
		return n3;
	}
	public void setN3(int n3) {
		this.n3 = n3;
	}
	
	
	@PostConstruct
    public void init()
    {	
		//idpacc=Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idP"));
		idpacc=(idpacc-100)/2;
    }
	
	public void acqusita(){
		
		
			
	
	}
	
	
	
}