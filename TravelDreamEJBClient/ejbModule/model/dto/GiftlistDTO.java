package model.dto;

import javax.persistence.Id;

public class GiftlistDTO {
	@Id
	private int idGiftlist;

	private int idPack;

	private String idUser;

	public int getIdGiftlist() {
		return idGiftlist;
	}

	public void setIdGiftlist(int idGiftlist) {
		this.idGiftlist = idGiftlist;
	}

	public int getIdPack() {
		return idPack;
	}

	public void setIdPack(int idPack) {
		this.idPack = idPack;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	
}
