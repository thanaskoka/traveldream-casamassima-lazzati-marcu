package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the albergo database table.
 * 
 */
@Entity
@NamedQuery(name="Albergo.findAll", query="SELECT a FROM Albergo a")
public class Albergo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAlbergo;

	private String dataFine;

	private String dataInizio;

	private int idLuogo;

	private String nome;

	@Column(name="numero_stelle")
	private String numeroStelle;

	private String tipologia;

	public Albergo() {
	}

	public int getIdAlbergo() {
		return this.idAlbergo;
	}

	public void setIdAlbergo(int idAlbergo) {
		this.idAlbergo = idAlbergo;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroStelle() {
		return this.numeroStelle;
	}

	public void setNumeroStelle(String numeroStelle) {
		this.numeroStelle = numeroStelle;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

}