package model.dto;

public class StoricoPagamentiDTO {
	private int idStorico;

	private byte albergo;

	private byte escursione;

	private int giftId;

	private int idElemento;

	private String userId;

	private byte viaggio;

	public int getIdStorico() {
		return idStorico;
	}

	public void setIdStorico(int idStorico) {
		this.idStorico = idStorico;
	}

	public byte getAlbergo() {
		return albergo;
	}

	public void setAlbergo(byte albergo) {
		this.albergo = albergo;
	}

	public byte getEscursione() {
		return escursione;
	}

	public void setEscursione(byte escursione) {
		this.escursione = escursione;
	}

	public int getGiftId() {
		return giftId;
	}

	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}

	public int getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte getViaggio() {
		return viaggio;
	}

	public void setViaggio(byte viaggio) {
		this.viaggio = viaggio;
	}


}
