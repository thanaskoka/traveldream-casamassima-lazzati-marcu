package model;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.EscursioneDTO;

/**
 * Session Bean implementation class EscursioneMgrBean
 */
@Stateless
public class EscursioneMgrBean implements EscursioneMgr {

	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
    public EscursioneMgrBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void save(EscursioneDTO esc) {
		Escursione newEsc = new Escursione(esc);
		em.persist(newEsc);
	}

}
