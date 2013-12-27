package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Aderiscegiftlist
	@OneToMany(mappedBy="elememtobase")
	private List<Aderiscegiftlist> aderiscegiftlists;

	//bi-directional many-to-one association to Mezzotrasporto
	@ManyToOne
	@JoinColumn(name="idViaggio")
	private Mezzotrasporto mezzotrasporto;

	//bi-directional many-to-one association to Albergo
	@ManyToOne
	@JoinColumn(name="idAlbergo")
	private Albergo albergo;

	//bi-directional many-to-one association to Escursione
	@ManyToOne
	@JoinColumn(name="idEscursione")
	private Escursione escursione;

	public Elememtobase() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Aderiscegiftlist> getAderiscegiftlists() {
		return this.aderiscegiftlists;
	}

	public void setAderiscegiftlists(List<Aderiscegiftlist> aderiscegiftlists) {
		this.aderiscegiftlists = aderiscegiftlists;
	}

	public Aderiscegiftlist addAderiscegiftlist(Aderiscegiftlist aderiscegiftlist) {
		getAderiscegiftlists().add(aderiscegiftlist);
		aderiscegiftlist.setElememtobase(this);

		return aderiscegiftlist;
	}

	public Aderiscegiftlist removeAderiscegiftlist(Aderiscegiftlist aderiscegiftlist) {
		getAderiscegiftlists().remove(aderiscegiftlist);
		aderiscegiftlist.setElememtobase(null);

		return aderiscegiftlist;
	}

	public Mezzotrasporto getMezzotrasporto() {
		return this.mezzotrasporto;
	}

	public void setMezzotrasporto(Mezzotrasporto mezzotrasporto) {
		this.mezzotrasporto = mezzotrasporto;
	}

	public Albergo getAlbergo() {
		return this.albergo;
	}

	public void setAlbergo(Albergo albergo) {
		this.albergo = albergo;
	}

	public Escursione getEscursione() {
		return this.escursione;
	}

	public void setEscursione(Escursione escursione) {
		this.escursione = escursione;
	}

}