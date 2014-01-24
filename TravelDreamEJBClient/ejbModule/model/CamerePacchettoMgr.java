package model;

import javax.ejb.Local;

import model.dto.CamerapacchettoDTO;

@Local
public interface CamerePacchettoMgr {
	
	public void save(CamerapacchettoDTO cam);
	


}
