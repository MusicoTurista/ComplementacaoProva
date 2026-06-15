package main.atendimento.estado;

import main.atendimento.Atendimento;

public abstract class AtendimentoEstado {
    public abstract String getEstado();

    public boolean agendar(Atendimento atendimento)  { return false; }
    public boolean cancelar(Atendimento atendimento) { return false; }
    public boolean atender(Atendimento atendimento)  { return false; }
    public boolean finalizar(Atendimento atendimento){ return false; }
}
