package model;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.PacchettoDTO;

/**
 * Session Bean implementation class PacchettoMgrBean
 */
@Stateless
public class PacchettoMgrBean implements PacchettoMgr {

	
	
	 
    @PersistenceContext
private EntityManager em;
    
    @Resource
    private EJBContext context;
    
    @Override
    public void save(PacchettoDTO pk,List<Integer>esc) {
    	Pacchetto pacc = new Pacchetto(pk);
    	em.persist(pacc);
    	em.flush();
    	List <Pacchetto> idPac=em.createNamedQuery(Pacchetto.FIND_ALL, Pacchetto.class).getResultList();
    	int idPacc=idPac.get(0).getIdPacchetto();
    	Escursionipacchetto escu=new Escursionipacchetto();
    	for(int i=0;i<esc.size();i++)
    	{
    		escu.setIdEscursione(esc.get(i));
    		escu.setIdPacchetto(idPacc);
    		em.persist(escu);
    		em.flush();
    		
    		
    	}
    	
    	
    }
    
    
    /* @Override
    public void update(PacchettoDTO defpackage) { }
    
   @Override
    public PacchettoDTO getPacchettoDTO() {}
    
    public void elimina(Pacchetto pacc) {
        em.remove(pacc);
        }
    public Pacchetto find(String name) {}
    
  */
    
    public PacchettoMgrBean() {
        // TODO Auto-generated constructor stub
    }

}
