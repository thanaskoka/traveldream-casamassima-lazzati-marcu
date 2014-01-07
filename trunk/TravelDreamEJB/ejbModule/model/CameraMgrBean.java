package model;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.CameraDTO;

/**
 * Session Bean implementation class CameraMgrBean
 */
@Stateless
public class CameraMgrBean implements CameraMgr {

	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
    public CameraMgrBean() {
        // TODO Auto-generated constructor stub
    }
    
    public void save(CameraDTO cam) {
		Camera newCam = new Camera(cam);
		em.persist(newCam);
	}
}
