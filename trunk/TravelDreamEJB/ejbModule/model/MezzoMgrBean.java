package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.LuogoDTO;
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
    @Override
  	public List<MezzoDTO> getMezzo() {
    	List<Mezzotrasporto> ele=new ArrayList<Mezzotrasporto>();
        ele=em.createNamedQuery(Mezzotrasporto.FIND_ALL, Mezzotrasporto.class).getResultList();
        MezzoDTO eleDTO;
        List<MezzoDTO> elementDTO=new ArrayList<MezzoDTO>();
        for(Mezzotrasporto e:ele)
        {
            eleDTO= convertToDTO(e);
            elementDTO.add(eleDTO);
        }
        return elementDTO;
  		
  	}

    
    private MezzoDTO convertToDTO(Mezzotrasporto user) {
    	MezzoDTO userDTO = new MezzoDTO();
    	userDTO.setCostoPers(user.getCostoPers());
    	userDTO.setDataFine(user.getDataFine());
    	userDTO.setDataInizio(user.getDataInizio());
    	userDTO.setIdLuogoArrivo(user.getIdLuogoArrivo());
    	userDTO.setIdLuogoPartenza(user.getIdLuogoPartenza());
    	userDTO.setIdMezzoTrasporto(user.getIdMezzoTrasporto());
    	userDTO.setPostiDisponibili(user.getPostiDisponibili());
    	
    	return userDTO;
    }

}
