package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the viaggio database table.
 * 
 */
@Entity
@NamedQuery(name="Viaggio.findAll", query="SELECT v FROM Viaggio v")
public class Viaggio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idViaggio;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String tipo;

	//bi-directional many-to-one association to Pacchetto
	@ManyToOne
	@JoinColumn(name="idPacch")
	private Pacchetto pacchetto;

	//bi-directional many-to-one association to Mezzotrasporto
	@ManyToOne
	@JoinColumn(name="idMezzo")
	private Mezzotrasporto mezzotrasporto;

	public Viaggio() {
	}

	public int getIdViaggio() {
		return this.idViaggio;
	}

	public void setIdViaggio(int idViaggio) {
		this.idViaggio = idViaggio;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pacchetto getPacchetto() {
		return this.pacchetto;
	}

	public void setPacchetto(Pacchetto pacchetto) {
		this.pacchetto = pacchetto;
	}

	public Mezzotrasporto getMezzotrasporto() {
		return this.mezzotrasporto;
	}

	public void setMezzotrasporto(Mezzotrasporto mezzotrasporto) {
		this.mezzotrasporto = mezzotrasporto;
	}

}