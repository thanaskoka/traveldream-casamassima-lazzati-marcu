package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mezzotrasporto database table.
 * 
 */
@Entity
@NamedQuery(name="Mezzotrasporto.findAll", query="SELECT m FROM Mezzotrasporto m")
public class Mezzotrasporto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMezzoTrasporto;

	private String classe;

	private String costoPers;

	@Temporal(TemporalType.DATE)
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	private Date dataInizio;

	private int numperstrasp;

	private int postiDisponibili;

	//bi-directional many-to-one association to Elememtobase
	@OneToMany(mappedBy="mezzotrasporto")
	private List<Elememtobase> elememtobases;

	//bi-directional many-to-one association to Luogo
	@ManyToOne
	@JoinColumn(name="IdLuogo")
	private Luogo luogo;

	//bi-directional many-to-one association to Viaggio
	@OneToMany(mappedBy="mezzotrasporto")
	private List<Viaggio> viaggios;

	public Mezzotrasporto() {
	}

	public int getIdMezzoTrasporto() {
		return this.idMezzoTrasporto;
	}

	public void setIdMezzoTrasporto(int idMezzoTrasporto) {
		this.idMezzoTrasporto = idMezzoTrasporto;
	}

	public String getClasse() {
		return this.classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getCostoPers() {
		return this.costoPers;
	}

	public void setCostoPers(String costoPers) {
		this.costoPers = costoPers;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getNumperstrasp() {
		return this.numperstrasp;
	}

	public void setNumperstrasp(int numperstrasp) {
		this.numperstrasp = numperstrasp;
	}

	public int getPostiDisponibili() {
		return this.postiDisponibili;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	public List<Elememtobase> getElememtobases() {
		return this.elememtobases;
	}

	public void setElememtobases(List<Elememtobase> elememtobases) {
		this.elememtobases = elememtobases;
	}

	public Elememtobase addElememtobas(Elememtobase elememtobas) {
		getElememtobases().add(elememtobas);
		elememtobas.setMezzotrasporto(this);

		return elememtobas;
	}

	public Elememtobase removeElememtobas(Elememtobase elememtobas) {
		getElememtobases().remove(elememtobas);
		elememtobas.setMezzotrasporto(null);

		return elememtobas;
	}

	public Luogo getLuogo() {
		return this.luogo;
	}

	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}

	public List<Viaggio> getViaggios() {
		return this.viaggios;
	}

	public void setViaggios(List<Viaggio> viaggios) {
		this.viaggios = viaggios;
	}

	public Viaggio addViaggio(Viaggio viaggio) {
		getViaggios().add(viaggio);
		viaggio.setMezzotrasporto(this);

		return viaggio;
	}

	public Viaggio removeViaggio(Viaggio viaggio) {
		getViaggios().remove(viaggio);
		viaggio.setMezzotrasporto(null);

		return viaggio;
	}

}