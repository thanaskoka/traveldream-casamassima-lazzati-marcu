package model;

import java.util.List;

import javax.ejb.Local;

import model.dto.LuogoDTO;
@Local
public interface LuogoMgr {
	
	public List<LuogoDTO> getLuoghi();
	public List<LuogoDTO> getLuoghiEsc();
	public List<LuogoDTO> getLuoghiAl();
	public void save(LuogoDTO luogo) ;
	public LuogoDTO getCittaFromId(int id);
	public LuogoDTO getidAereoportiFromcitta(String citta);
	public List<LuogoDTO> getTuttiLuoghi() ;
}