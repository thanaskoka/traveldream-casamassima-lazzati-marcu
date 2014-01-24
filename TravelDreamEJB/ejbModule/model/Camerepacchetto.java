package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.CamerapacchettoDTO;


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

	private int idPacchetto;

	private int numcamere;

	private int numposticamera;

	public Camerepacchetto() {
	}
	
	public Camerepacchetto(CamerapacchettoDTO cam){
		this.idCamerePacc=cam.getIdCamerePacc();
		this.idPacchetto=cam.getIdPacchetto();
		this.numcamere=cam.getNumcamere();
		this.numposticamera=cam.getNumposticamera();
		
		
	}

	public int getIdCamerePacc() {
		return this.idCamerePacc;
	}

	public void setIdCamerePacc(int idCamerePacc) {
		this.idCamerePacc = idCamerePacc;
	}

	public int getIdPacchetto() {
		return this.idPacchetto;
	}

	public void setIdPacchetto(int idPacchetto) {
		this.idPacchetto = idPacchetto;
	}

	public int getNumcamere() {
		return this.numcamere;
	}

	public void setNumcamere(int numcamere) {
		this.numcamere = numcamere;
	}

	public int getNumposticamera() {
		return this.numposticamera;
	}

	public void setNumposticamera(int numposticamera) {
		this.numposticamera = numposticamera;
	}

}