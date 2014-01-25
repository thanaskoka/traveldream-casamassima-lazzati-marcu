package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.dto.PacchettoDTO;

@Local
public interface PacchettoMgr {

    
    
	 public void save(PacchettoDTO pacc,List<Integer>esc);
	 public void update(PacchettoDTO defpack, List<Integer>esc);
    /*public void update(PacchettoDTO pacc);*/
     public PacchettoDTO getPacchettoById(int id);
     public List<PacchettoDTO> getPacchettiLuogoData(int citta,Date ripartenza);
     public List<PacchettoDTO> getPacchetti();
     public List<PacchettoDTO> getPacchettiUser(String nome);
     public List<PacchettoDTO> getPacchettiUserInvitato(String nome);
   

}
