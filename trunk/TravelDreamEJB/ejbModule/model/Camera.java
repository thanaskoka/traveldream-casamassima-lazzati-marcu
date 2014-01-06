package model;

import java.io.Serializable;
import javax.persistence.*;


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

	private int idAlbergo;

	private int nrCamera;

	private int numPersCam;

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

	public int getIdAlbergo() {
		return this.idAlbergo;
	}

	public void setIdAlbergo(int idAlbergo) {
		this.idAlbergo = idAlbergo;
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

}