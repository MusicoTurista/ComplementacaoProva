package main.atendimento;

import main.Tutor;

public class Animal {
    private String nome;

    public Animal(String nome, Tutor tutor) {
        this.nome = nome;
        tutor.addAnimal(this);
    }

    public String getNome() { return nome; }
}
