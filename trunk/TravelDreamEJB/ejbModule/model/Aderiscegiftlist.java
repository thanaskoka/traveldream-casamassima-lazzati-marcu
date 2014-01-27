package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.AderiscegiftlistDTO;


/**
 * The persistent class for the aderiscegiftlist database table.
 * 
 */
@Entity
@NamedQuery(name="Aderiscegiftlist.findGift", query="SELECT a FROM Aderiscegiftlist a WHERE a.idGift= :idGift")
public class Aderiscegiftlist implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_GIFT = "Aderiscegiftlist.findGift";

	@Id
	private int id;

	

	private int idGift;

	private String idUtente;

	public Aderiscegiftlist() {
	}
	
	public Aderiscegiftlist(AderiscegiftlistDTO ad) {
		
		idGift = ad.getIdGift();
		idUtente = ad.getIdUtente();
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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