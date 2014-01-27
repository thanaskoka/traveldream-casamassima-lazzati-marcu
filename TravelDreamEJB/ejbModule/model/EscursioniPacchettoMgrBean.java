package model;




import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class EscursioniPacchettoMgrBean
 */
@Stateless
public class EscursioniPacchettoMgrBean implements EscursioniPacchettoMgr {

	
	
	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
    
    public void save(int idEsc, int idPacc) {
    	
		
    }

}
