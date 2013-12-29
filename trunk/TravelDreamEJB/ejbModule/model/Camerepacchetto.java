package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the camerepacchetto database table.
 * 
 */
@Entity
@NamedQuery(name="Camerepacchetto.findAll", query="SELECT c FROM Camerepacchetto c")
public class Camerepacchetto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCamerePacc;

	//bi-directional many-to-one association to Camera
	@ManyToOne
	@JoinColumn(name="idCamera")
	private Camera camera;

	//bi-directional many-to-one association to Pacchetto
	@ManyToOne
	@JoinColumn(name="idPacchetto")
	private Pacchetto pacchetto;

	public Camerepacchetto() {
	}

	public int getIdCamerePacc() {
		return this.idCamerePacc;
	}

	public void setIdCamerePacc(int idCamerePacc) {
		this.idCamerePacc = idCamerePacc;
	}

	public Camera getCamera() {
		return this.camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Pacchetto getPacchetto() {
		return this.pacchetto;
	}

	public void setPacchetto(Pacchetto pacchetto) {
		this.pacchetto = pacchetto;
	}

}