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

	private int idAlbergo;

	private int idPack;

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

	public int getIdAlbergo() {
		return this.idAlbergo;
	}

	public void setIdAlbergo(int idAlbergo) {
		this.idAlbergo = idAlbergo;
	}

	public int getIdPack() {
		return this.idPack;
	}

	public void setIdPack(int idPack) {
		this.idPack = idPack;
	}

}