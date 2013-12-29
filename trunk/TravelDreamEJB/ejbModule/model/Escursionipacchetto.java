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

	//bi-directional many-to-one association to Escursione
	@ManyToOne
	@JoinColumn(name="idEscursione")
	private Escursione escursione;

	//bi-directional many-to-one association to Pacchetto
	@ManyToOne
	@JoinColumn(name="idPacchetto")
	private Pacchetto pacchetto;

	public Escursionipacchetto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Escursione getEscursione() {
		return this.escursione;
	}

	public void setEscursione(Escursione escursione) {
		this.escursione = escursione;
	}

	public Pacchetto getPacchetto() {
		return this.pacchetto;
	}

	public void setPacchetto(Pacchetto pacchetto) {
		this.pacchetto = pacchetto;
	}

}