package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.StoricoPagamentiDTO;


/**
 * The persistent class for the storicopagamenti database table.
 * 
 */
@Entity
@NamedQuery(name="Storicopagamenti.findAll", query="SELECT s FROM Storicopagamenti s")
public class Storicopagamenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idStorico;

	private int albergo;

	private int escursione;

	private int giftId;

	private int idElemento;

	private String userId;

	private int viaggio;

	public Storicopagamenti() {
	}
	public Storicopagamenti(StoricoPagamentiDTO stor) {
		this.albergo=stor.getAlbergo();
		this.escursione=stor.getEscursione();
		this.giftId=stor.getGiftId();
		this.idElemento=stor.getIdElemento();
		this.userId=stor.getUserId();
		this.viaggio=stor.getViaggio();
	}

	public int getIdStorico() {
		return this.idStorico;
	}

	public void setIdStorico(int idStorico) {
		this.idStorico = idStorico;
	}

	public int getAlbergo() {
		return this.albergo;
	}

	public void setAlbergo(int albergo) {
		this.albergo = albergo;
	}

	public int getEscursione() {
		return this.escursione;
	}

	public void setEscursione(int escursione) {
		this.escursione = escursione;
	}

	public int getGiftId() {
		return this.giftId;
	}

	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}

	public int getIdElemento() {
		return this.idElemento;
	}

	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getViaggio() {
		return this.viaggio;
	}

	public void setViaggio(int viaggio) {
		this.viaggio = viaggio;
	}

}