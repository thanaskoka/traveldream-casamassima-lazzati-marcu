package testTravel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;



import javax.ejb.EJB;

import model.AlbergoMgr;
import model.CameraMgr;
import model.LuogoMgr;
import model.dto.AlbergoDTO;
import model.dto.CameraDTO;
import model.dto.LuogoDTO;

import org.junit.Before;
import org.junit.Test;

public class NewAlbergoTest {

	@EJB
	private AlbergoMgr alMgr;

	private AlbergoDTO al;
	
	@EJB
	private LuogoMgr luogoMgr;
	
	private LuogoDTO l;
	
	@EJB
	private CameraMgr camMgr;
	
		
	private CameraDTO cam;
	private int opt1=1;
	
	private float costo1;
    
	
	private List<LuogoDTO> elelis;
	private List<AlbergoDTO> allis;
	
	
	
	
	@Before
    public void init()
    {
		allis = new ArrayList<AlbergoDTO>();
		elelis = new ArrayList<LuogoDTO>();
		
		//aggiungo alle liste le ultime tuple presenti nel database
		
        al = new AlbergoDTO();
        al.setId(13);
        al.setIdLuogo(6);
        al.setNome("prova");
        al.setNumeroStelle(5);
        allis.add(al);
        
        l = new LuogoDTO();
        l.setCitta("milano");
        l.setDescrizione("dddd");
        l.setId(6);
        l.setIndirizzo("ind");
        l.setStato("italia");
        elelis.add(l);
    }
	
	
	
	public void setAllis(List<AlbergoDTO> allis) {
		this.allis = allis;
	}


	public void setElelis(List<LuogoDTO> elelis) {
		this.elelis = elelis;
	}
	
	@Before
	public void register() {
		
		al.setIdLuogo(elelis.get(elelis.size()-1).getId());
		if(opt1>0){
			cam = new CameraDTO();
			cam.setIdAlbergo(allis.get(allis.size()-1).getId());
			cam.setCostoPersoneCam(costo1);;
			cam.setNrCamera(opt1);
			cam.setNumPersCam(1);
			
		}
		
	}
	
	@Test
	public void test() {
		//scelgo come oracolo del test gli id degli ultimi due elementi inseriti nel database nelle tabelle albergo e luogo
		int orac1=13, orac2=6;
		
		//verifico che gli elenchi di alberghi e luoghi esistano
		assertNotNull(elelis);
		assertNotNull(allis);
		
		//verifico che le chiavi esterne idAlbergo e idLuogo corrispondano ai valori scelti come oracolo
		assertEquals(orac1, cam.getIdAlbergo());
		assertEquals(orac2, al.getIdLuogo());
	}

}
