package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.GiftlistDTO;


/**
 * The persistent class for the giftlist database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Giftlist.findUtente", query="SELECT g FROM Giftlist g WHERE g.idUser= :idUser"),
@NamedQuery(name="Giftlist.FindPorchiddii", query="SELECT g FROM Giftlist g")
})
public class Giftlist implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_UTENTE = "Giftlist.findUtente";

	@Id
	private int idGiftlist;

	private int idPack;

	private String idUser;

	public Giftlist() {
	}
	
	public Giftlist(GiftlistDTO g){
		idPack = g.getIdPack();
		idUser = g.getIdUser();
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