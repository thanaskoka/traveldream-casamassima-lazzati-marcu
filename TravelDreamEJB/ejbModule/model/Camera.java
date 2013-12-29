package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the camera database table.
 * 
 */
@Entity
@NamedQuery(name="Camera.findAll", query="SELECT c FROM Camera c")
public class Camera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCamera;

	private String costoPersoneCam;

	private int nrCamera;

	private int numPersCam;

	//bi-directional many-to-one association to Albergo
	@ManyToOne
	@JoinColumn(name="idAlbergo")
	private Albergo albergo;

	//bi-directional many-to-one association to Camerepacchetto
	@OneToMany(mappedBy="camera")
	private List<Camerepacchetto> camerepacchettos;

	public Camera() {
	}

	public int getIdCamera() {
		return this.idCamera;
	}

	public void setIdCamera(int idCamera) {
		this.idCamera = idCamera;
	}

	public String getCostoPersoneCam() {
		return this.costoPersoneCam;
	}

	public void setCostoPersoneCam(String costoPersoneCam) {
		this.costoPersoneCam = costoPersoneCam;
	}

	public int getNrCamera() {
		return this.nrCamera;
	}

	public void setNrCamera(int nrCamera) {
		this.nrCamera = nrCamera;
	}

	public int getNumPersCam() {
		return this.numPersCam;
	}

	public void setNumPersCam(int numPersCam) {
		this.numPersCam = numPersCam;
	}

	public Albergo getAlbergo() {
		return this.albergo;
	}

	public void setAlbergo(Albergo albergo) {
		this.albergo = albergo;
	}

	public List<Camerepacchetto> getCamerepacchettos() {
		return this.camerepacchettos;
	}

	public void setCamerepacchettos(List<Camerepacchetto> camerepacchettos) {
		this.camerepacchettos = camerepacchettos;
	}

	public Camerepacchetto addCamerepacchetto(Camerepacchetto camerepacchetto) {
		getCamerepacchettos().add(camerepacchetto);
		camerepacchetto.setCamera(this);

		return camerepacchetto;
	}

	public Camerepacchetto removeCamerepacchetto(Camerepacchetto camerepacchetto) {
		getCamerepacchettos().remove(camerepacchetto);
		camerepacchetto.setCamera(null);

		return camerepacchetto;
	}

}