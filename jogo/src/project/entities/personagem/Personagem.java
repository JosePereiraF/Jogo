package project.entities.personagem;

import java.util.ArrayList;

import project.enums.Classe;

public class Personagem {
	private String nome;
	private float idade,altura;
	private int ph;
	private int ad;
	private int vida;
	private int defesa;
	private Classe classe;
	private Skill skill1;
	private Skill skill2;
	private Skill skill3;
	
	private static ArrayList<Personagem> lista_personagem = new ArrayList<>();
	
	public static ArrayList<Personagem> getLista_personagem(){
		return lista_personagem;
	}
	
	public static void setLista_personagem(ArrayList<Personagem> lista_personagem) {
        Personagem.lista_personagem = lista_personagem;
    }


	public Personagem(String nome, float idade, int ph, int ad, int vida, int defesa, Classe classe,
			Skill skill1, Skill skill2, Skill skill3) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.ph = ph;
		this.ad = ad;
		this.vida = vida;
		this.defesa = defesa;
		this.classe = classe;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getIdade() {
		return idade;
	}

	public void setIdade(float idade) {
		this.idade = idade;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public int getAd() {
		return ad;
	}

	public void setAd(int ad) {
		this.ad = ad;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Skill getSkill1() {
		return skill1;
	}

	public void setSkill1(Skill skill1) {
		this.skill1 = skill1;
	}

	public Skill getSkill2() {
		return skill2;
	}

	public void setSkill2(Skill skill2) {
		this.skill2 = skill2;
	}

	public Skill getSkill3() {
		return skill3;
	}

	public void setSkill3(Skill skill3) {
		this.skill3 = skill3;
	}
	
	
	
	
}
