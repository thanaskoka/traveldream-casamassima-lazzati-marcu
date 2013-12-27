package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prenotazionealbergo database table.
 * 
 */
@Entity
@NamedQuery(name="Prenotazionealbergo.findAll", query="SELECT p FROM Prenotazionealbergo p")
public class Prenotazionealbergo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String costo;

	//bi-directional many-to-one association to Albergo
	@ManyToOne
	@JoinColumn(name="idAlbergo")
	private Albergo albergo;

	//bi-directional many-to-one association to Pacchetto
	@ManyToOne
	@JoinColumn(name="idPack")
	private Pacchetto pacchetto;

	public Prenotazionealbergo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCosto() {
		return this.costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public Albergo getAlbergo() {
		return this.albergo;
	}

	public void setAlbergo(Albergo albergo) {
		this.albergo = albergo;
	}

	public Pacchetto getPacchetto() {
		return this.pacchetto;
	}

	public void setPacchetto(Pacchetto pacchetto) {
		this.pacchetto = pacchetto;
	}

}