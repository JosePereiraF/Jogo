package project.funcionalidade;

import java.util.Scanner;

import project.dto.SkillAtivaDTO;
import project.entities.personagem.Personagem;

public class Batalha {
	Scanner sc = new Scanner(System.in);
	Scanner scint = new Scanner(System.in);
	int dano_a;
	int dano_b;
	int defesa_a;
	int defesa_b;
	Calculo calculo = new Calculo();
	
	public void simulacao(Personagem personagem_a, Personagem personagem_b) {
		// criar um metodo que só verifique o cooldown da skill 
		// quando a batalha começar eu diminuo o cooldown de todas as skills na mão e durante o codigo eu só tenho o poder de verificar
		//qunado o cara digitar uma skill eu posso tentar usar o do while para pegar uma skill e fazer um teste com ela caso ela estiver
		// em cooldown eu mostro um aviso caso nao estiver eu nn mostro o aviso
				int vida_a = personagem_a.getVida() ;
				int vida_b= personagem_b.getVida();
				int escolha4= 0;
				int cooldown;
				SkillAtivaDTO skill1 = preencheDTOSkill(1,personagem_a);
				SkillAtivaDTO skill2 = preencheDTOSkill(2,personagem_a);
				SkillAtivaDTO skill3 = preencheDTOSkill(3,personagem_a);
				SkillAtivaDTO skill4 = preencheDTOSkill(1,personagem_b);
				SkillAtivaDTO skill5 = preencheDTOSkill(2,personagem_b);
				SkillAtivaDTO skill6 = preencheDTOSkill(3,personagem_b);
				while(vida_a >0 && vida_b>0) {
					skill1 = calculo.calcula_cooldown(skill1);
					skill2 = calculo.calcula_cooldown(skill2);
					skill3 = calculo.calcula_cooldown(skill3);
					skill4 = calculo.calcula_cooldown(skill4);
					skill5 = calculo.calcula_cooldown(skill5);
					skill6 = calculo.calcula_cooldown(skill6);
					
					do {
						System.out.println("Ataque: "+ personagem_a.getNome());
						escolha4 =escolher(personagem_a);
						if(escolha4 == 1 ) {
							System.out.println(calculo.verifica_cooldown(skill1));
							cooldown= skill1.cooldown();
							if(skill1.utilizavel()== true) {

								skill1 = calculo.reseta_cooldown(skill1, personagem_a.getSkill1().getCooldown(),true);
								
								
								}
							}else if(escolha4==2 ) {
								System.out.println(calculo.verifica_cooldown(skill2));
								cooldown= skill2.cooldown();
								if(skill2.utilizavel()== true) {

									skill2 = calculo.reseta_cooldown(skill2,  personagem_a.getSkill2().getCooldown(),true);
									
									
									}
							}else {
								System.out.println(calculo.verifica_cooldown(skill3));
								cooldown= skill3.cooldown();
								if(skill3.utilizavel()== true) {

									skill3 = calculo.reseta_cooldown(skill3,  personagem_a.getSkill3().getCooldown(),true);
									
									
									}
							}
					}while(cooldown >0);
					dano_a = calculo.calculadano(personagem_a.getAd(), personagem_a.getPh(), escolherskill(personagem_a,escolha4).dano());
					defesa_b = calculo.defesa(personagem_b.getDefesa());
					
					do {
						System.out.println("Ataque: "+ personagem_b.getNome());
						escolha4 =escolher(personagem_b);
						if(escolha4==1 ) {
							System.out.println(calculo.verifica_cooldown(skill4));
							cooldown= skill4.cooldown();
							if(skill4.utilizavel()== true) {

								skill4 = calculo.reseta_cooldown(skill4,  personagem_b.getSkill1().getCooldown(),true);
								
								
								}
							
							}else if(escolha4==2 ) {
								System.out.println(calculo.verifica_cooldown(skill5));
								cooldown= skill5.cooldown();
								if(skill5.utilizavel()== true) {

									skill5 = calculo.reseta_cooldown(skill5, personagem_b.getSkill2().getCooldown(),true);
									
									
									}
							}else {
								System.out.println(calculo.verifica_cooldown(skill6));
								cooldown= skill6.cooldown();
								if(skill6.utilizavel()== true) {

									skill6 = calculo.reseta_cooldown(skill6, personagem_b.getSkill1().getCooldown(),true);
									
									
									}
							}
					}while(cooldown >0);
					
					dano_b = calculo.calculadano(personagem_b.getAd(), personagem_b.getPh(), escolherskill(personagem_b,escolha4).dano());
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
	public SkillAtivaDTO escolherskill(Personagem personagem, int escolha) {
		//int escolha= 0;
		SkillAtivaDTO skill;
		SkillAtivaDTO skillRetorno;
		//escolha = selecionaSkill(personagem);
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
	
	
	public int escolher(Personagem personagem) {
		int escolha;
		String cooldown;
		
		System.out.println("Escolha entre as suas 3 skills\n");
		System.out.println("Skill 1:"+personagem.getSkill1().getNome()+" efeito:"+personagem.getSkill1().getEfeito()+ " dano:"+ personagem.getSkill1().getDano());
		System.out.println("Skill 2:"+personagem.getSkill2().getNome()+" efeito:"+personagem.getSkill2().getEfeito()+  " dano:"+ personagem.getSkill2().getDano());
		System.out.println("Skill 3:"+personagem.getSkill3().getNome()+" efeito:"+personagem.getSkill3().getEfeito()+  " dano:"+ personagem.getSkill3().getDano());
		escolha = sc.nextInt();
		SkillAtivaDTO skill = preencheDTOSkill(escolha, personagem);
		cooldown = calculo.verifica_cooldown(skill);
		return escolha;
	}
	
	
	
}



