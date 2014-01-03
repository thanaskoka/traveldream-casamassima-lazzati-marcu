package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.MezzoDTO;


/**
 * The persistent class for the mezzotrasporto database table.
 * 
 */
@Entity
@NamedQuery(name="Mezzotrasporto.findAll", query="SELECT m FROM Mezzotrasporto m")
public class Mezzotrasporto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMezzoTrasporto;

	private int costoPers;

	private String dataFine;

	private String dataInizio;

	private int idLuogoArrivo;

	private int idLuogoPartenza;

	private int postiDisponibili;

	public Mezzotrasporto() {
	}
	public Mezzotrasporto(MezzoDTO mezzo){
        
        this.idMezzoTrasporto        = mezzo.getIdMezzoTrasporto();
        this.costoPers    = mezzo.getCostoPers();
        this.dataInizio     = mezzo.getDataInizio();        
        this.dataFine    = mezzo.getDataFine();
        this.idLuogoPartenza =mezzo.getIdLuogoPartenza();
        this.idLuogoArrivo =mezzo.getIdLuogoArrivo();
        this.postiDisponibili=mezzo.getPostiDisponibili();
    }

	public int getIdMezzoTrasporto() {
		return this.idMezzoTrasporto;
	}

	public void setIdMezzoTrasporto(int idMezzoTrasporto) {
		this.idMezzoTrasporto = idMezzoTrasporto;
	}

	public int getCostoPers() {
		return this.costoPers;
	}

	public void setCostoPers(int costoPers) {
		this.costoPers = costoPers;
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

	public int getIdLuogoArrivo() {
		return this.idLuogoArrivo;
	}

	public void setIdLuogoArrivo(int idLuogoArrivo) {
		this.idLuogoArrivo = idLuogoArrivo;
	}

	public int getIdLuogoPartenza() {
		return this.idLuogoPartenza;
	}

	public void setIdLuogoPartenza(int idLuogoPartenza) {
		this.idLuogoPartenza = idLuogoPartenza;
	}

	public int getPostiDisponibili() {
		return this.postiDisponibili;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

}