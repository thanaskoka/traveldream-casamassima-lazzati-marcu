package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pacchetto database table.
 * 
 */
@Entity
@NamedQuery(name="Pacchetto.findAll", query="SELECT p FROM Pacchetto p")
public class Pacchetto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPacchetto;

	@Column(name="is_modify")
	private byte isModify;

	private int numPers;

	private String titolo;

	//bi-directional many-to-one association to Acquistapacchetto
	@OneToMany(mappedBy="pacchetto")
	private List<Acquistapacchetto> acquistapacchettos;

	//bi-directional many-to-one association to Camerepacchetto
	@OneToMany(mappedBy="pacchetto")
	private List<Camerepacchetto> camerepacchettos;

	//bi-directional many-to-one association to Escursionipacchetto
	@OneToMany(mappedBy="pacchetto")
	private List<Escursionipacchetto> escursionipacchettos;

	//bi-directional many-to-one association to Giftlist
	@OneToMany(mappedBy="pacchetto")
	private List<Giftlist> giftlists;

	//bi-directional many-to-one association to Luogo
	@ManyToOne
	@JoinColumn(name="IdLuogo")
	private Luogo luogo;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUtente")
	private User user;

	//bi-directional many-to-one association to Partecipapacchetto
	@OneToMany(mappedBy="pacchetto")
	private List<Partecipapacchetto> partecipapacchettos;

	//bi-directional many-to-one association to Prenotazionealbergo
	@OneToMany(mappedBy="pacchetto")
	private List<Prenotazionealbergo> prenotazionealbergos;

	//bi-directional many-to-one association to Viaggio
	@OneToMany(mappedBy="pacchetto")
	private List<Viaggio> viaggios;

	public Pacchetto() {
	}

	public int getIdPacchetto() {
		return this.idPacchetto;
	}

	public void setIdPacchetto(int idPacchetto) {
		this.idPacchetto = idPacchetto;
	}

	public byte getIsModify() {
		return this.isModify;
	}

	public void setIsModify(byte isModify) {
		this.isModify = isModify;
	}

	public int getNumPers() {
		return this.numPers;
	}

	public void setNumPers(int numPers) {
		this.numPers = numPers;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Acquistapacchetto> getAcquistapacchettos() {
		return this.acquistapacchettos;
	}

	public void setAcquistapacchettos(List<Acquistapacchetto> acquistapacchettos) {
		this.acquistapacchettos = acquistapacchettos;
	}

	public Acquistapacchetto addAcquistapacchetto(Acquistapacchetto acquistapacchetto) {
		getAcquistapacchettos().add(acquistapacchetto);
		acquistapacchetto.setPacchetto(this);

		return acquistapacchetto;
	}

	public Acquistapacchetto removeAcquistapacchetto(Acquistapacchetto acquistapacchetto) {
		getAcquistapacchettos().remove(acquistapacchetto);
		acquistapacchetto.setPacchetto(null);

		return acquistapacchetto;
	}

	public List<Camerepacchetto> getCamerepacchettos() {
		return this.camerepacchettos;
	}

	public void setCamerepacchettos(List<Camerepacchetto> camerepacchettos) {
		this.camerepacchettos = camerepacchettos;
	}

	public Camerepacchetto addCamerepacchetto(Camerepacchetto camerepacchetto) {
		getCamerepacchettos().add(camerepacchetto);
		camerepacchetto.setPacchetto(this);

		return camerepacchetto;
	}

	public Camerepacchetto removeCamerepacchetto(Camerepacchetto camerepacchetto) {
		getCamerepacchettos().remove(camerepacchetto);
		camerepacchetto.setPacchetto(null);

		return camerepacchetto;
	}

	public List<Escursionipacchetto> getEscursionipacchettos() {
		return this.escursionipacchettos;
	}

	public void setEscursionipacchettos(List<Escursionipacchetto> escursionipacchettos) {
		this.escursionipacchettos = escursionipacchettos;
	}

	public Escursionipacchetto addEscursionipacchetto(Escursionipacchetto escursionipacchetto) {
		getEscursionipacchettos().add(escursionipacchetto);
		escursionipacchetto.setPacchetto(this);

		return escursionipacchetto;
	}

	public Escursionipacchetto removeEscursionipacchetto(Escursionipacchetto escursionipacchetto) {
		getEscursionipacchettos().remove(escursionipacchetto);
		escursionipacchetto.setPacchetto(null);

		return escursionipacchetto;
	}

	public List<Giftlist> getGiftlists() {
		return this.giftlists;
	}

	public void setGiftlists(List<Giftlist> giftlists) {
		this.giftlists = giftlists;
	}

	public Giftlist addGiftlist(Giftlist giftlist) {
		getGiftlists().add(giftlist);
		giftlist.setPacchetto(this);

		return giftlist;
	}

	public Giftlist removeGiftlist(Giftlist giftlist) {
		getGiftlists().remove(giftlist);
		giftlist.setPacchetto(null);

		return giftlist;
	}

	public Luogo getLuogo() {
		return this.luogo;
	}

	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Partecipapacchetto> getPartecipapacchettos() {
		return this.partecipapacchettos;
	}

	public void setPartecipapacchettos(List<Partecipapacchetto> partecipapacchettos) {
		this.partecipapacchettos = partecipapacchettos;
	}

	public Partecipapacchetto addPartecipapacchetto(Partecipapacchetto partecipapacchetto) {
		getPartecipapacchettos().add(partecipapacchetto);
		partecipapacchetto.setPacchetto(this);

		return partecipapacchetto;
	}

	public Partecipapacchetto removePartecipapacchetto(Partecipapacchetto partecipapacchetto) {
		getPartecipapacchettos().remove(partecipapacchetto);
		partecipapacchetto.setPacchetto(null);

		return partecipapacchetto;
	}

	public List<Prenotazionealbergo> getPrenotazionealbergos() {
		return this.prenotazionealbergos;
	}

	public void setPrenotazionealbergos(List<Prenotazionealbergo> prenotazionealbergos) {
		this.prenotazionealbergos = prenotazionealbergos;
	}

	public Prenotazionealbergo addPrenotazionealbergo(Prenotazionealbergo prenotazionealbergo) {
		getPrenotazionealbergos().add(prenotazionealbergo);
		prenotazionealbergo.setPacchetto(this);

		return prenotazionealbergo;
	}

	public Prenotazionealbergo removePrenotazionealbergo(Prenotazionealbergo prenotazionealbergo) {
		getPrenotazionealbergos().remove(prenotazionealbergo);
		prenotazionealbergo.setPacchetto(null);

		return prenotazionealbergo;
	}

	public List<Viaggio> getViaggios() {
		return this.viaggios;
	}

	public void setViaggios(List<Viaggio> viaggios) {
		this.viaggios = viaggios;
	}

	public Viaggio addViaggio(Viaggio viaggio) {
		getViaggios().add(viaggio);
		viaggio.setPacchetto(this);

		return viaggio;
	}

	public Viaggio removeViaggio(Viaggio viaggio) {
		getViaggios().remove(viaggio);
		viaggio.setPacchetto(null);

		return viaggio;
	}

}