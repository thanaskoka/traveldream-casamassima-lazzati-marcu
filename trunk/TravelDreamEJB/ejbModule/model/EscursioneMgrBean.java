package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import com.sun.xml.internal.ws.util.StringUtils;

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
    @Override
  	public List<EscursioneDTO> getEscursioniLuogo(String citta,Date arrivo,Date ripartenza) {
    	String queryString = "SELECT e FROM Escursione e " +
                "INNER JOIN Luogo l WHERE e.idLuogo=l.id AND l.citta= :citta AND e.dataInizio > :arrivo AND e.dataFine< :ripartenza";
    	Query query = em.createQuery(queryString);
    	query.setParameter("citta", citta);
    	query.setParameter("arrivo", arrivo);
    	query.setParameter("ripartenza", ripartenza);
    	List<Escursione> ele=new ArrayList<Escursione>();
        ele=query.getResultList();
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
