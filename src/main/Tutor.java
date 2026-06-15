package main;

import main.atendimento.Animal;
import main.atendimento.Atendimento;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Tutor implements Observer {
    private String nome;
    private String ultimaNotificacao;
    private List<Animal> animais;

    public Tutor(String nome){
        this.nome = nome;
    }

    public void observar(Atendimento atendimento) {
        atendimento.addObserver(this);
    }

    public void addAnimal(Animal animal){
        animais.add(animal);
    }

    @Override
    public void update(Observable atendimento, Object arg) {
        this.ultimaNotificacao = nome + atendimento.toString();
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}
