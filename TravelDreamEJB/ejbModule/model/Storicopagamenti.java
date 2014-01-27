package model;

import java.io.Serializable;
import javax.persistence.*;


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

	private byte albergo;

	private byte escursione;

	private int giftId;

	private int idElemento;

	private String userId;

	private byte viaggio;

	public Storicopagamenti() {
	}

	public int getIdStorico() {
		return this.idStorico;
	}

	public void setIdStorico(int idStorico) {
		this.idStorico = idStorico;
	}

	public byte getAlbergo() {
		return this.albergo;
	}

	public void setAlbergo(byte albergo) {
		this.albergo = albergo;
	}

	public byte getEscursione() {
		return this.escursione;
	}

	public void setEscursione(byte escursione) {
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

	public byte getViaggio() {
		return this.viaggio;
	}

	public void setViaggio(byte viaggio) {
		this.viaggio = viaggio;
	}

}