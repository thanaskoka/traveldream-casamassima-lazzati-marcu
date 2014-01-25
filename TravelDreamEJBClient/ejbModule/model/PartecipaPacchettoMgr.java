package model;

import javax.ejb.Local;

import model.dto.PartecipaPacchettoDTO;

@Local
public interface PartecipaPacchettoMgr {
	
	public void save(PartecipaPacchettoDTO pp);

}
