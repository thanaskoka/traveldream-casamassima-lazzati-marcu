package webTravel;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.LuogoMgr;
import model.EscursioneMgr;
import model.dto.LuogoDTO;
import model.dto.EscursioneDTO;


	@ManagedBean(name="registerEscursioneBean")
	@RequestScoped
	public class RegisterEscursioneBean {
		

		@EJB
		private EscursioneMgr mezzoMgr;

		private EscursioneDTO mezzo;
		@EJB
		private LuogoMgr luogoMgr;
		private int luogo=-1;
		
		private Date dateP;
		private Date dateA;
		
		public RegisterEscursioneBean () {
			mezzo = new EscursioneDTO();
		}
		public Date getDateP() {
			return dateP;
		}

		public void setDateP(Date dateP) {
			this.dateP = dateP;
		}

		public Date getDateA() {
			return dateA;
		}

		public void setDateA(Date dateA) {
			this.dateA = dateA;
		}

		public Integer getLuogo() {
			return luogo;
		}

		public void setLuogo(Integer luogoPartenza) {
			luogo = luogoPartenza;
		}

		private List<LuogoDTO> elelis;
		
		
		

		@PostConstruct
	    public void init()
	    {
	        setElelis(luogoMgr.getLuoghiEsc());
	    }
		
		
		public List<LuogoDTO> getElelis() {
			return elelis;
		}

		public void setElelis(List<LuogoDTO> elelis) {
			this.elelis = elelis;
		}

		

		public EscursioneDTO getEsc() {
			return mezzo;
		}

		public void setEsc(EscursioneDTO m) {
			this.mezzo = m;
		}
		
		public String register() {
			
			mezzo.setIdLuogo(luogo);
			
			mezzo.setDataInizio(dateP);
			mezzo.setDataFine(dateA);
		
			mezzoMgr.save(mezzo);
			return "indexfaces-redirect=true";
		}

	}


