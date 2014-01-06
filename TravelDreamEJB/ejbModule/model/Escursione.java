package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.EscursioneDTO;

import java.util.Date;


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

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFine;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInizio;

	private int idLuogo;

	private int postiDisponibili;

	private String tipologia;

	public Escursione() {
	}
public Escursione(EscursioneDTO esc){
        
       this.idLuogo=esc.getIdLuogo();
       this.dataInizio=esc.getDataInizio();
       this.dataFine=esc.getDataFine();
       this.postiDisponibili=esc.getPostiDisp();
       this.tipologia=esc.getDescrizone();
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

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
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