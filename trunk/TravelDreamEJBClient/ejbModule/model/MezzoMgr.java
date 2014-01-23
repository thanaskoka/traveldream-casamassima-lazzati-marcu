package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.dto.MezzoDTO;

@Local
public interface MezzoMgr {
	
	public void save(MezzoDTO mezzo);
	public void update(MezzoDTO mezzo);
	public List<MezzoDTO> getMezzo() ;
	public void delete(MezzoDTO mezzo);
	public List<MezzoDTO> getMezzoViaggioAndataA(int lp,int lr,Date data);
	public List<MezzoDTO> getMezzoViaggioAndataR(int lp,int lr,Date data);
	public MezzoDTO returnData(int id);
}
