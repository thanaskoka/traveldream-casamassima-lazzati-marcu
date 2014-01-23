package model;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dto.PacchettoDTO;

/**
 * Session Bean implementation class PacchettoMgrBean
 */
@Stateless
public class PacchettoMgrBean implements PacchettoMgr {

	
	
	 
    @PersistenceContext
    private EntityManager em;
    
    @Resource
    private EJBContext context;
    
    @Override
    public void save(PacchettoDTO pk,List<Integer>esc) {
    	EscursioniPacchettoMgrBean esM = new EscursioniPacchettoMgrBean();
    	Pacchetto pacc = new Pacchetto(pk);
    	em.persist(pacc);
    	em.flush();
    	List <Pacchetto> idPac=em.createNamedQuery(Pacchetto.FIND_ALL, Pacchetto.class).getResultList();
    	int idPacc=idPac.get(0).getIdPacchetto();
    			
		for(int i=0;i<esc.size();i++)
			esM.save(esc.get(i).intValue(), idPacc);
    	    	
    }
    
    @Override
	public void update(PacchettoDTO defpack, List<Integer>esc) {
    	Pacchetto newpk = new Pacchetto();
    	newpk = em.find(Pacchetto.class, defpack.getIdPacchetto());
    	newpk.setIdAlbergo(defpack.getIdAlbergo());
    	newpk.setIdLuogo(defpack.getIdLuogo());
    	newpk.setIdMezzoAndata(defpack.getIdMezzoAndata());
    	newpk.setIdMezzoRitorno(defpack.getIdMezzoRitorno());
    	newpk.setIdPacchetto(defpack.getIdPacchetto());
    	newpk.setIsModify(defpack.getIsModify());
    	newpk.setTitolo(defpack.getTitolo());
		em.persist(newpk);
		em.flush();
	}
    
        
    @Override
    public PacchettoDTO getPacchettoById(int id) {
    	Pacchetto ele=new Pacchetto();
        ele=em.find(Pacchetto.class, id);
        PacchettoDTO elementDTO = convertToDTO(ele);
        return elementDTO;
    }
    
    private PacchettoDTO convertToDTO(Pacchetto p){
    	PacchettoDTO newp = new PacchettoDTO();
    	newp.setIdAlbergo(p.getIdAlbergo());
    	newp.setIdLuogo(p.getIdLuogo());
    	newp.setIdMezzoAndata(p.getIdMezzoAndata());
    	newp.setIdMezzoRitorno(p.getIdMezzoRitorno());
    	newp.setIdPacchetto(p.getIdPacchetto());
    	newp.setIsModify(p.getIsModify());
    	newp.setTitolo(p.getTitolo());
    	
    	return newp;
    }
    
    public void elimina(Pacchetto pacc) {
        em.remove(pacc);
    }
    
    
    public PacchettoMgrBean() {
        // TODO Auto-generated constructor stub
    }

}
