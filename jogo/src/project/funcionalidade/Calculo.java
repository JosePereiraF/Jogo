package project.funcionalidade;

import java.util.Random;

import project.dto.SkillAtivaDTO;

public class Calculo {

	public int dado() {
		Random random = new Random();
		int numero = random.nextInt(11)+1;
		return numero;
	}
	
	public int calculadano(int ad,int ap,int skill) {
		int dado = dado();
		int dano = dado+ad+ap+skill;
		return dano;
	}
	public int defesa(int numero) {
		int defesa = numero+ dado();
		return defesa;
	}
	public int calculavida(int vida,int dano,int defesa) {
		int vida_restante =0;
		if(dano<defesa) return vida;
		else {
			return vida_restante = (vida-(dano-defesa));
		}
		
	}
	
	public SkillAtivaDTO calcula_cooldown(SkillAtivaDTO skill) {//2
		boolean ativada;
		int cooldown;
		cooldown = skill.cooldown() - 1;//1
		
		if(cooldown == 0) {
			SkillAtivaDTO skill1 = new SkillAtivaDTO(skill.nome(),skill.dano(),cooldown, true,false);
			// true ela é utilizavel e  false nao foi utilizada ainda
			return skill1;
		}else {
			SkillAtivaDTO skill1 = new SkillAtivaDTO(skill.nome(),skill.dano(),cooldown, false,skill.utilizada());
			return skill1;
		}
	}
	
	public SkillAtivaDTO reseta_cooldown(SkillAtivaDTO skill, int cooldown,boolean utilizada) {
		if(skill.cooldown() == 0 && utilizada == true) {
			SkillAtivaDTO skill1 = new SkillAtivaDTO(skill.nome(),skill.dano(),cooldown, false,true);
			//quando ele utilizar a skill tenho que trocar os dois para false para dizer que a skill não esta utilizavel e true porque ela ja foi utilizada
			// posso usar isso para devolver uma mensagem que a skill foi utilizada e o cooldown dela 
			return skill1;
		}
		else {
			SkillAtivaDTO skill1 = new SkillAtivaDTO(skill.nome(),skill.dano(),skill.cooldown(), true,false);
			return skill1;
			
		}
	}
	public String verifica_cooldown(SkillAtivaDTO skill) {
		if(skill.cooldown()>0){ 
				String cooldown = ("opção invalida! Cooldown: "+ skill.cooldown());
				return cooldown;
				}else {
					return "habilitada";
				}
	}
	
	
}
