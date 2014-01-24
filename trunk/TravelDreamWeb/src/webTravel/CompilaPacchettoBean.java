package webTravel;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.AcquistapacchettoMgr;
import model.CameraMgr;
import model.CamerePacchettoMgr;
import model.PacchettoMgr;
import model.dto.AcquistapacchettoDTO;
import model.dto.CameraDTO;
@ManagedBean(name="compilaBean")

@ViewScoped
public class CompilaPacchettoBean {
	
	
	@EJB
    private PacchettoMgr paccMgr;
	@EJB
	private CameraMgr camMgr;
	@EJB
	private AcquistapacchettoMgr acqPacMgr;
	
	
        
	private int n1=1;
	private int n2;
	private int n3;
	private int idpacc;
	private int idAlb;
	private int numPers=1;
	private CameraDTO c1;
	private AcquistapacchettoDTO paccAcq;
	
	
	
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
		idpacc=Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idP"));
		//idpacc=((idpacc-100)/2);
		idAlb=Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idA"));
		//idAlb=((idAlb-100)/2);
		
		/*System.out.println("singolealbe:"+camMgr.getSingole(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getDoppie(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getTriple(idAlb).getNrCamera());
		System.out.println("singolealbe:"+camMgr.getSingole(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getDoppie(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getTriple(idAlb).getNrCamera());
		System.out.println("singolealbe:"+camMgr.getSingole(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getDoppie(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getTriple(idAlb).getNrCamera());*/
    }
	
	public void acqusita() throws IOException{
		System.out.println("singolealbe:"+camMgr.getSingole(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getDoppie(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getTriple(idAlb).getNrCamera());
		System.out.println("singolealbe:"+camMgr.getSingole(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getDoppie(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getTriple(idAlb).getNrCamera());
		System.out.println("singolealbe:"+camMgr.getSingole(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getDoppie(idAlb).getNrCamera());
		System.out.println("doppiealbe:"+camMgr.getTriple(idAlb).getNrCamera());
		//se i posti non sono sufficenti ritono errore
		if((camMgr.getSingole(idAlb).getNrCamera()<n1)||(camMgr.getDoppie(idAlb).getNrCamera()<n2)||(camMgr.getTriple(idAlb).getNrCamera()<n3))	
			FacesContext.getCurrentInstance().getExternalContext().redirect("noCamDisp.xhtml");
		
		else{
		//altrimenti aggiorno numero camere dell'albergo
		c1=new CameraDTO();
		c1.setCostoPersoneCam(camMgr.getSingole(idAlb).getCostoPersoneCam());
		c1.setIdAlbergo(camMgr.getSingole(idAlb).getIdAlbergo());
		c1.setIdCamera(camMgr.getSingole(idAlb).getIdCamera());
		c1.setNrCamera(camMgr.getSingole(idAlb).getNrCamera()-n1);
		c1.setNumPersCam(1);
		
		camMgr.updateNrCamere(c1);	
		if(n2>0){
		c1=new CameraDTO();
		c1.setCostoPersoneCam(camMgr.getDoppie(idAlb).getCostoPersoneCam());
		c1.setIdAlbergo(camMgr.getDoppie(idAlb).getIdAlbergo());
		c1.setIdCamera(camMgr.getDoppie(idAlb).getIdCamera());
		c1.setNrCamera(camMgr.getSingole(idAlb).getNrCamera()-n2);
		c1.setNumPersCam(2);
		camMgr.updateNrCamere(c1);	}
		if(n3>0){
		c1=new CameraDTO();
		c1.setCostoPersoneCam(camMgr.getTriple(idAlb).getCostoPersoneCam());
		c1.setIdAlbergo(camMgr.getTriple(idAlb).getIdAlbergo());
		c1.setIdCamera(camMgr.getTriple(idAlb).getIdCamera());
		c1.setNrCamera(camMgr.getSingole(idAlb).getNrCamera()-n3);
		c1.setNumPersCam(3);
		camMgr.updateNrCamere(c1);	}
		paccAcq=new AcquistapacchettoDTO();
		
		paccAcq.setIdPacchetto(idpacc);
		
		paccAcq.setIdUtente((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email"));
		paccAcq.setNumPers(numPers);
		acqPacMgr.save(paccAcq);
		
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("acquistoOk.xhtml");
		
		}
		
	
	}
	
	
	
	
}