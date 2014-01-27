package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dto.EscursioneDTO;
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
    @Override
    public GiftlistDTO returnLast(){
    	String queryString = "SELECT p FROM Giftlist p ORDER BY p.idGiftlist DESC";
    	Query query = em.createQuery(queryString);
    	List<Giftlist> ele=new ArrayList<Giftlist>();
        ele=query.getResultList();
       
        
            
        
        return convertToDTO(ele.get(0));
  		
  	   	
    	
    	
    }
    @Override
    public GiftlistDTO returnIdPacc(int p){
    	String queryString = "SELECT p FROM Giftlist p WHERE p.idGiftlist=:p";
    	Query query = em.createQuery(queryString);
    	query.setParameter("p",p);
    	List<Giftlist> ele=new ArrayList<Giftlist>();
        ele=query.getResultList();
       
        
            
        
        return convertToDTO(ele.get(0));
  		
  	   	
    	
    	
    }
    @Override
    public List<GiftlistDTO> returnIdPaccs(String u){
    	String queryString = "SELECT p FROM Giftlist p INNER JOIN Aderiscegiftlist g ON p.idGiftlist=g.idGift WHERE g.idUtente= :g";
    	Query query = em.createQuery(queryString);
    	query.setParameter("g",u);
    	List<Giftlist> ele=new ArrayList<Giftlist>();
        ele=query.getResultList();
        List<GiftlistDTO> elementDTO=new ArrayList<GiftlistDTO>();
        for(Giftlist e:ele)
        {
            elementDTO.add(convertToDTO(e));
        }
        return elementDTO;
     }
    @Override
    public GiftlistDTO returnIdGif(int p,String user){
    	String queryString = "SELECT p FROM Giftlist p WHERE p.idUser=:u AND p.idPack=:p";
    	Query query = em.createQuery(queryString);
    	query.setParameter("p",p);
    	query.setParameter("u",user);
    	List<Giftlist> ele=new ArrayList<Giftlist>();
        ele=query.getResultList();
       
        
            
        
        return convertToDTO(ele.get(0));
  		
  	   	
    	
    	
    }

}
