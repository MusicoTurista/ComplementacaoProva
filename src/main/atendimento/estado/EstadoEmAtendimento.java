package main.atendimento.estado;

import main.atendimento.Atendimento;

public class EstadoEmAtendimento extends AtendimentoEstado {
    private EstadoEmAtendimento() {}
    private static final EstadoEmAtendimento instance = new EstadoEmAtendimento();
    public static EstadoEmAtendimento getInstance() { return instance; }

    @Override public String getEstado() { return "EM_ATENDIMENTO"; }

    @Override
    public boolean finalizar(Atendimento atendimento) {
        atendimento.setEstado(EstadoFinalizado.getInstance());
        return true;
    }
}
