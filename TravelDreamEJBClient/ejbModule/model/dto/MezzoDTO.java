package model.dto;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
public class MezzoDTO {
	@NotNull
	@Min(0)
	@Max(999)
	private Integer idMezzoTrasporto;
	@NotNull
	@Min(0)
	@Max(999)
	private Integer costoPers;
	@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", message="Invalid date")
	private String dataFine;
	@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", message="Invalid date")
	private String dataInizio;
	@NotNull
	@Min(0)
	@Max(999)
	private Integer idLuogoArrivo;
	@NotNull
	@Min(0)
	@Max(999)
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

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
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
