package main.atendimento.estado;

import main.atendimento.Atendimento;

public class EstadoAgendado extends AtendimentoEstado {
    private EstadoAgendado() {}
    private static final EstadoAgendado instance = new EstadoAgendado();
    public static EstadoAgendado getInstance() { return instance; }

    @Override public String getEstado() { return "AGENDADO"; }

    @Override
    public boolean cancelar(Atendimento atendimento) {
        atendimento.setEstado(EstadoCancelado.getInstance());
        return true;
    }

    @Override
    public boolean atender(Atendimento atendimento) {
        atendimento.setEstado(EstadoEmAtendimento.getInstance());
        return true;
    }
}
