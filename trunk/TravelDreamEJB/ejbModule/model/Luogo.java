package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the luogo database table.
 * 
 */
@Entity
@NamedQuery(name="Luogo.findAll", query="SELECT l FROM Luogo l")
public class Luogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String citta;

	private String indirizzo;

	private String nazione;

	//bi-directional many-to-one association to Albergo
	@OneToMany(mappedBy="luogo")
	private List<Albergo> albergos;

	//bi-directional many-to-one association to Escursione
	@OneToMany(mappedBy="luogo")
	private List<Escursione> escursiones;

	//bi-directional many-to-one association to Mezzotrasporto
	@OneToMany(mappedBy="luogo")
	private List<Mezzotrasporto> mezzotrasportos;

	//bi-directional many-to-one association to Pacchetto
	@OneToMany(mappedBy="luogo")
	private List<Pacchetto> pacchettos;

	public Luogo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNazione() {
		return this.nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public List<Albergo> getAlbergos() {
		return this.albergos;
	}

	public void setAlbergos(List<Albergo> albergos) {
		this.albergos = albergos;
	}

	public Albergo addAlbergo(Albergo albergo) {
		getAlbergos().add(albergo);
		albergo.setLuogo(this);

		return albergo;
	}

	public Albergo removeAlbergo(Albergo albergo) {
		getAlbergos().remove(albergo);
		albergo.setLuogo(null);

		return albergo;
	}

	public List<Escursione> getEscursiones() {
		return this.escursiones;
	}

	public void setEscursiones(List<Escursione> escursiones) {
		this.escursiones = escursiones;
	}

	public Escursione addEscursione(Escursione escursione) {
		getEscursiones().add(escursione);
		escursione.setLuogo(this);

		return escursione;
	}

	public Escursione removeEscursione(Escursione escursione) {
		getEscursiones().remove(escursione);
		escursione.setLuogo(null);

		return escursione;
	}

	public List<Mezzotrasporto> getMezzotrasportos() {
		return this.mezzotrasportos;
	}

	public void setMezzotrasportos(List<Mezzotrasporto> mezzotrasportos) {
		this.mezzotrasportos = mezzotrasportos;
	}

	public Mezzotrasporto addMezzotrasporto(Mezzotrasporto mezzotrasporto) {
		getMezzotrasportos().add(mezzotrasporto);
		mezzotrasporto.setLuogo(this);

		return mezzotrasporto;
	}

	public Mezzotrasporto removeMezzotrasporto(Mezzotrasporto mezzotrasporto) {
		getMezzotrasportos().remove(mezzotrasporto);
		mezzotrasporto.setLuogo(null);

		return mezzotrasporto;
	}

	public List<Pacchetto> getPacchettos() {
		return this.pacchettos;
	}

	public void setPacchettos(List<Pacchetto> pacchettos) {
		this.pacchettos = pacchettos;
	}

	public Pacchetto addPacchetto(Pacchetto pacchetto) {
		getPacchettos().add(pacchetto);
		pacchetto.setLuogo(this);

		return pacchetto;
	}

	public Pacchetto removePacchetto(Pacchetto pacchetto) {
		getPacchettos().remove(pacchetto);
		pacchetto.setLuogo(null);

		return pacchetto;
	}

}