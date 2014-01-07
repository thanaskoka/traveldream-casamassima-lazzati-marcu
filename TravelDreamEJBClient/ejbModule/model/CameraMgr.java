package model;

import javax.ejb.Local;

import model.dto.CameraDTO;


@Local
public interface CameraMgr {
	public void save(CameraDTO cam);
}
