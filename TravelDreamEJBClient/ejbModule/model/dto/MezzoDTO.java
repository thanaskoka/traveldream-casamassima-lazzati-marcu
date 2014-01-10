package model.dto;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
public class MezzoDTO {
	@NotNull
	@Min(0)
	@Max(5000)
	private Integer idMezzoTrasporto;
	@NotNull
	@Min(0)
	@Max(999)
	private Integer costoPers;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotNull
	private Date dataFine;
	@NotNull
	private Date dataInizio;
	
	private Integer idLuogoArrivo;
	
	private Integer idLuogoPartenza;
	@NotNull
	@Min(0)
	@Max(999)
	private Integer postiDisponibili;

	public Integer getIdMezzoTrasporto() {
		return idMezzoTrasporto;
	}

	public void setIdMezzoTrasporto(Integer idMezzoTrasporto) {
		this.idMezzoTrasporto = idMezzoTrasporto;
	}

	public Integer getCostoPers() {
		return costoPers;
	}

	public void setCostoPers(Integer costoPers) {
		this.costoPers = costoPers;
	}

	

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Integer getIdLuogoArrivo() {
		return idLuogoArrivo;
	}

	public void setIdLuogoArrivo(Integer idLuogoArrivo) {
		this.idLuogoArrivo = idLuogoArrivo;
	}

	public Integer getIdLuogoPartenza() {
		return idLuogoPartenza;
	}

	public void setIdLuogoPartenza(Integer idLuogoPartenza) {
		this.idLuogoPartenza = idLuogoPartenza;
	}

	public Integer getPostiDisponibili() {
		return postiDisponibili;
	}

	public void setPostiDisponibili(Integer postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

}
