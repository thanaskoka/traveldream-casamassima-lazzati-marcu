package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.PartecipaPacchettoDTO;

/**
 * Session Bean implementation class PartecipaPacchettoMgrBean
 */
@Stateless
public class PartecipaPacchettoMgrBean implements PartecipaPacchettoMgr {

	@PersistenceContext
    private EntityManager em;
	
    public PartecipaPacchettoMgrBean() {
        // TODO Auto-generated constructor stub
    }
    
    public void save(PartecipaPacchettoDTO pp){
    	
    	Partecipapacchetto p=new Partecipapacchetto(pp);
    	em.persist(p);
    	em.flush();
    	
    	
    }

}
