package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.LuogoDTO;


/**
 * The persistent class for the luogo database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Luogo.findAereoporti", query="SELECT l FROM Luogo l WHERE l.descrizione='aereoporto'"),
@NamedQuery(name="Luogo.findEscursioni", query="SELECT l FROM Luogo l WHERE l.descrizione='escursione'"),
@NamedQuery(name="Luogo.findAlberghi", query="SELECT l FROM Luogo l WHERE l.descrizione='albergo'")})
public class Luogo implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_AEREOPORTI = "Luogo.findAereoporti";
	public static final String FIND_ESCURSIONI = "Luogo.findEscursioni";
	public static final String FIND_ALBERGHI = "Luogo.findAlberghi";
	@Id
	private int id;

	private String citta;

	private String descrizione;

	private String indirizzo;

	private String nazione;

	public Luogo() {
	}
public Luogo(LuogoDTO lu) {
		
		this.citta=lu.getCitta();
		this.descrizione=lu.getDescrizione();
		this.indirizzo=lu.getIndirizzo();
		this.nazione=lu.getStato();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNazione() {
		return this.nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	

}