package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.AderiscegiftlistDTO;
import model.dto.GiftlistDTO;

/**
 * Session Bean implementation class AderiscegiftlistMgrBean
 */
@Stateless
public class AderiscegiftlistMgrBean implements AderiscegiftlistMgr {

	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
    /**
     * Default constructor. 
     */
    public AderiscegiftlistMgrBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
  	public void save(AderiscegiftlistDTO gif) {
  		Aderiscegiftlist newGif = new Aderiscegiftlist(gif);
  		em.persist(newGif);
  	}
            
    @Override
  	public List<AderiscegiftlistDTO> getAderiscegiftlistUser(int idGift) {
    	List<Aderiscegiftlist> ele=new ArrayList<Aderiscegiftlist>();
        ele=em.createNamedQuery(Aderiscegiftlist.FIND_GIFT, Aderiscegiftlist.class).setParameter("idGift", idGift).getResultList();
        List<AderiscegiftlistDTO> elementDTO=new ArrayList<AderiscegiftlistDTO>();
        for(Aderiscegiftlist e:ele)
        {
            elementDTO.add(convertToDTO(e));
        }
        return elementDTO;
  		
  	}
    
    private AderiscegiftlistDTO convertToDTO(Aderiscegiftlist gif) {
		AderiscegiftlistDTO gifDTO = new AderiscegiftlistDTO();
		gifDTO.setId(gif.getId());
		
		gifDTO.setIdGift(gif.getIdGift());
		gifDTO.setIdUtente(gif.getIdUtente());
		return gifDTO;
	}

    
    
}
