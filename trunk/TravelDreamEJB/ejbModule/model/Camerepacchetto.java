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

	private int idCamera;

	private int idPacchetto;

	public Camerepacchetto() {
	}

	public int getIdCamerePacc() {
		return this.idCamerePacc;
	}

	public void setIdCamerePacc(int idCamerePacc) {
		this.idCamerePacc = idCamerePacc;
	}

	public int getIdCamera() {
		return this.idCamera;
	}

	public void setIdCamera(int idCamera) {
		this.idCamera = idCamera;
	}

	public int getIdPacchetto() {
		return this.idPacchetto;
	}

	public void setIdPacchetto(int idPacchetto) {
		this.idPacchetto = idPacchetto;
	}

}