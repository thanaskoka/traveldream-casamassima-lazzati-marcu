package model;

import javax.ejb.Local;

import model.dto.MezzoDTO;

@Local
public interface MezzoMgr {
	
	public void save(MezzoDTO mezzo);

}
