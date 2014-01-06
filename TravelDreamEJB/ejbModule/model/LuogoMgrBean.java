package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.LuogoDTO;

/**
 * Session Bean implementation class LuogoMgrBean
 */
@Stateless
public class LuogoMgrBean implements LuogoMgr {

	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	public List<LuogoDTO> lugo;
	
	
    public LuogoMgrBean() {
        
    }
    
    @Override
  	public void save(LuogoDTO luogo) {
  		Luogo newLuogo = new Luogo(luogo);
  		em.persist(newLuogo);
  	}
    @Override
  	public List<LuogoDTO> getLuoghi() {
    	List<Luogo> ele=new ArrayList<Luogo>();
        ele=em.createNamedQuery(Luogo.FIND_AEREOPORTI, Luogo.class).getResultList();
        LuogoDTO eleDTO;
        List<LuogoDTO> elementDTO=new ArrayList<LuogoDTO>();
        for(Luogo e:ele)
        {
            eleDTO= convertToDTO(e);
            elementDTO.add(eleDTO);
        }
        return elementDTO;
  		
  	}
    @Override
  	public List<LuogoDTO> getLuoghiEsc() {
    	List<Luogo> ele=new ArrayList<Luogo>();
        ele=em.createNamedQuery(Luogo.FIND_ESCURSIONI, Luogo.class).getResultList();
        LuogoDTO eleDTO;
        List<LuogoDTO> elementDTO=new ArrayList<LuogoDTO>();
        for(Luogo e:ele)
        {
            eleDTO= convertToDTO(e);
            elementDTO.add(eleDTO);
        }
        return elementDTO;
  		
  	}
    private LuogoDTO convertToDTO(Luogo user) {
		LuogoDTO userDTO = new LuogoDTO();
		userDTO.setCitta(user.getCitta());
		userDTO.setDescrizione(user.getDescrizione());
		userDTO.setIndirizzo(user.getIndirizzo());
		userDTO.setStato(user.getNazione());
		userDTO.setId(user.getId());
		return userDTO;
	}

}