package model;



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
	
    /**
     * Default constructor. 
     */
    public EscursioniPacchettoMgrBean() {
        // TODO Auto-generated constructor stub
    }
    
    public void save(int idEsc, int idPacc) {
    	Escursionipacchetto escu=new Escursionipacchetto();
		em.flush();
		escu.setIdEscursione(idEsc);
		escu.setIdPacchetto(idPacc);
		em.persist(escu);
    }

}
