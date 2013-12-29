package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the giftlist database table.
 * 
 */
@Entity
@NamedQuery(name="Giftlist.findAll", query="SELECT g FROM Giftlist g")
public class Giftlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idGiftlist;

	//bi-directional many-to-one association to Aderiscegiftlist
	@OneToMany(mappedBy="giftlist")
	private List<Aderiscegiftlist> aderiscegiftlists;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to Pacchetto
	@ManyToOne
	@JoinColumn(name="idPack")
	private Pacchetto pacchetto;

	public Giftlist() {
	}

	public int getIdGiftlist() {
		return this.idGiftlist;
	}

	public void setIdGiftlist(int idGiftlist) {
		this.idGiftlist = idGiftlist;
	}

	public List<Aderiscegiftlist> getAderiscegiftlists() {
		return this.aderiscegiftlists;
	}

	public void setAderiscegiftlists(List<Aderiscegiftlist> aderiscegiftlists) {
		this.aderiscegiftlists = aderiscegiftlists;
	}

	public Aderiscegiftlist addAderiscegiftlist(Aderiscegiftlist aderiscegiftlist) {
		getAderiscegiftlists().add(aderiscegiftlist);
		aderiscegiftlist.setGiftlist(this);

		return aderiscegiftlist;
	}

	public Aderiscegiftlist removeAderiscegiftlist(Aderiscegiftlist aderiscegiftlist) {
		getAderiscegiftlists().remove(aderiscegiftlist);
		aderiscegiftlist.setGiftlist(null);

		return aderiscegiftlist;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pacchetto getPacchetto() {
		return this.pacchetto;
	}

	public void setPacchetto(Pacchetto pacchetto) {
		this.pacchetto = pacchetto;
	}

}