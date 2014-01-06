package model;

import java.io.Serializable;
import javax.persistence.*;


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

	private int idLuogo;

	private int idMezzoAndata;

	private int idMezzoRitorno;

	private String idUtente;

	@Column(name="is_modify")
	private byte isModify;

	private int numPers;

	private String titolo;

	public Pacchetto() {
	}

	public int getIdPacchetto() {
		return this.idPacchetto;
	}

	public void setIdPacchetto(int idPacchetto) {
		this.idPacchetto = idPacchetto;
	}

	public int getIdLuogo() {
		return this.idLuogo;
	}

	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}

	public int getIdMezzoAndata() {
		return this.idMezzoAndata;
	}

	public void setIdMezzoAndata(int idMezzoAndata) {
		this.idMezzoAndata = idMezzoAndata;
	}

	public int getIdMezzoRitorno() {
		return this.idMezzoRitorno;
	}

	public void setIdMezzoRitorno(int idMezzoRitorno) {
		this.idMezzoRitorno = idMezzoRitorno;
	}

	public String getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
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

}