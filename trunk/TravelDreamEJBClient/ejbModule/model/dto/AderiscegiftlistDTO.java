package model.dto;

import javax.persistence.Id;

public class AderiscegiftlistDTO {
	@Id
	private int id;

	private int idElementoPagato;

	private int idGift;

	private String idUtente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdElementoPagato() {
		return idElementoPagato;
	}

	public void setIdElementoPagato(int idElementoPagato) {
		this.idElementoPagato = idElementoPagato;
	}

	public int getIdGift() {
		return idGift;
	}

	public void setIdGift(int idGift) {
		this.idGift = idGift;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}
	
	
}
