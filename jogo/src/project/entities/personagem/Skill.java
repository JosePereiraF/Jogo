package project.entities.personagem;

public class Skill {
	private String nome;
	private int dano;
	private String efeito;
	
	public Skill(String nome, int dano, String efeito) {
		this.nome = nome;
		this.dano = dano;
		this.efeito = efeito;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public String getEfeito() {
		return efeito;
	}
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}
}
