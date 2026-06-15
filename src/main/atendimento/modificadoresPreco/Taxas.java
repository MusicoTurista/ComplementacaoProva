package main.atendimento.modificadoresPreco;

import main.atendimento.ICalculaPreco;

public abstract class Taxas implements ICalculaPreco {
    protected final ICalculaPreco atendimento;

    public Taxas(ICalculaPreco atendimento) {
        this.atendimento = atendimento;
    }
}
