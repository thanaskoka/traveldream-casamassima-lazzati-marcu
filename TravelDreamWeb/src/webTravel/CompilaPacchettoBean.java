package webTravel;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.AcquistapacchettoMgr;
import model.CameraMgr;
import model.CamerePacchettoMgr;
import model.EscursioneMgr;
import model.EscursioniPacchettoMgr;
import model.MezzoMgr;
import model.PacchettoMgr;
import model.dto.AcquistapacchettoDTO;
import model.dto.CameraDTO;
import model.dto.CamerapacchettoDTO;
import model.dto.EscursioneDTO;
import model.dto.EscursioniPacchettoDTO;
import model.dto.MezzoDTO;
import model.dto.PacchettoDTO;

@ManagedBean(name = "compilaBean")
@ViewScoped
public class CompilaPacchettoBean {

	@EJB
	private PacchettoMgr paccMgr;
	@EJB
	private MezzoMgr mezzMgr;
	@EJB
	private CameraMgr camMgr;
	@EJB
	private AcquistapacchettoMgr acqPacMgr;
	@EJB
	private CamerePacchettoMgr campackMgr;
	@EJB
	private EscursioniPacchettoMgr escpackMgr;
	@EJB
	private EscursioneMgr escMgr;

	private int n1 = 0;
	private int n2 = 0;
	private int n3 = 0;
	private int idpacc;
	private int idAlb;
	private int numPers = 1;
	private CameraDTO c1;
	private PacchettoDTO pk;
	private EscursioneDTO esc;
	private AcquistapacchettoDTO paccAcq;
	private CamerapacchettoDTO camPackDTO;
	private String user;
	private float costo = 0;
	private MezzoDTO mezzoA,mezzoR;
	private ArrayList<EscursioniPacchettoDTO> escpk = new ArrayList<EscursioniPacchettoDTO>();
	
	

	public ArrayList<EscursioniPacchettoDTO> getEscpk() {
		return escpk;
	}

	public void setEscpk(ArrayList<EscursioniPacchettoDTO> escpk) {
		this.escpk = escpk;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

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
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();

		idpacc = Integer.parseInt(request.getParameter("idP"));
		idAlb = Integer.parseInt(request.getParameter("idA"));
	}
	
	public void calcola() throws IOException{
		fermaCamere();
		calcolaCosto();
	}
	
	public String acqusita() throws IOException {

		// se i posti non sono sufficenti ritono errore

		

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		user = externalContext.getUserPrincipal().getName();
		paccAcq = new AcquistapacchettoDTO();

		paccAcq.setIdPacchetto(idpacc);

		paccAcq.setIdUtente(user);
		paccAcq.setNumPers(numPers);
		acqPacMgr.save(paccAcq);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("acquistoOk.xhtml");
		} catch (IllegalStateException e) {
			return "index?faces-redirect=true";
		}

