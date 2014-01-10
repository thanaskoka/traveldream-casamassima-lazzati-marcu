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

	private String idUtente;
	

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

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public byte getIsModify() {
		return isModify;
	}

	public void setIsModify(byte isModify) {
		this.isModify = isModify;
	}

	public int getNumPers() {
		return numPers;
	}

	public void setNumPers(int numPers) {
		this.numPers = numPers;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	private int numPers;

	private String titolo;

}
