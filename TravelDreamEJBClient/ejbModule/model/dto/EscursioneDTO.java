package model.dto;

import java.util.Date;

public class EscursioneDTO {
	
	
	private int idLuogo;
	private Date dataInizio;
	private Date dataFine;
	private int costoPersona;
	private int postiDisp;
	private String descrizone;
	
	public int getIdLuogo() {
		return idLuogo;
	}
	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}
	
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public int getCostoPersona() {
		return costoPersona;
	}
	public void setCostoPersona(int costoPersona) {
		this.costoPersona = costoPersona;
	}
	public int getPostiDisp() {
		return postiDisp;
	}
	public void setPostiDisp(int postiDisp) {
		this.postiDisp = postiDisp;
	}
	public String getDescrizone() {
		return descrizone;
	}
	public void setDescrizone(String descrizone) {
		this.descrizone = descrizone;
	}
	

}
