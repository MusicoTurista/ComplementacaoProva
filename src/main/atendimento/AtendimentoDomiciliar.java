package main.atendimento;

import main.atendimento.estado.EstadoAgendado;

public class AtendimentoDomiciliar extends Atendimento {
    private static final float TAXA_DOMICILIAR = 20.0f;

    public AtendimentoDomiciliar() {
        this.estado = EstadoAgendado.getInstance();
    }

    @Override
    public float getPreco() {
        return super.getPreco() + TAXA_DOMICILIAR;
    }
}
