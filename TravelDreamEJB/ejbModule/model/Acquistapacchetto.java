package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the acquistapacchetto database table.
 * 
 */
@Entity
@NamedQuery(name="Acquistapacchetto.findAll", query="SELECT a FROM Acquistapacchetto a")
public class Acquistapacchetto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int numPers;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUtente")
	private User user;

	//bi-directional many-to-one association to Pacchetto
	@ManyToOne
	@JoinColumn(name="idPacchetto")
	private Pacchetto pacchetto;

	public Acquistapacchetto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPers() {
		return this.numPers;
	}

	public void setNumPers(int numPers) {
		this.numPers = numPers;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pacchetto getPacchetto() {
		return this.pacchetto;
	}

	public void setPacchetto(Pacchetto pacchetto) {
		this.pacchetto = pacchetto;
	}

}