package project.funcionalidade;

import java.util.Scanner;

import project.entities.personagem.Personagem;

public class Menu {

	public void menu() {
		int escolha;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Digite 1 para criar um personagem. \n2-para mostrar os personagens disponiveis. \n 3- para começar a batalha");
		escolha = sc.nextInt();
		switch(escolha) {
		case 1:
			Criacao criacao = new Criacao();
			criacao.personagem();
			break;
		case 2:
			Personagem personagem_a = new Personagem();
			personagem_a.escolha_personagem();
			Personagem personagem_b = new Personagem();
			personagem_b.escolha_personagem();
			Batalha batalha = new Batalha();
			batalha.simulacao(personagem_a, personagem_b);
			break;
		case 3:
			//Batalha batalha = new Batalha();
			//batalha.simulacao(personagem, personagem);
			break;
		default:
			System.out.println("opção invalida!");
			break;
		}
	}
}
