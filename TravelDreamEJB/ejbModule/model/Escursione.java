package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the escursione database table.
 * 
 */
@Entity
@NamedQuery(name="Escursione.findAll", query="SELECT e FROM Escursione e")
public class Escursione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int costoPerEsc;

	private String dataFine;

	private String dataInizio;

	private int idLuogo;

	private int postiDisponibili;

	private String tipologia;

	public Escursione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCostoPerEsc() {
		return this.costoPerEsc;
	}

	public void setCostoPerEsc(int costoPerEsc) {
		this.costoPerEsc = costoPerEsc;
	}

	public String getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getIdLuogo() {
		return this.idLuogo;
	}

	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}

	public int getPostiDisponibili() {
		return this.postiDisponibili;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

}