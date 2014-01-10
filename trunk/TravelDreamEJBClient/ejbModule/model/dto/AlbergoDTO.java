package model.dto;

import javax.validation.constraints.NotNull;


public class AlbergoDTO {
	
	@NotNull
	private int idLuogo;
	@NotNull
	private String nome;
	@NotNull
	private int numeroStelle;
	
	private int id;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public AlbergoDTO(){
		
	}

	

	public int getIdLuogo() {
		return idLuogo;
	}

	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroStelle() {
		return numeroStelle;
	}

	public void setNumeroStelle(int numeroStelle) {
		this.numeroStelle = numeroStelle;
	}
	
	
}
