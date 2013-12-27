package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utenteregistrato database table.
 * 
 */
@Entity
@NamedQuery(name="Utenteregistrato.findAll", query="SELECT u FROM Utenteregistrato u")
public class Utenteregistrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUtente;

	private String cgnome;

	private String emailUtente;

	private String nome;

	private String password;

	private int residenza;

	private String userrname;

	//bi-directional many-to-one association to Acquistapacchetto
	@OneToMany(mappedBy="utenteregistrato")
	private List<Acquistapacchetto> acquistapacchettos;

	//bi-directional many-to-one association to Aderiscegiftlist
	@OneToMany(mappedBy="utenteregistrato")
	private List<Aderiscegiftlist> aderiscegiftlists;

	//bi-directional many-to-one association to Giftlist
	@OneToMany(mappedBy="utenteregistrato")
	private List<Giftlist> giftlists;

	//bi-directional many-to-one association to Pacchetto
	@OneToMany(mappedBy="utenteregistrato")
	private List<Pacchetto> pacchettos;

	//bi-directional many-to-one association to Partecipapacchetto
	@OneToMany(mappedBy="utenteregistrato")
	private List<Partecipapacchetto> partecipapacchettos;

	public Utenteregistrato() {
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCgnome() {
		return this.cgnome;
	}

	public void setCgnome(String cgnome) {
		this.cgnome = cgnome;
	}

	public String getEmailUtente() {
		return this.emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getResidenza() {
		return this.residenza;
	}

	public void setResidenza(int residenza) {
		this.residenza = residenza;
	}

	public String getUserrname() {
		return this.userrname;
	}

	public void setUserrname(String userrname) {
		this.userrname = userrname;
	}

	public List<Acquistapacchetto> getAcquistapacchettos() {
		return this.acquistapacchettos;
	}

	public void setAcquistapacchettos(List<Acquistapacchetto> acquistapacchettos) {
		this.acquistapacchettos = acquistapacchettos;
	}

	public Acquistapacchetto addAcquistapacchetto(Acquistapacchetto acquistapacchetto) {
		getAcquistapacchettos().add(acquistapacchetto);
		acquistapacchetto.setUtenteregistrato(this);

		return acquistapacchetto;
	}

	public Acquistapacchetto removeAcquistapacchetto(Acquistapacchetto acquistapacchetto) {
		getAcquistapacchettos().remove(acquistapacchetto);
		acquistapacchetto.setUtenteregistrato(null);

		return acquistapacchetto;
	}

	public List<Aderiscegiftlist> getAderiscegiftlists() {
		return this.aderiscegiftlists;
	}

	public void setAderiscegiftlists(List<Aderiscegiftlist> aderiscegiftlists) {
		this.aderiscegiftlists = aderiscegiftlists;
	}

	public Aderiscegiftlist addAderiscegiftlist(Aderiscegiftlist aderiscegiftlist) {
		getAderiscegiftlists().add(aderiscegiftlist);
		aderiscegiftlist.setUtenteregistrato(this);

		return aderiscegiftlist;
	}

	public Aderiscegiftlist removeAderiscegiftlist(Aderiscegiftlist aderiscegiftlist) {
		getAderiscegiftlists().remove(aderiscegiftlist);
		aderiscegiftlist.setUtenteregistrato(null);

		return aderiscegiftlist;
	}

	public List<Giftlist> getGiftlists() {
		return this.giftlists;
	}

	public void setGiftlists(List<Giftlist> giftlists) {
		this.giftlists = giftlists;
	}

	public Giftlist addGiftlist(Giftlist giftlist) {
		getGiftlists().add(giftlist);
		giftlist.setUtenteregistrato(this);

		return giftlist;
	}

	public Giftlist removeGiftlist(Giftlist giftlist) {
		getGiftlists().remove(giftlist);
		giftlist.setUtenteregistrato(null);

		return giftlist;
	}

	public List<Pacchetto> getPacchettos() {
		return this.pacchettos;
	}

	public void setPacchettos(List<Pacchetto> pacchettos) {
		this.pacchettos = pacchettos;
	}

	public Pacchetto addPacchetto(Pacchetto pacchetto) {
		getPacchettos().add(pacchetto);
		pacchetto.setUtenteregistrato(this);

		return pacchetto;
	}

	public Pacchetto removePacchetto(Pacchetto pacchetto) {
		getPacchettos().remove(pacchetto);
		pacchetto.setUtenteregistrato(null);

		return pacchetto;
	}

	public List<Partecipapacchetto> getPartecipapacchettos() {
		return this.partecipapacchettos;
	}

	public void setPartecipapacchettos(List<Partecipapacchetto> partecipapacchettos) {
		this.partecipapacchettos = partecipapacchettos;
	}

	public Partecipapacchetto addPartecipapacchetto(Partecipapacchetto partecipapacchetto) {
		getPartecipapacchettos().add(partecipapacchetto);
		partecipapacchetto.setUtenteregistrato(this);

		return partecipapacchetto;
	}

	public Partecipapacchetto removePartecipapacchetto(Partecipapacchetto partecipapacchetto) {
		getPartecipapacchettos().remove(partecipapacchetto);
		partecipapacchetto.setUtenteregistrato(null);

		return partecipapacchetto;
	}

}