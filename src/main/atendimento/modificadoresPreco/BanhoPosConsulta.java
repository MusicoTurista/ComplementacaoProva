package main.atendimento.modificadoresPreco;

import main.atendimento.ICalculaPreco;

public class BanhoPosConsulta extends Taxas {
    private static final float TAXA_BANHO = 50.0f;

    public BanhoPosConsulta(ICalculaPreco atendimento) {
        super(atendimento);
    }

    @Override
    public float getPreco() {
        return atendimento.getPreco() + TAXA_BANHO;
    }
}
