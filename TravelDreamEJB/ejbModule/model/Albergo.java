package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the albergo database table.
 * 
 */
@Entity
@NamedQuery(name="Albergo.findAll", query="SELECT a FROM Albergo a")
public class Albergo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAlbergo;

	@Temporal(TemporalType.DATE)
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	private Date dataInizio;

	private String nome;

	@Column(name="numero_stelle")
	private String numeroStelle;

	private String tipologia;

	//bi-directional many-to-one association to Luogo
	@ManyToOne
	@JoinColumn(name="idLuogo")
	private Luogo luogo;

	//bi-directional many-to-one association to Camera
	@OneToMany(mappedBy="albergo")
	private List<Camera> cameras;

	//bi-directional many-to-one association to Elememtobase
	@OneToMany(mappedBy="albergo")
	private List<Elememtobase> elememtobases;

	//bi-directional many-to-one association to Prenotazionealbergo
	@OneToMany(mappedBy="albergo")
	private List<Prenotazionealbergo> prenotazionealbergos;

	public Albergo() {
	}

	public int getIdAlbergo() {
		return this.idAlbergo;
	}

	public void setIdAlbergo(int idAlbergo) {
		this.idAlbergo = idAlbergo;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroStelle() {
		return this.numeroStelle;
	}

	public void setNumeroStelle(String numeroStelle) {
		this.numeroStelle = numeroStelle;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Luogo getLuogo() {
		return this.luogo;
	}

	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}

	public List<Camera> getCameras() {
		return this.cameras;
	}

	public void setCameras(List<Camera> cameras) {
		this.cameras = cameras;
	}

	public Camera addCamera(Camera camera) {
		getCameras().add(camera);
		camera.setAlbergo(this);

		return camera;
	}

	public Camera removeCamera(Camera camera) {
		getCameras().remove(camera);
		camera.setAlbergo(null);

		return camera;
	}

	public List<Elememtobase> getElememtobases() {
		return this.elememtobases;
	}

	public void setElememtobases(List<Elememtobase> elememtobases) {
		this.elememtobases = elememtobases;
	}

	public Elememtobase addElememtobas(Elememtobase elememtobas) {
		getElememtobases().add(elememtobas);
		elememtobas.setAlbergo(this);

		return elememtobas;
	}

	public Elememtobase removeElememtobas(Elememtobase elememtobas) {
		getElememtobases().remove(elememtobas);
		elememtobas.setAlbergo(null);

		return elememtobas;
	}

	public List<Prenotazionealbergo> getPrenotazionealbergos() {
		return this.prenotazionealbergos;
	}

	public void setPrenotazionealbergos(List<Prenotazionealbergo> prenotazionealbergos) {
		this.prenotazionealbergos = prenotazionealbergos;
	}

	public Prenotazionealbergo addPrenotazionealbergo(Prenotazionealbergo prenotazionealbergo) {
		getPrenotazionealbergos().add(prenotazionealbergo);
		prenotazionealbergo.setAlbergo(this);

		return prenotazionealbergo;
	}

	public Prenotazionealbergo removePrenotazionealbergo(Prenotazionealbergo prenotazionealbergo) {
		getPrenotazionealbergos().remove(prenotazionealbergo);
		prenotazionealbergo.setAlbergo(null);

		return prenotazionealbergo;
	}

}