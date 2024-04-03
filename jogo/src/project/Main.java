package project;


import java.util.Scanner;

import project.dto.SkillAtivaDTO;
import project.entities.personagem.Personagem;
import project.entities.personagem.Skill;
import project.enums.Classe;
import project.funcionalidade.Batalha;
import project.funcionalidade.Calculo;
import project.funcionalidade.Criacao;
import project.funcionalidade.Menu;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 1- criar um metodo de sorteador de numero para funcionar como dado (check)
		 * 2- criar um metodo que calcule o dano dos champ que receba a skill + o valor do dado (check)
		 * 3- criar um metodo para calcular a vida dos personagens em batalha (check)
		 * 4- criar um metodo para simular uma batalha para testar ofuncionamento dos metodos (check)
		 * 5- criar um metodo para add personagens(check)
		 * 6- add um metodo para mostrar os personagens (check)
		 * 7- criar um metodo para criar os personagens antes da luta comecar (check)
		 * 8- criar um metodo para aparecer os personagens disponiveis para escolha (check)
		 * 9- colocar um tempo de recarga nas skills (check)
		 * 10- adaptar para a pessoa poder escolher um time ao inves de jogar com um personagem só
		 */
		Skill skill1 = new Skill("furacão", 10, "stun",1);
		Skill skill2 = new Skill("furacão2", 15, "stun",2);
		Skill skill3 = new Skill("furacão3", 20, "stun",3);
		Personagem personagem_a = new Personagem("yasuo", 10, 1.18,10, 30, 100, 30, Classe.GUERREIRO, skill1, skill2,
				skill3);
		Personagem.getLista_personagem().add(personagem_a);

		Personagem personagem_b = new Personagem("yone", 10, 2.00,10, 30, 100, 30, Classe.GUERREIRO, skill1, skill2, skill3);
		Personagem.getLista_personagem().add(personagem_b);
//		personagem_a.mostrar_personagem();
//		Menu menu = new Menu();
//		menu.menu();
		
		
		Batalha batalha = new Batalha();
		Calculo calculo = new Calculo();
		Personagem p = new Personagem();
		SkillAtivaDTO skill= new SkillAtivaDTO(skill2.getNome(),skill2.getDano(),skill2.getCooldown(),false, false);
		Calculo calcula = new Calculo();
		
//		int escolha=batalha.escolherskill(personagem_b);
//		for(nt i = 0 ; i<2 ;i++) {
//			skill = batalha.verifica_skill(skill, personagem_b);
//			if(skill.cooldown() !=0) System.out.println("opção invalida tempo de recarga: "+skill.cooldown());
//			else System.out.println(skill); 
//		}
		batalha.simulacao(personagem_a, personagem_b);
			
	}

}

/*
 					System.out.println("Ataque: "+ personagem_a.getNome());
					escolha4 =escilher(personagem_a);
					if(escolha4==1 ) {
						System.out.println(calculo.verifica_cooldown(skill1));
						
						}else if(escolha4==2 ) {
							System.out.println(calculo.verifica_cooldown(skill2));
						
						}else {
							System.out.println(calculo.verifica_cooldown(skill3));
						}
					dano_a = calculo.calculadano(personagem_a.getAd(), personagem_a.getPh(), escolherskill(personagem_a,escolha4).dano());
 */
