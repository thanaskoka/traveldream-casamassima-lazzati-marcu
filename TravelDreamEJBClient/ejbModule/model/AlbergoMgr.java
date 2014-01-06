package model;

import javax.ejb.Local;

import model.dto.AlbergoDTO;

@Local
public interface AlbergoMgr {
	public void save(AlbergoDTO alb);
}
