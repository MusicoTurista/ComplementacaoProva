package test;

import main.atendimento.AtendimentoClinica;
import main.atendimento.AtendimentoDomiciliar;
import main.atendimento.ICalculaPreco;
import main.atendimento.ServicoVeterinario;
import main.atendimento.modificadoresPreco.AnimalAdotado;
import main.atendimento.modificadoresPreco.BanhoPosConsulta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtendimentoDecoratorTest {
    @Test
    void precoBaseClinica() {
        AtendimentoClinica atendimento = new AtendimentoClinica();
        atendimento.addServico(new ServicoVeterinario("Consulta", 200.0f));

        assertEquals(200.0f, atendimento.getPreco(), 0.01f);
    }

    @Test
    void precoDomiciliar() {
        AtendimentoDomiciliar atendimento = new AtendimentoDomiciliar();
        atendimento.addServico(new ServicoVeterinario("Consulta", 200.0f));

        assertEquals(220.0f, atendimento.getPreco(), 0.01f);
    }

    @Test
    void precoComBanho() {
        AtendimentoClinica base = new AtendimentoClinica();
        base.addServico(new ServicoVeterinario("Consulta", 200.0f));

        ICalculaPreco comBanho = new BanhoPosConsulta(base);

        assertEquals(250.0f, comBanho.getPreco(), 0.01f);
    }

    @Test
    void precoComDescontoAdotado() {
        AtendimentoClinica base = new AtendimentoClinica();
        base.addServico(new ServicoVeterinario("Consulta", 200.0f));

        ICalculaPreco comDesconto = new AnimalAdotado(base);

        assertEquals(180.0f, comDesconto.getPreco(), 0.01f);
    }

    @Test
    void precoComBanhoEDesconto() {
        AtendimentoClinica base = new AtendimentoClinica();
        base.addServico(new ServicoVeterinario("Consulta", 200.0f));

        ICalculaPreco comBanho = new BanhoPosConsulta(base);
        ICalculaPreco comDesconto = new AnimalAdotado(comBanho);

        assertEquals(225.0f, comDesconto.getPreco(), 0.01f);
    }

    @Test
    void precoDomiciliarComTodasAsRegras() {
        AtendimentoDomiciliar base = new AtendimentoDomiciliar();
        base.addServico(new ServicoVeterinario("Consulta", 200.0f));

        ICalculaPreco comBanho = new BanhoPosConsulta(base);
        ICalculaPreco comDesconto = new AnimalAdotado(comBanho);

        assertEquals(243.0f, comDesconto.getPreco(), 0.01f);
    }

    @Test
    void multiplosServicos() {
        AtendimentoClinica base = new AtendimentoClinica();
        base.addServico(new ServicoVeterinario("Consulta", 150.0f));
        base.addServico(new ServicoVeterinario("Vacinação", 80.0f));
        base.addServico(new ServicoVeterinario("Exame", 70.0f));

        ICalculaPreco comDesconto = new AnimalAdotado(base);

        assertEquals(300.0f, base.getPreco(), 0.01f);
        assertEquals(270.0f, comDesconto.getPreco(), 0.01f);
    }
}
