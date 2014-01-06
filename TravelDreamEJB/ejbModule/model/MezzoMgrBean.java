package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.MezzoDTO;

/**
 * Session Bean implementation class MezzoMgrBean
 */
@Stateless
public class MezzoMgrBean implements MezzoMgr {

	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
	
    public MezzoMgrBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void save(MezzoDTO user) {
		Mezzotrasporto newUser = new Mezzotrasporto(user);
		em.persist(newUser);
	}


}
