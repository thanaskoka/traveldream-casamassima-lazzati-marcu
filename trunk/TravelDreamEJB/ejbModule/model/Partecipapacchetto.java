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

	//bi-directional many-to-one association to Utenteregistrato
	@ManyToOne
	@JoinColumn(name="idUtente")
	private Utenteregistrato utenteregistrato;

	//bi-directional many-to-one association to Pacchetto
	@ManyToOne
	@JoinColumn(name="idPacchetto")
	private Pacchetto pacchetto;

	public Partecipapacchetto() {
	}

	public int getIdPartecipaPacchetto() {
		return this.idPartecipaPacchetto;
	}

	public void setIdPartecipaPacchetto(int idPartecipaPacchetto) {
		this.idPartecipaPacchetto = idPartecipaPacchetto;
	}

	public Utenteregistrato getUtenteregistrato() {
		return this.utenteregistrato;
	}

	public void setUtenteregistrato(Utenteregistrato utenteregistrato) {
		this.utenteregistrato = utenteregistrato;
	}

	public Pacchetto getPacchetto() {
		return this.pacchetto;
	}

	public void setPacchetto(Pacchetto pacchetto) {
		this.pacchetto = pacchetto;
	}

}