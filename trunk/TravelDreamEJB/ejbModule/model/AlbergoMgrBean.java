package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.AlbergoDTO;
import model.dto.EscursioneDTO;

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

    private AlbergoDTO convertToDTO(Albergo user) {
		AlbergoDTO userDTO = new AlbergoDTO();
		userDTO.setId(user.getIdAlbergo());
		userDTO.setIdLuogo(user.getIdLuogo());
		userDTO.setNome(user.getNome());
		userDTO.setNumeroStelle(user.getNumeroStelle());
		return userDTO;
	}

}