		return null;

	}

	private void fermaCamere() throws IOException {
		try {
			int num1 = camMgr.getSingole(idAlb).getNrCamera();
			int num2 = camMgr.getDoppie(idAlb).getNrCamera();
			int num3 = camMgr.getTriple(idAlb).getNrCamera();
			if ((num1 - n1 < 0) || (num2 - n2 < 0) || (num3 - n3 < 0))
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("noCamDisp.xhtml");
			if(n1==0&&n2==0&&n3==0){
				FacesContext.getCurrentInstance().getExternalContext()
				.redirect("noCameraSel.xhtml");
			}
			costo += camMgr.getSingole(idAlb).getCostoPersoneCam() * num1;
			costo += camMgr.getDoppie(idAlb).getCostoPersoneCam() * num2;
			costo += camMgr.getTriple(idAlb).getCostoPersoneCam() * num3;
			costo = costo * numPers;

		} catch (EJBException e) {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("noCamDisp.xhtml");
		}

		if (n1 > 0) {
			c1 = new CameraDTO();
			camPackDTO = new CamerapacchettoDTO();
			c1.setCostoPersoneCam(camMgr.getSingole(idAlb).getCostoPersoneCam());
			c1.setIdAlbergo(camMgr.getSingole(idAlb).getIdAlbergo());
			c1.setIdCamera(camMgr.getSingole(idAlb).getIdCamera());
			c1.setNrCamera(camMgr.getSingole(idAlb).getNrCamera() - n1);
			c1.setNumPersCam(1);
			camPackDTO.setIdPacchetto(idpacc);
			camPackDTO.setNumcamere(n1);
			camPackDTO.setNumposticamera(1);
			if (numPers > n1)
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("noCamDisp.xhtml");
			else {
				campackMgr.save(camPackDTO);
				camMgr.updateNrCamere(c1);
			}

		}

		if (n2 > 0) {
			c1 = new CameraDTO();
			camPackDTO = new CamerapacchettoDTO();
			c1.setCostoPersoneCam(camMgr.getDoppie(idAlb).getCostoPersoneCam());
			c1.setIdAlbergo(camMgr.getDoppie(idAlb).getIdAlbergo());
			c1.setIdCamera(camMgr.getDoppie(idAlb).getIdCamera());
			c1.setNrCamera(camMgr.getDoppie(idAlb).getNrCamera() - n2);
			c1.setNumPersCam(2);
			camMgr.updateNrCamere(c1);
			camPackDTO.setIdPacchetto(idpacc);
			camPackDTO.setNumcamere(n2);
			camPackDTO.setNumposticamera(2);
			if (numPers > 2 * n2)
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("noCamDisp.xhtml");
			else {
				campackMgr.save(camPackDTO);
				camMgr.updateNrCamere(c1);
			}

		}
		if (n3 > 0) {
			camPackDTO = new CamerapacchettoDTO();
			c1 = new CameraDTO();
			c1.setCostoPersoneCam(camMgr.getTriple(idAlb).getCostoPersoneCam());
			c1.setIdAlbergo(camMgr.getTriple(idAlb).getIdAlbergo());
			c1.setIdCamera(camMgr.getTriple(idAlb).getIdCamera());
			c1.setNrCamera(camMgr.getTriple(idAlb).getNrCamera() - n3);
			c1.setNumPersCam(3);
			camMgr.updateNrCamere(c1);
			camPackDTO.setIdPacchetto(idpacc);
			camPackDTO.setNumcamere(n3);
			camPackDTO.setNumposticamera(3);
			if (numPers > 3 * n3)
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("noCamDisp.xhtml");
			else {
				campackMgr.save(camPackDTO);
				camMgr.updateNrCamere(c1);
			}
		}

	}

	public void modifica() throws IOException {
		fermaCamere();

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("modifyPacchetto.xhtml?id=" + idpacc);

	}

	public void gift() throws IOException {
		fermaCamere();

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("giftList.xhtml?id=" + idpacc);

	}

	public void invita() throws IOException {
		fermaCamere();

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("invitaAmico.xhtml?id=" + idpacc);

	}

	private void calcolaCosto() throws IOException {
		pk = paccMgr.getPacchettoById(idpacc);
		
		mezzoA = mezzMgr.returnData(pk.getIdMezzoAndata());
		mezzoR = mezzMgr.returnData(pk.getIdMezzoRitorno());
		
		if (numPers > mezzoA.getPostiDisponibili() || numPers > mezzoR.getPostiDisponibili())
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("noPostiDisp.xhtml");
		costo += (mezzoA.getCostoPers() + mezzoR.getCostoPers()) * numPers;
		
		try {
			setEscpk(escpackMgr.getEscPackByPackId(idpacc));
			for(int i=0; i<escpk.size();i++){
				esc = escMgr.getEscId(escpk.get(i).getIdEscursione());
				costo += esc.getCostoPerEsc() * numPers;
			}
			
		} catch (EJBException e) {
			
		}
	}

}