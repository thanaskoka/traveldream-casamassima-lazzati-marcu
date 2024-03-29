package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.AlbergoDTO;


/**
 * The persistent class for the albergo database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Albergo.findAll", query="SELECT a FROM Albergo a"),
	@NamedQuery(name="Albergo.findbyluogo", query="SELECT a FROM Albergo a WHERE a.idLuogo= :luogo")
})
public class Albergo implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Albergo.findAll";
	public static final String FIND_BY_LUOGO = "Albergo.findbyluogo";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAlbergo")
	private int idAlbergo;

	private int idLuogo;

	private String nome;

	@Column(name="numero_stelle")
	private int numeroStelle;

	public Albergo() {
	}

	public Albergo(AlbergoDTO al){
           this.idLuogo = al.getIdLuogo();
	       this.nome = al.getNome();
	       this.numeroStelle = al.getNumeroStelle();
	}
	
	public int getIdAlbergo() {
		return this.idAlbergo;
	}

	public void setIdAlbergo(int idAlbergo) {
		this.idAlbergo = idAlbergo;
	}

	public int getIdLuogo() {
		return this.idLuogo;
	}

	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroStelle() {
		return this.numeroStelle;
	}

	public void setNumeroStelle(int numeroStelle) {
		this.numeroStelle = numeroStelle;
	}

}