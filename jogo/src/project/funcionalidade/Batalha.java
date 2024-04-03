package project.funcionalidade;

import java.util.Scanner;

import project.dto.SkillAtivaDTO;
import project.entities.personagem.Personagem;
///String nome, int dano,int cooldown,boolean utilizavel,boolean utilizada
public class Batalha {
	Scanner sc = new Scanner(System.in);
	int dano_a;
	int dano_b;
	int defesa_a;
	int defesa_b;
	Calculo calculo = new Calculo();
	
	public void simulacao(Personagem personagem_a, Personagem personagem_b) {
		// personagem 1 ataca depois o outro personagem defende
		//tenho que escolher a skill e depois enviar ela para verificar o cooldown assim vai funcionar
		
		int vida_a = personagem_a.getVida() ;
		int vida_b= personagem_b.getVida();
		SkillAtivaDTO skillEscolhida;
		SkillAtivaDTO skill;
		while(vida_a>0 && vida_b>0) {
			System.out.println("Ataque: "+ personagem_a.getNome());
			dano_a = calculo.calculadano(personagem_a.getAd(), personagem_a.getPh(), escolherskill(personagem_a).dano());
			defesa_b = calculo.defesa(personagem_b.getDefesa());
			System.out.println("Ataque: "+ personagem_b.getNome());
			dano_b = calculo.calculadano(personagem_b.getAd(), personagem_b.getPh(), escolherskill(personagem_b).dano());
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
	public SkillAtivaDTO escolherskill(Personagem personagem) {
		int escolha= 0;
		SkillAtivaDTO skill;
		SkillAtivaDTO skillRetorno;
		escolha = selecionaSkill(personagem);
		skill = preencheDTOSkill(escolha,personagem);
		skillRetorno = verifica_skill(skill,personagem);
		return skillRetorno;
	}
	
	public int selecionaSkill(Personagem personagem) {
		int escolha = 0;
		
		System.out.println("Escolha entre as suas 3 skills\n");
		System.out.println("Skill 1:"+personagem.getSkill1().getNome()+" efeito:"+personagem.getSkill1().getEfeito()+ " dano:"+ personagem.getSkill1().getDano());
		System.out.println("Skill 2:"+personagem.getSkill2().getNome()+" efeito:"+personagem.getSkill2().getEfeito()+  " dano:"+ personagem.getSkill2().getDano());
		System.out.println("Skill 3:"+personagem.getSkill3().getNome()+" efeito:"+personagem.getSkill3().getEfeito()+  " dano:"+ personagem.getSkill3().getDano());
		escolha = sc.nextInt();
		
		return escolha;
	}
	public SkillAtivaDTO verifica_skill(SkillAtivaDTO skill1, Personagem personagem) {
		//estou trabalhando com DTO porque criei 2 atributos transitorios que não existem em skill para economizar dados no banco
		// esses atributos são para verificar se a skill esta em cooldown ou se ela foi usada
			SkillAtivaDTO skill;
			skill = calculo.calcula_cooldown(skill1);
			return skill;
		
	}
	public SkillAtivaDTO preencheDTOSkill(int escolha,Personagem personagem) {
		if(escolha ==1) {  
			SkillAtivaDTO skill1 = new SkillAtivaDTO(personagem.getSkill1().getNome(),personagem.getSkill1().getDano(),
					personagem.getSkill1().getCooldown(),false,false);
			return skill1;
		}else if(escolha ==2) {  
			SkillAtivaDTO skill2 = new SkillAtivaDTO(personagem.getSkill2().getNome(),personagem.getSkill2().getDano(),
					personagem.getSkill2().getCooldown(),false,false);
			return skill2;
		}else{  
			SkillAtivaDTO skill3 = new SkillAtivaDTO(personagem.getSkill3().getNome(),personagem.getSkill3().getDano(),
					personagem.getSkill3().getCooldown(),false,false);
			return skill3;
		}
	
	}
	
}
