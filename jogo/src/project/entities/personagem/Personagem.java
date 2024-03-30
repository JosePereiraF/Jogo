package project.entities.personagem;


public abstract class Personagem {
	private String nome;
	private float idade,altura;
	private int ph,ad,vida;
	private Skill skill1;
	private Skill skill2;
	private Skill skill3;
	
	public Personagem(String nome, float idade, float altura, int vida, int ad, int ph, Skill skill1, Skill skill2, Skill skill3) {
		this.setNome(nome);
		this.setAd(ad);
		this.setAltura(altura);
		this.setVida(vida);
		this.setIdade(idade);
		this.setPh(ph);
		this.setSkill1(skill1);
		this.setSkill2(skill2);
		this.setSkill3(skill3);
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
