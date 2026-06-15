package main.atendimento.estado;

public class EstadoFinalizado extends AtendimentoEstado {
    private EstadoFinalizado() {}
    private static final EstadoFinalizado instance = new EstadoFinalizado();
    public static EstadoFinalizado getInstance() { return instance; }

    @Override public String getEstado() { return "FINALIZADO"; }
}
