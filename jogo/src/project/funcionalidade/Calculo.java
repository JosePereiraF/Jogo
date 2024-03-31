package project.funcionalidade;

import java.util.Random;

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
	
}
