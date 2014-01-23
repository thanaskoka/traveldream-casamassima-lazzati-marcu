package model;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class AcquistapacchettoMgrBean
 */
@Stateless
public class AcquistapacchettoMgrBean implements AcquistapacchettoMgr {
	
	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
    /**
     * Default constructor. 
     */
    public AcquistapacchettoMgrBean() {
        // TODO Auto-generated constructor stub
    }

}
