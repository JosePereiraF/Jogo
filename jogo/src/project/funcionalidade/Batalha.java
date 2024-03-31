package project.funcionalidade;

import java.util.Scanner;

import project.entities.personagem.Personagem;

public class Batalha {
	Scanner sc = new Scanner(System.in);
	int dano_a;
	int dano_b;
	int defesa_a;
	int defesa_b;
	
	
	public void simulacao(Personagem personagem_a, Personagem personagem_b) {
		// personagem 1 ataca e persoag
		Calculo calculo = new Calculo();
		int vida_a = personagem_a.getVida() ;
		int vida_b= personagem_b.getVida();
		while(vida_a>0 && vida_b>0) {
			System.out.println("Ataque: "+ personagem_a.getNome());
			dano_a = calculo.calculadano(personagem_a.getAd(), personagem_a.getPh(), escolherskill(personagem_a));
			defesa_b = calculo.defesa(personagem_b.getDefesa());
			System.out.println("Ataque: "+ personagem_b.getNome());
			dano_b = calculo.calculadano(personagem_b.getAd(), personagem_b.getPh(), escolherskill(personagem_b));
			defesa_a = calculo.defesa(personagem_a.getDefesa());
			vida_a = calculo.calculavida(vida_a, dano_b,defesa_a);
			if(vida_a<=0) break;
			vida_b = calculo.calculavida(vida_b, dano_a, defesa_b);
			if(vida_b<=0) break;
			System.out.println("Personagem:"+ personagem_a.getNome()+ " vida restante: "+vida_a);
			System.out.println("Personagem:"+ personagem_b.getNome()+ " vida restante: "+vida_b);
		}
		System.out.println("Personagem:"+ personagem_a.getNome()+ " vida restante: "+vida_a);
		System.out.println("Personagem:"+ personagem_b.getNome()+ " vida restante: "+vida_b);
		if(vida_a<=0) System.out.println("Parabens "+personagem_b.getNome()+" você venceu.");
		else System.out.println("Parabens "+personagem_a.getNome()+ " você venceu.");
	}
	
	public int escolherskill(Personagem personagem) {
		int escolha = 1;
		System.out.println("Escolha entre as suas 3 skills\n");
		System.out.println("Skill 1:"+personagem.getSkill1().getNome()+" efeito:"+personagem.getSkill1().getEfeito()+ " dano:"+ personagem.getSkill1().getDano());
		System.out.println("Skill 2:"+personagem.getSkill2().getNome()+" efeito:"+personagem.getSkill2().getEfeito()+  " dano:"+ personagem.getSkill2().getDano());
		System.out.println("Skill 3:"+personagem.getSkill3().getNome()+" efeito:"+personagem.getSkill3().getEfeito()+  " dano:"+ personagem.getSkill3().getDano());
		escolha = sc.nextInt();
		if(escolha == 1)return personagem.getSkill1().getDano();
		else if(escolha == 2)return personagem.getSkill2().getDano();
		else return personagem.getSkill3().getDano();
	}
	
	
}
