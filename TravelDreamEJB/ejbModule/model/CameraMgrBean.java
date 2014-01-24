package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dto.CameraDTO;
import model.dto.EscursioneDTO;

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
    
    public  CameraDTO getSingole(int idal){
    	
    	String queryString = "SELECT e FROM Camera e " +
                "WHERE e.idAlbergo=:id AND e.numPersCam=1";
    	Query query = em.createQuery(queryString);
    	query.setParameter("id", idal);
    	Camera ele=new Camera();
        ele=(Camera) query.getSingleResult();
        
        
            
        
        return convertToDTO(ele);
    	
    	
    	
    	
    	
    }
    public  CameraDTO getDoppie(int idal){
    	
    	String queryString = "SELECT e FROM Camera e " +
                "WHERE e.idAlbergo=:id AND e.numPersCam=2";
    	Query query = em.createQuery(queryString);
    	query.setParameter("id", idal);
    	Camera ele=new Camera();
        ele=(Camera) query.getSingleResult();
        
        
            
        
        return convertToDTO(ele);
    	
    	
    	
    	
    	
    }
    public  CameraDTO getTriple(int idal){
	
	String queryString = "SELECT e FROM Camera e " +
            "WHERE e.idAlbergo=:id AND e.numPersCam=3";
	Query query = em.createQuery(queryString);
	query.setParameter("id", idal);
	Camera ele=new Camera();
    ele=(Camera) query.getSingleResult();
    
    
        
    
    return convertToDTO(ele);
	
	
	
	
	
}
    
    public void updateNrCamere(CameraDTO camera){
    	Camera cam= new Camera(camera);
    	Camera camSup=em.createNamedQuery(Camera.FIND_BY_ID,Camera.class).setParameter("id",cam.getIdCamera()).getSingleResult();
        cam.setIdCamera(camSup.getIdCamera());
        em.merge(cam);
        em.flush();
    	
    }
    
    
    
    private CameraDTO convertToDTO(Camera user) {
		CameraDTO userDTO = new CameraDTO();
		userDTO.setCostoPersoneCam(user.getCostoPersoneCam());
		userDTO.setIdAlbergo(user.getIdAlbergo());
		userDTO.setNrCamera(user.getNrCamera());
		userDTO.setNumPersCam(user.getNumPersCam());
		userDTO.setIdCamera(user.getIdCamera());
		
		return userDTO;
	}
    
}
