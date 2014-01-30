package model;

import java.util.ArrayList;

import javax.ejb.Local;

import model.dto.EscursioniPacchettoDTO;

@Local
public interface EscursioniPacchettoMgr {
	public ArrayList<EscursioniPacchettoDTO> getEscPackByPackId(int id);
}
