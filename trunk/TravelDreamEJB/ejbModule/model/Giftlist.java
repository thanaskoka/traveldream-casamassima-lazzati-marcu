package model;

import java.io.Serializable;
import javax.persistence.*;


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

	private int idPack;

	private String idUser;

	public Giftlist() {
	}

	public int getIdGiftlist() {
		return this.idGiftlist;
	}

	public void setIdGiftlist(int idGiftlist) {
		this.idGiftlist = idGiftlist;
	}

	public int getIdPack() {
		return this.idPack;
	}

	public void setIdPack(int idPack) {
		this.idPack = idPack;
	}

	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

}