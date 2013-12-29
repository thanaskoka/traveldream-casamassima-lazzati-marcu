package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aderiscegiftlist database table.
 * 
 */
@Entity
@NamedQuery(name="Aderiscegiftlist.findAll", query="SELECT a FROM Aderiscegiftlist a")
public class Aderiscegiftlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUtente")
	private User user;

	//bi-directional many-to-one association to Giftlist
	@ManyToOne
	@JoinColumn(name="idGift")
	private Giftlist giftlist;

	//bi-directional many-to-one association to Elememtobase
	@ManyToOne
	@JoinColumn(name="idElementoPagato")
	private Elememtobase elememtobase;

	public Aderiscegiftlist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Giftlist getGiftlist() {
		return this.giftlist;
	}

	public void setGiftlist(Giftlist giftlist) {
		this.giftlist = giftlist;
	}

	public Elememtobase getElememtobase() {
		return this.elememtobase;
	}

	public void setElememtobase(Elememtobase elememtobase) {
		this.elememtobase = elememtobase;
	}

}