package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the escursionipacchetto database table.
 * 
 */
@Entity
@NamedQuery(name="Escursionipacchetto.findAll", query="SELECT e FROM Escursionipacchetto e")
public class Escursionipacchetto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int idEscursione;

	private int idPacchetto;

	public Escursionipacchetto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEscursione() {
		return this.idEscursione;
	}

	public void setIdEscursione(int idEscursione) {
		this.idEscursione = idEscursione;
	}

	public int getIdPacchetto() {
		return this.idPacchetto;
	}

	public void setIdPacchetto(int idPacchetto) {
		this.idPacchetto = idPacchetto;
	}

}