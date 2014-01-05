package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the partecipapacchetto database table.
 * 
 */
@Entity
@NamedQuery(name="Partecipapacchetto.findAll", query="SELECT p FROM Partecipapacchetto p")
public class Partecipapacchetto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPartecipaPacchetto;

	private int idPacchetto;

	private String idUtente;

	public Partecipapacchetto() {
	}

	public int getIdPartecipaPacchetto() {
		return this.idPartecipaPacchetto;
	}

	public void setIdPartecipaPacchetto(int idPartecipaPacchetto) {
		this.idPartecipaPacchetto = idPartecipaPacchetto;
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

}