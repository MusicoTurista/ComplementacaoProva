package main.atendimento.modificadoresPreco;

import main.atendimento.ICalculaPreco;

public class AnimalAdotado extends Taxas {
    private static final float DESCONTO = 0.9f;

    public AnimalAdotado(ICalculaPreco atendimento) {
        super(atendimento);
    }

    @Override
    public float getPreco() {
        return atendimento.getPreco() * DESCONTO;
    }
}
