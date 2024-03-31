package project.funcionalidade;

import project.entities.personagem.Personagem;

public class Menu {

	public void menu() {
		Criacao criacao = new Criacao();
		criacao.personagem();
		Personagem personagem = new Personagem();
		personagem.mostrar_personagem();
	}
}
