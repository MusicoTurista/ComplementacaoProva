package main.atendimento;

import main.atendimento.estado.EstadoAgendado;

import java.util.Observer;

public class AtendimentoClinica extends Atendimento {
    public AtendimentoClinica() {
        this.estado = EstadoAgendado.getInstance();
    }
}
