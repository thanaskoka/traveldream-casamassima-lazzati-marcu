package model.dto;


public class AlbergoDTO {

	private int idAlbergo;
	private int idLuogo;
	private String nome;
	private int numeroStelle;
	
	public AlbergoDTO(){
		
	}

	public int getIdAlbergo() {
		return idAlbergo;
	}

	public void setIdAlbergo(int idAlbergo) {
		this.idAlbergo = idAlbergo;
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
