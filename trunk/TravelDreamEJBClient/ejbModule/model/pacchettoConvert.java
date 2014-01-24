package model;

import java.util.Date;

public class pacchettoConvert {
	
	private String Albergo;
	private Date VoloAndata;
	private Date VoloRitorno;
	private String Luogo;
	private int id;
	private int idAlb;
	
	public int getIdAlb() {
		return idAlb;
	}

	public void setIdAlb(int idAlb) {
		this.idAlb = idAlb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public pacchettoConvert(){}

	public String getAlbergo() {
		return Albergo;
	}

	public void setAlbergo(String albergo) {
		Albergo = albergo;
	}

	public Date getVoloAndata() {
		return VoloAndata;
	}

	public void setVoloAndata(Date voloAndata) {
		VoloAndata = voloAndata;
	}

	public Date getVoloRitorno() {
		return VoloRitorno;
	}

	public void setVoloRitorno(Date voloRitorno) {
		VoloRitorno = voloRitorno;
	}

	public String getLuogo() {
		return Luogo;
	}

	public void setLuogo(String luogo) {
		Luogo = luogo;
	}
	
	
	

}
