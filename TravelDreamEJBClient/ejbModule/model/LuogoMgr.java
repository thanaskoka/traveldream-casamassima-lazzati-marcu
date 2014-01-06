package model;

import java.util.List;

import javax.ejb.Local;

import model.dto.LuogoDTO;
@Local
public interface LuogoMgr {
	
	public List<LuogoDTO> getLuoghi();
	public void save(LuogoDTO luogo) ;

}
