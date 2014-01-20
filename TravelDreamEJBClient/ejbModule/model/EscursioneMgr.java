package model;

import java.util.List;

import javax.ejb.Local;

import model.dto.EscursioneDTO;

@Local
public interface EscursioneMgr {
	public void save(EscursioneDTO mezzo);
	public List<EscursioneDTO> getEscursioniAl();
	public List<EscursioneDTO> getEscursioniLuogo(String citta) ;

}
