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
	

	@Column(name="is_modify")
	private byte isModify;

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

	
	public byte getIsModify() {
		return isModify;
	}

	public void setIsModify(byte isModify) {
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
