package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the impiegato database table.
 * 
 */
@Entity
@NamedQuery(name="Impiegato.findAll", query="SELECT i FROM Impiegato i")
public class Impiegato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUtente;

	private String emailUtente;

	private String password;

	private String username;

	public Impiegato() {
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getEmailUtente() {
		return this.emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}