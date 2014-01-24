package model;



import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.AcquistapacchettoDTO;

/**
 * Session Bean implementation class AcquistapacchettoMgrBean
 */
@Stateless
public class AcquistapacchettoMgrBean implements AcquistapacchettoMgr {
	
	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private EJBContext context;
    /**
     * Default constructor. 
     */
    public AcquistapacchettoMgrBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
  	public AcquistapacchettoDTO getAcquistapacchettoById(int id) {
    	Acquistapacchetto ele=new Acquistapacchetto();
        ele=em.find(Acquistapacchetto.class, id);
        AcquistapacchettoDTO elementDTO = convertToDTO(ele);
        return elementDTO;
  		
  	}
    
    private AcquistapacchettoDTO convertToDTO(Acquistapacchetto user) {
		AcquistapacchettoDTO userDTO = new AcquistapacchettoDTO();
		userDTO.setIdPacchetto(user.getIdPacchetto());
		userDTO.setIdUtente(user.getIdUtente());
		userDTO.setNumPers(user.getNumPers());
		return userDTO;
	}
    
    @Override
	public void save(AcquistapacchettoDTO acqpack) {
		Acquistapacchetto newpk = new Acquistapacchetto(acqpack);
		em.persist(newpk);
		em.flush();
	}
    
    @Override
	public void update(AcquistapacchettoDTO acqpack, int id) {
    	Acquistapacchetto newpk = new Acquistapacchetto();
    	newpk = em.find(Acquistapacchetto.class, id);
    	newpk.setIdPacchetto(acqpack.getIdPacchetto());
    	newpk.setIdUtente(acqpack.getIdUtente());
    	newpk.setNumPers(acqpack.getNumPers());
		em.persist(newpk);
		em.flush();
	}
    
    
    
}
