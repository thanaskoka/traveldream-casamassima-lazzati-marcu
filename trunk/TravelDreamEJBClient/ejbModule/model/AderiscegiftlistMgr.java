package model;

import java.util.List;

import javax.ejb.Local;

import model.dto.AderiscegiftlistDTO;

@Local
public interface AderiscegiftlistMgr {
	public void save(AderiscegiftlistDTO gif);
	public List<AderiscegiftlistDTO> getAderiscegiftlistUser(int idGift);
}
