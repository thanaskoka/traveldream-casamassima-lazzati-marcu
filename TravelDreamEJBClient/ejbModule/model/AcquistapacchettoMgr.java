package model;



import javax.ejb.Local;

import model.dto.AcquistapacchettoDTO;

@Local
public interface AcquistapacchettoMgr {
	public void save(AcquistapacchettoDTO alb);
	public void update(AcquistapacchettoDTO alb, int id);
	public AcquistapacchettoDTO getAcquistapacchettoById(int id);
}
