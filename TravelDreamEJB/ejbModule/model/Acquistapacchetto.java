package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.AcquistapacchettoDTO;


/**
 * The persistent class for the acquistapacchetto database table.
 * 
 */
@Entity
@NamedQuery(name="Acquistapacchetto.findAll", query="SELECT a FROM Acquistapacchetto a")
public class Acquistapacchetto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int idPacchetto;

	private String idUtente;

	private int numPers;

	public Acquistapacchetto() {
	}

	public Acquistapacchetto(AcquistapacchettoDTO pk) {
		idPacchetto = pk.getIdPacchetto();
		idUtente = pk.getIdUtente();
		numPers = pk.getNumPers();
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPacchetto() {
		return this.idPacchetto;
	}

	public void setIdPacchetto(int idPacchetto) {
		this.idPacchetto = idPacchetto;
	}

	public String getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public int getNumPers() {
		return this.numPers;
	}

	public void setNumPers(int numPers) {
		this.numPers = numPers;
	}

}