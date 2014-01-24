package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.CameraDTO;


/**
 * The persistent class for the camera database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Camera.findAll", query="SELECT c FROM Camera c"),
	@NamedQuery(name="Camera.findbyid", query="SELECT c FROM Camera c WHERE c.idCamera= :id"),

})
public class Camera implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_ID="Camera.findbyid";
	@Id
	private int idCamera;

	private float costoPersoneCam;

	private int idAlbergo;

	private int nrCamera;

	private int numPersCam;

	public Camera() {
	}
	
	public Camera(CameraDTO al){
        this.costoPersoneCam = al.getCostoPersoneCam();
	    this.idAlbergo = al.getIdAlbergo();
	    this.nrCamera = al.getNrCamera();
	    this.numPersCam = al.getNumPersCam();
	    this.idCamera=al.getIdCamera();
	    
	}

	public int getIdCamera() {
		return this.idCamera;
	}

	public void setIdCamera(int idCamera) {
		this.idCamera = idCamera;
	}

	public float getCostoPersoneCam() {
		return this.costoPersoneCam;
	}

	public void setCostoPersoneCam(float costoPersoneCam) {
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