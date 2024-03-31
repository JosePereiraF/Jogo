package project.dto;

import project.enums.Classe;

public record PersonagemDTO(String nome, int idade,double altura,int ph,int ad,int vida, int defesa,Classe classe) {

}

