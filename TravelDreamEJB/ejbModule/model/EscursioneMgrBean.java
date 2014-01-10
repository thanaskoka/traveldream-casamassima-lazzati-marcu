package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.EscursioneDTO;
import model.dto.LuogoDTO;

/**
 * Session Bean implementation class EscursioneMgrBean
 */
@Stateless
public class EscursioneMgrBean implements EscursioneMgr {

	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
    public EscursioneMgrBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void save(EscursioneDTO esc) {
		Escursione newEsc = new Escursione(esc);
		em.persist(newEsc);
	}
    
    @Override
  	public List<EscursioneDTO> getEscursioniAl() {
    	List<Escursione> ele=new ArrayList<Escursione>();
        ele=em.createNamedQuery(Escursione.FIND_ALL, Escursione.class).getResultList();
        List<EscursioneDTO> elementDTO=new ArrayList<EscursioneDTO>();
        for(Escursione e:ele)
        {
            elementDTO.add(convertToDTO(e));
        }
        return elementDTO;
  		
  	}

    private EscursioneDTO convertToDTO(Escursione user) {
		EscursioneDTO userDTO = new EscursioneDTO();
		userDTO.setCostoPerEsc(user.getCostoPerEsc());
		userDTO.setDataFine(user.getDataFine());
		userDTO.setDataInizio(user.getDataInizio());
		
		userDTO.setIdLuogo(user.getIdLuogo());
		userDTO.setPostiDisponibili(user.getPostiDisponibili());
		userDTO.setId(user.getId());
		userDTO.setInfoEsc(user.getInfo_escursione());
		return userDTO;
	}
}
