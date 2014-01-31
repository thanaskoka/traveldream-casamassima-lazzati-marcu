package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dto.PacchettoDTO;
import model.dto.StoricoPagamentiDTO;

/**
 * Session Bean implementation class StoricopagamentiMgrBean
 */
@Stateless
public class StoricopagamentiMgrBean implements StoricopagamentiMgr {

	@PersistenceContext
    private EntityManager em;
	
	
    public StoricopagamentiMgrBean() {
       
    }
    
    @Override
    public void save(StoricoPagamentiDTO p) {
    	Storicopagamenti pacc=new Storicopagamenti(p);
    	em.persist(pacc);
    	em.flush();
    	
    }
    
    @Override
    public int findVoloPagato(int gif,int volo)
    {
    	String queryString = "SELECT e FROM Storicopagamenti e WHERE e.giftId= :gif AND e.viaggio=1";
    	Query query = em.createQuery(queryString);
    	query.setParameter("gif", gif);
    	
    	
    	List<Pacchetto> ele=new ArrayList<Pacchetto>();
        ele=query.getResultList();
        if( ele.size()>0)
        return 1;
        else
        	return 0;
  		
  	}
    @Override
    public int findAlbergoPagato(int gif)
    {
    	String queryString = "SELECT e FROM Storicopagamenti e WHERE e.giftId= :gif AND e.albergo=1";
    	Query query = em.createQuery(queryString);
    	query.setParameter("gif", gif);
    	
    	
    	List<Pacchetto> ele=new ArrayList<Pacchetto>();
        ele=query.getResultList();
        if( ele.size()>0)
        return 1;
        else
        	return 0;
  		
  	}
    @Override
    public int findEscursionePagata(int gif,int esc){
    	String queryString = "SELECT e FROM Storicopagamenti e WHERE e.giftId= :gif AND e.escursione=1";
    	Query query = em.createQuery(queryString);
    	query.setParameter("gif", gif);
    	
    	
    	List<Pacchetto> ele=new ArrayList<Pacchetto>();
        ele=query.getResultList();
        if( ele.size()>0)
        return 1;
        else
        	return 0;
  		
  	}
}
