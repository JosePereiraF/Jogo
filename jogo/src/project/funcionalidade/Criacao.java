package project.funcionalidade;

import java.util.Scanner;

import project.dto.PersonagemDTO;
import project.entities.personagem.Personagem;
import project.entities.personagem.Skill;
import project.enums.Classe;

public class Criacao {
	Scanner sc = new Scanner(System.in);
	Scanner scInt = new Scanner(System.in);// comentar essa parte com o professor que eu tinha falado sobre instaciar 3 scan
	public void personagem() {
		Skill skill1 = criar_skill();
		Skill skill2 = criar_skill();
		Skill skill3 = criar_skill();
		PersonagemDTO personagemDTO = criar_personagem();
		
		Personagem personagem_a = new Personagem(personagemDTO, skill1, skill2,skill3);
		Personagem.getLista_personagem().add(personagem_a);
	}
	
	public PersonagemDTO criar_personagem() {
		String nome = "";
		int idade = 0;
		double altura = 0.00;
		int ph = 0;
		int ad = 0;
		int vida = 0;
		int defesa = 0;
		Classe classe = null;
		String opcao = "seu nome: ";
		String [] digitacao = {"seu nome: ", "sua idade: ", "sua altura: ","seu poder de abilidade: ",
				"seu dano de ataque: ", "sua vida: ","sua classe: "};
		for(int i = 0 ;i <digitacao.length;i++) {
			opcao = digitacao[i];
			switch(opcao) {
			case "seu nome: ":
				System.out.println("Digite "+opcao);
				nome = sc.nextLine();
				break;
			case "sua idade: ":
				System.out.println("Digite "+opcao);
				idade = scInt.nextInt();
				break;
			case "sua altura: ":
				System.out.println("Digite "+opcao);
				altura = scInt.nextDouble();
				break;
			case "seu poder de abilidade: ":
				System.out.println("Digite "+opcao);
				ph = scInt.nextInt();
				break;
			case "seu dano de ataque: ":
				System.out.println("Digite "+opcao);
				ad = scInt.nextInt();
				break;
			case "sua vida: ":
				System.out.println("Digite "+opcao);
				vida = scInt.nextInt();
				break;
			case "sua classe: ":
				System.out.println("Digite "+opcao);
				classe = classe(sc.nextLine());
				break;
			default:
				System.out.println("opção invalida");
				break;
			}
		}
		PersonagemDTO personagemDTO = new PersonagemDTO(nome,idade,altura,ph,ad,vida,defesa,classe);
		return personagemDTO;
	}
	
	public Skill criar_skill() {
		String nome;
		int dano;
		String efeito;
		System.out.println("Digite o nome da sua skill");
		nome = sc.nextLine();
		System.out.println("Digite o dano da skill");
		dano = scInt.nextInt();// se eu tentar rodar esse codigo com um scan ele entrega um erro na hora de preencher as info
		System.out.println("Digite o efeito");
		efeito = sc.nextLine();
		
		Skill skill = new Skill(nome,dano,efeito);
		return skill;
	}
	public Classe classe(String classe) {
		if(classe.equalsIgnoreCase("guerreiro")) return Classe.GUERREIRO;
		else if(classe.equalsIgnoreCase("mago")) return Classe.MAGO;
		else if(classe.equalsIgnoreCase("atirador")) return Classe.ATIRADOR;
		else return Classe.TANK;
	}
}
