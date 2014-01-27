package model;

import java.util.List;

import javax.ejb.Local;

import model.dto.GiftlistDTO;

@Local
public interface GiftlistMgr {
	public void save(GiftlistDTO gif);
    
    public List<GiftlistDTO> getGiftlistUser(int idUser);
    public GiftlistDTO returnLast();
    public GiftlistDTO returnIdPacc(int p);
    public List<GiftlistDTO> returnIdPaccs(String u);
}
