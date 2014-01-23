package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    @Override
  	public List<AlbergoDTO> getAlbergoAl() {
    	List<Albergo> ele=new ArrayList<Albergo>();
        ele=em.createNamedQuery(Albergo.FIND_ALL, Albergo.class).getResultList();
        List<AlbergoDTO> elementDTO=new ArrayList<AlbergoDTO>();
        for(Albergo e:ele)
        {
            elementDTO.add(convertToDTO(e));
        }
        return elementDTO;
  		
  	}
    @Override
  	public List<AlbergoDTO> getAlbergoByLuogo(String citta) {
    	String queryString = "SELECT e FROM Albergo e " +
                "INNER JOIN Luogo l WHERE e.idLuogo=l.id AND l.citta= :citta";
    	Query query = em.createQuery(queryString);
    	query.setParameter("citta", citta);
    	List<Albergo> ele=new ArrayList<Albergo>();
        ele=query.getResultList();
        List<AlbergoDTO> elementDTO=new ArrayList<AlbergoDTO>();
        for(Albergo e:ele)
        {
            elementDTO.add(convertToDTO(e));
        }
        return elementDTO;
  		
  	}
    

    private AlbergoDTO convertToDTO(Albergo user) {
		AlbergoDTO userDTO = new AlbergoDTO();
		userDTO.setId(user.getIdAlbergo());
		userDTO.setIdLuogo(user.getIdLuogo());
		userDTO.setNome(user.getNome());
		userDTO.setNumeroStelle(user.getNumeroStelle());
		return userDTO;
	}

}
