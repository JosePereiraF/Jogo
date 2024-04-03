package project.entities.personagem;

import java.util.ArrayList;
import java.util.Scanner;

import project.dto.PersonagemDTO;
import project.enums.Classe;

public class Personagem {
	Scanner sc = new Scanner(System.in);
	private String nome;
	private int idade;
	private double altura;
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


	public Personagem(String nome, int idade, double altura,int ph, int ad, int vida, int defesa, Classe classe,
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
	public Personagem(PersonagemDTO personagemDTO,Skill skill1, Skill skill2, Skill skill3) {
		this.nome = personagemDTO.nome();
		this.idade = personagemDTO.idade();
		this.altura = personagemDTO.altura();
		this.ph = personagemDTO.ph();
		this.ad = personagemDTO.ad();
		this.vida = personagemDTO.vida();
		this.defesa = personagemDTO.defesa();
		this.classe = personagemDTO.classe();
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		
	}
	public Personagem() {}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
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
	public void mostrar_personagem() {
		for(int i = 0; i<lista_personagem.size();i++) {
			System.out.println(lista_personagem.get(i).getNome());
		}
	}
	public Personagem escolha_personagem() {
		String personagem;
		mostrar_personagem();
		System.out.println("Digite o nome do seu personagem:");
		personagem = sc.nextLine();
		for(int i = 0; i<lista_personagem.size();i++) {
			if(personagem.equalsIgnoreCase(lista_personagem.get(i).getNome())) {
				Personagem personagem_a = lista_personagem.get(i);
				return personagem_a;// isso não retorna o personagem talvez criar um construtor que receba o index como parametro
				
			}
		}
		return null;
	}
	
}
