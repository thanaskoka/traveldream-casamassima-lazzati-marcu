package model;

import java.io.Serializable;

import javax.persistence.*;

import model.dto.AlbergoDTO;


/**
 * The persistent class for the albergo database table.
 * 
 */
@Entity
@NamedQuery(name="Albergo.findAll", query="SELECT a FROM Albergo a")
public class Albergo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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