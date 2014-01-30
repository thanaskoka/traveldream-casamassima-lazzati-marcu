package model.dto;

import javax.persistence.Column;

public class PacchettoDTO {
	
	private int idPacchetto;
	private int idAlbergo;
	
	public int getIdAlbergo() {
		return idAlbergo;
	}

	public void setIdAlbergo(int idAlbergo) {
		this.idAlbergo = idAlbergo;
	}

	private int idLuogo;

	private int idMezzoAndata;

	private int idMezzoRitorno;
	
	private int idGif;
	

	public int getIdGif() {
		return idGif;
	}

	public void setIdGif(int idGif) {
		this.idGif = idGif;
	}

	private int isModify;

	public int getIdPacchetto() {
		return idPacchetto;
	}

	public void setIdPacchetto(int idPacchetto) {
		this.idPacchetto = idPacchetto;
	}

	public int getIdLuogo() {
		return idLuogo;
	}

	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}

	public int getIdMezzoAndata() {
		return idMezzoAndata;
	}

	public void setIdMezzoAndata(int idMezzoAndata) {
		this.idMezzoAndata = idMezzoAndata;
	}

	public int getIdMezzoRitorno() {
		return idMezzoRitorno;
	}

	public void setIdMezzoRitorno(int idMezzoRitorno) {
		this.idMezzoRitorno = idMezzoRitorno;
	}

	
	public int getIsModify() {
		return isModify;
	}

	public void setIsModify(int isModify) {
		this.isModify = isModify;
	}

	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	private String titolo;

}
