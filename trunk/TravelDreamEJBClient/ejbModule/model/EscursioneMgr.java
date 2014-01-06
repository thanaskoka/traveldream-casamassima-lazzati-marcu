package model;

import javax.ejb.Local;

import model.dto.EscursioneDTO;

@Local
public interface EscursioneMgr {
	public void save(EscursioneDTO mezzo);

}
