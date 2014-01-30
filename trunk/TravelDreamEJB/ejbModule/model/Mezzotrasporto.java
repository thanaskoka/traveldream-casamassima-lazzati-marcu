package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.MezzoDTO;

import java.util.Date;


/**
 * The persistent class for the mezzotrasporto database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Mezzotrasporto.findAll", query="SELECT m FROM Mezzotrasporto m"),
	@NamedQuery(name="Mezzotrasporto.findByLuogoAndataAndDataA", query="SELECT m FROM Mezzotrasporto m WHERE m.idLuogoArrivo= :luogoA AND m.idLuogoPartenza= :luogoP AND m.dataInizio >= :partenza  "),
	@NamedQuery(name="Mezzotrasporto.findByLuogoAndataAndDataR", query="SELECT m FROM Mezzotrasporto m WHERE m.idLuogoArrivo= :luogoA AND m.idLuogoPartenza= :luogoP AND m.dataInizio <= :partenza  "),
	@NamedQuery(name="Mezzotrasporto.returnData", query="SELECT m FROM Mezzotrasporto m WHERE m.id= :id"),
})
public class Mezzotrasporto implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Mezzotrasporto.findAll";
	public static final String FIND_BY_LUOGOA = "Mezzotrasporto.findByLuogoAndataAndDataA";
	public static final String FIND_BY_LUOGOR = "Mezzotrasporto.findByLuogoAndataAndDataR";
	public static final String RETURN_DATA="Mezzotrasporto.returnData";

	@Id
	private int id;

	private int costoPers;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFine;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInizio;

	private int idLuogoArrivo;

	private int idLuogoPartenza;

	private int idMezzoTrasporto;

	private int postiDisponibili;

	public Mezzotrasporto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCostoPers() {
		return this.costoPers;
	}

	public void setCostoPers(int costoPers) {
		this.costoPers = costoPers;
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

	public int getIdMezzoTrasporto() {
		return this.idMezzoTrasporto;
	}

	public void setIdMezzoTrasporto(int idMezzoTrasporto) {
		this.idMezzoTrasporto = idMezzoTrasporto;
	}

	public int getPostiDisponibili() {
		return this.postiDisponibili;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
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

}