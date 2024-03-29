package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.PacchettoDTO;


/**
 * The persistent class for the pacchetto database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Pacchetto.findAll", query="SELECT p FROM Pacchetto p ORDER BY p.idPacchetto DESC"),
	@NamedQuery(name="Pacchetto.findId", query="SELECT p FROM Pacchetto p WHERE p.idPacchetto= :id ORDER BY p.idPacchetto DESC"),
	})
public class Pacchetto implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Pacchetto.findAll";
	public static final String FIND_ID = "Pacchetto.findId";

	@Id
	private int idPacchetto;

	private int idAlbergo;

	private int idLuogo;

	private int idMezzoAndata;

	private int idMezzoRitorno;

	private int isModify;

	private String titolo;

	public Pacchetto() {
	}

	public int getIdPacchetto() {
		return this.idPacchetto;
	}

	public void setIdPacchetto(int idPacchetto) {
		this.idPacchetto = idPacchetto;
	}

	public int getIdAlbergo() {
		return this.idAlbergo;
	}

	public void setIdAlbergo(int idAlbergo) {
		this.idAlbergo = idAlbergo;
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

	
	public int getIsModify() {
		return this.isModify;
	}

	public void setIsModify(int isModify) {
		this.isModify = isModify;
	}

	
	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
public Pacchetto(PacchettoDTO lu) {
		
		this.idLuogo=lu.getIdLuogo();
		this.idMezzoAndata=lu.getIdMezzoAndata();
		this.idMezzoRitorno=lu.getIdMezzoRitorno();
		this.isModify=lu.getIsModify();
		this.titolo=lu.getTitolo();
		this.idAlbergo=lu.getIdAlbergo();
	}

}