package model;

import javax.ejb.Local;

import model.dto.CameraDTO;


@Local
public interface CameraMgr {
	public void save(CameraDTO cam);
	public  CameraDTO getSingole(int idal);
	public  CameraDTO getDoppie(int idal);
	public  CameraDTO getTriple(int idal);
	public void updateNrCamere(CameraDTO camera);
}
