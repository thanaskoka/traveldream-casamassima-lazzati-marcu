package model;

import java.util.List;

import javax.ejb.Local;

import model.dto.PacchettoDTO;

@Local
public interface PacchettoMgr {

    
    
	 public void save(PacchettoDTO pacc,List<Integer>esc);
    /*public void update(PacchettoDTO pacc);
    
   
    public PacchettoDTO getPacchettoDTO();*/
    
   

}
