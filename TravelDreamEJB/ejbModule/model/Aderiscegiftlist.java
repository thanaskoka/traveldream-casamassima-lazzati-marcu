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

	private int idElementoPagato;

	private int idGift;

	private String idUtente;

	public Aderiscegiftlist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdElementoPagato() {
		return this.idElementoPagato;
	}

	public void setIdElementoPagato(int idElementoPagato) {
		this.idElementoPagato = idElementoPagato;
	}

	public int getIdGift() {
		return this.idGift;
	}

	public void setIdGift(int idGift) {
		this.idGift = idGift;
	}

	public String getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

}