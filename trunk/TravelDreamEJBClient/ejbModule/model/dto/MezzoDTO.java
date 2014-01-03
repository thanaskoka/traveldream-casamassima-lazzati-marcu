package model.dto;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
public class MezzoDTO {
	
	private int idMezzoTrasporto;

	private int costoPers;
	@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", message="Invalid date")
	private String dataFine;
	@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", message="Invalid date")
	private String dataInizio;
	
	private int idLuogoArrivo;

	private int idLuogoPartenza;

	private int postiDisponibili;

	public int getIdMezzoTrasporto() {
		return idMezzoTrasporto;
	}

	public void setIdMezzoTrasporto(int idMezzoTrasporto) {
		this.idMezzoTrasporto = idMezzoTrasporto;
	}

	public int getCostoPers() {
		return costoPers;
	}

	public void setCostoPers(int costoPers) {
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

	public int getIdLuogoArrivo() {
		return idLuogoArrivo;
	}

	public void setIdLuogoArrivo(int idLuogoArrivo) {
		this.idLuogoArrivo = idLuogoArrivo;
	}

	public int getIdLuogoPartenza() {
		return idLuogoPartenza;
	}

	public void setIdLuogoPartenza(int idLuogoPartenza) {
		this.idLuogoPartenza = idLuogoPartenza;
	}

	public int getPostiDisponibili() {
		return postiDisponibili;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

}
