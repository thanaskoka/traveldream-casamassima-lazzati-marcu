package model.dto;

import javax.validation.constraints.NotNull;

public class AcquistapacchettoDTO {
	@NotNull
	private int idPacchetto;
	@NotNull
	private String idUtente;
	@NotNull
	private int numPers;
	public int getIdPacchetto() {
		return idPacchetto;
	}
	public void setIdPacchetto(int idPacchetto) {
		this.idPacchetto = idPacchetto;
	}
	public String getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}
	public int getNumPers() {
		return numPers;
	}
	public void setNumPers(int numPers) {
		this.numPers = numPers;
	}
	
	
}
