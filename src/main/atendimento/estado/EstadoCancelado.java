package main.atendimento.estado;

public class EstadoCancelado extends AtendimentoEstado {
    private EstadoCancelado() {}
    private static final EstadoCancelado instance = new EstadoCancelado();
    public static EstadoCancelado getInstance() { return instance; }

    @Override public String getEstado() { return "CANCELADO"; }
}
