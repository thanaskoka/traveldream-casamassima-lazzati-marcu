package model;




import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dto.EscursioniPacchettoDTO;

/**
 * Session Bean implementation class EscursioniPacchettoMgrBean
 */
@Stateless
public class EscursioniPacchettoMgrBean implements EscursioniPacchettoMgr {

	
	
	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
	
    
    public void save(int idEsc, int idPacc) {
    	
		
    }
    
    @Override
    public ArrayList<EscursioniPacchettoDTO> getEscPackByPackId(int id){
    	String queryString = "SELECT e FROM Escursionipacchetto e " +
                "WHERE e.idPacchetto = :id";
    	Query query = em.createQuery(queryString);
    	query.setParameter("id", id);
    	
    	List<Escursionipacchetto> ele=new ArrayList<Escursionipacchetto>();
        ele=query.getResultList();
        ArrayList<EscursioniPacchettoDTO> elementDTO=new ArrayList<EscursioniPacchettoDTO>();
        for(Escursionipacchetto e:ele)
        {
            elementDTO.add(convertToDTO(e));
        }
        return elementDTO;
    }
    
    private EscursioniPacchettoDTO convertToDTO(Escursionipacchetto p){
    	EscursioniPacchettoDTO newp = new EscursioniPacchettoDTO();
    	newp.setIdEscursione(p.getIdEscursione());
    	newp.setIdPacchetto(p.getIdPacchetto());
    	return newp;
    }

}
