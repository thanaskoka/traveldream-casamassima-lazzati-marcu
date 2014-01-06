package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the elememtobase database table.
 * 
 */
@Entity
@NamedQuery(name="Elememtobase.findAll", query="SELECT e FROM Elememtobase e")
public class Elememtobase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int idAlbergo;

	private int idEscursione;

	private int idViaggio;

	public Elememtobase() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAlbergo() {
		return this.idAlbergo;
	}

	public void setIdAlbergo(int idAlbergo) {
		this.idAlbergo = idAlbergo;
	}

	public int getIdEscursione() {
		return this.idEscursione;
	}

	public void setIdEscursione(int idEscursione) {
		this.idEscursione = idEscursione;
	}

	public int getIdViaggio() {
		return this.idViaggio;
	}

	public void setIdViaggio(int idViaggio) {
		this.idViaggio = idViaggio;
	}

}