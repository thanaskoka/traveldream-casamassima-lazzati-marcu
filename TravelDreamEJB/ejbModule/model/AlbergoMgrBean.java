package model;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.AlbergoDTO;

/**
 * Session Bean implementation class AlbergoMgrBean
 */
@Stateless
public class AlbergoMgrBean implements AlbergoMgr {

    /**
     * Default constructor. 
     */
    public AlbergoMgrBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
    @Override
	public void save(AlbergoDTO al) {
		Albergo newAl = new Albergo(al);
		em.persist(newAl);
	}

}
