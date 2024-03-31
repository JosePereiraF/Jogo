package project.enums;

public enum Classe {
	MAGO("Mago"),GUERREIRO("Guerreiro"),ATIRADOR("Atirador"),TANK("Tank");
	private String classe;
	private Classe(String classe) {
		this.classe = classe;
	}
	public String getClasse() {
		return classe;
	}
	
}
