package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.CamerapacchettoDTO;

/**
 * Session Bean implementation class CamerePacchettoMgrBean
 */
@Stateless
public class CamerePacchettoMgrBean implements CamerePacchettoMgr {

	@PersistenceContext
    private EntityManager em;
    public CamerePacchettoMgrBean() {
        
    }
    @Override
    public void save(CamerapacchettoDTO cam){
    	Camerepacchetto newCam = new Camerepacchetto(cam);
		em.persist(newCam);
    	
    	
    }

}
