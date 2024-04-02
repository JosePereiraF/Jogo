package project;


import java.util.Scanner;

import project.entities.personagem.Personagem;
import project.entities.personagem.Skill;
import project.enums.Classe;
import project.funcionalidade.Batalha;
import project.funcionalidade.Menu;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 1- criar um metodo de sorteador de numero para funcionar como dado (check)       
		 * 2- criar um metodo que calcule o dano dos champ que receba a skill + o valor do dado (check) 
		 * 3- criar um metodo para calcular a vida dos personagens em batalha (check) 
		 * 4- criar um metodo para simular uma batalha para testar ofuncionamento dos metodos (check)
		 * 5- criar um metodo para add personagens(check)
		 * 6- add um metodo para mostrar os personagens (check)
		 * 7- criar um metodo para criar os personagens antes da luta comecar (check)
		 * 8- criar um metodo para aparecer os personagens disponiveis para escolha (check)
		 * 9- colocar um tempo de recarga nas skills 
		 * 10- adaptar para a pessoa poder escolher um time ao inves de jogar com um personagem só
		 */
		Skill skill1 = new Skill("furacão", 10, "stun");
		Skill skill2 = new Skill("furacão2", 15, "stun");
		Skill skill3 = new Skill("furacão3", 20, "stun");
		Skill skill4 = new Skill("teste1", 10, "stun");
		Skill skill5 = new Skill("test2", 15, "stun");
		Skill skill6 = new Skill("teste4", 20, "stun");
		Personagem personagem_a = new Personagem("yasuo", 10, 1.18,10, 30, 100, 30, Classe.GUERREIRO, skill1, skill2,
				skill3);
		Personagem.getLista_personagem().add(personagem_a);

		Personagem personagem_b = new Personagem("yone", 10, 2.00,10, 30, 100, 30, Classe.GUERREIRO, skill1, skill2, skill3);
		Personagem.getLista_personagem().add(personagem_b);
//		personagem_a.mostrar_personagem();
//		Menu menu = new Menu();
//		menu.menu();
		
		
//		Batalha batalha = new Batalha();
//		batalha.simulacao(personagem_a, personagem_b);
		System.out.println(personagem_a.escolha_personagem());
// 	
	}

}

/*
 		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		String nome;
		int idade;
		String sobrenome;
		for(int i = 0; i<3;i++) {
			System.out.println("digite seu nome");
			nome= sc.nextLine();
			System.out.println("Digite sua idade");
			idade = sc.nextInt();
			System.out.println("Digite seu sobrenome");
			sobrenome = sc.nextLine();
			
		}
 */
