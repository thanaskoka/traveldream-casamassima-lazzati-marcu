package model.dto;

import java.util.Date;



public class EscursioneDTO {
	
	private int id;

	private int costoPerEsc;

	private String infoEsc;
	

	private Date dataFine;
	private Date dataInizio;

	private int idLuogo;

	private int postiDisponibili;

	private String tipologia;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCostoPerEsc() {
		return costoPerEsc;
	}

	public void setCostoPerEsc(int costoPerEsc) {
		this.costoPerEsc = costoPerEsc;
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

	public int getIdLuogo() {
		return idLuogo;
	}

	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}

	public int getPostiDisponibili() {
		return postiDisponibili;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getInfoEsc() {
		return infoEsc;
	}

	public void setInfoEsc(String infoEsc) {
		this.infoEsc = infoEsc;
	}

	

}
