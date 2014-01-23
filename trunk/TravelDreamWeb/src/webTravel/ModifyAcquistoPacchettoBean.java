package webTravel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="modifyPackBean")

@ViewScoped
public class ModifyAcquistoPacchettoBean {
	
	//variabili aggiunte per modifica pacchetto
    private int numPartecipanti;
    private int numMaxPosti;
    private int numMaxCamere;
    private int costoTotale;
    
    public int getNumPartecipanti() {
		return numPartecipanti;
	}
	public void setNumPartecipanti(int numPartecipanti) {
		this.numPartecipanti = numPartecipanti;
	}
	public int getNumMaxPosti() {
		return numMaxPosti;
	}
	public void setNumMaxPosti(int numMaxPosti) {
		this.numMaxPosti = numMaxPosti;
	}
	public int getNumMaxCamere() {
		return numMaxCamere;
	}
	public void setNumMaxCamere(int numMaxCamere) {
		this.numMaxCamere = numMaxCamere;
	}
	public int getCostoTotale() {
		return costoTotale;
	}
	public void setCostoTotale(int costoTotale) {
		this.costoTotale = costoTotale;
	}
}
