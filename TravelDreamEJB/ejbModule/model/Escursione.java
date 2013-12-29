package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the escursione database table.
 * 
 */
@Entity
@NamedQuery(name="Escursione.findAll", query="SELECT e FROM Escursione e")
public class Escursione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String costoPerEsc;

	@Temporal(TemporalType.DATE)
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	private Date dataInizio;

	private int postiDisponibili;

	private String tipologia;

	//bi-directional many-to-one association to Elememtobase
	@OneToMany(mappedBy="escursione")
	private List<Elememtobase> elememtobases;

	//bi-directional many-to-one association to Luogo
	@ManyToOne
	@JoinColumn(name="idLuogo")
	private Luogo luogo;

	//bi-directional many-to-one association to Escursionipacchetto
	@OneToMany(mappedBy="escursione")
	private List<Escursionipacchetto> escursionipacchettos;

	public Escursione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCostoPerEsc() {
		return this.costoPerEsc;
	}

	public void setCostoPerEsc(String costoPerEsc) {
		this.costoPerEsc = costoPerEsc;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getPostiDisponibili() {
		return this.postiDisponibili;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public List<Elememtobase> getElememtobases() {
		return this.elememtobases;
	}

	public void setElememtobases(List<Elememtobase> elememtobases) {
		this.elememtobases = elememtobases;
	}

	public Elememtobase addElememtobas(Elememtobase elememtobas) {
		getElememtobases().add(elememtobas);
		elememtobas.setEscursione(this);

		return elememtobas;
	}

	public Elememtobase removeElememtobas(Elememtobase elememtobas) {
		getElememtobases().remove(elememtobas);
		elememtobas.setEscursione(null);

		return elememtobas;
	}

	public Luogo getLuogo() {
		return this.luogo;
	}

	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}

	public List<Escursionipacchetto> getEscursionipacchettos() {
		return this.escursionipacchettos;
	}

	public void setEscursionipacchettos(List<Escursionipacchetto> escursionipacchettos) {
		this.escursionipacchettos = escursionipacchettos;
	}

	public Escursionipacchetto addEscursionipacchetto(Escursionipacchetto escursionipacchetto) {
		getEscursionipacchettos().add(escursionipacchetto);
		escursionipacchetto.setEscursione(this);

		return escursionipacchetto;
	}

	public Escursionipacchetto removeEscursionipacchetto(Escursionipacchetto escursionipacchetto) {
		getEscursionipacchettos().remove(escursionipacchetto);
		escursionipacchetto.setEscursione(null);

		return escursionipacchetto;
	}

}