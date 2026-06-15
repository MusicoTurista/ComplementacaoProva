package main;

import main.atendimento.Atendimento;

import java.util.Observable;
import java.util.Observer;

public class Recepcao implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Recepcao(String nome){
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
