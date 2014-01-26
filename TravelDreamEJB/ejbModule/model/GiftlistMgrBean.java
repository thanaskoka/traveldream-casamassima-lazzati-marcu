package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.GiftlistDTO;

/**
 * Session Bean implementation class GiftlistMgrBean
 */
@Stateless
@LocalBean
public class GiftlistMgrBean implements GiftlistMgr{
	
	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
	
    /**
     * Default constructor. 
     */
    public GiftlistMgrBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
  	public void save(GiftlistDTO gif) {
  		Giftlist newGif = new Giftlist(gif);
  		em.persist(newGif);
  	}
    
    @Override
  	public List<GiftlistDTO> getGiftlistUser(int idUser) {
    	List<Giftlist> ele=new ArrayList<Giftlist>();
        ele=em.createNamedQuery(Giftlist.FIND_UTENTE, Giftlist.class).setParameter("idUser", idUser).getResultList();
        List<GiftlistDTO> elementDTO=new ArrayList<GiftlistDTO>();
        for(Giftlist e:ele)
        {
            elementDTO.add(convertToDTO(e));
        }
        return elementDTO;
  		
  	}
    
    private GiftlistDTO convertToDTO(Giftlist gif) {
		GiftlistDTO gifDTO = new GiftlistDTO();
		gifDTO.setIdGiftlist(gif.getIdGiftlist());
		gifDTO.setIdPack(gif.getIdPack());
		gifDTO.setIdUser(gif.getIdUser());
		return gifDTO;
	}

}
