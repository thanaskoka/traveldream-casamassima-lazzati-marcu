package model;

import java.util.List;

import javax.ejb.Local;

import model.dto.AlbergoDTO;
import model.dto.EscursioneDTO;

@Local
public interface AlbergoMgr {
	public void save(AlbergoDTO alb);
	public List<AlbergoDTO> getAlbergoAl();
}
