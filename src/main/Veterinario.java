package main;

import main.atendimento.Atendimento;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public class Veterinario implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Veterinario(String nome){
        this.nome = nome;
    }

    public void observar(Atendimento atendimento) {
        atendimento.addObserver(this);
    }

    @Override
    public void update(Observable atendimento, Object arg) {
        this.ultimaNotificacao = nome + atendimento.toString();
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}
