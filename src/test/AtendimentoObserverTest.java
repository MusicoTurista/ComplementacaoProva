package test;

import main.Recepcao;
import main.Tutor;
import main.Veterinario;
import main.atendimento.AtendimentoClinica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtendimentoObserverTest {
    @Test
    void tutorNotificadoAoIniciar() {
        Tutor tutor = new Tutor("Carlos");
        AtendimentoClinica atendimento = new AtendimentoClinica();
        tutor.observar(atendimento);

        atendimento.atender();

        assertNotNull(tutor.getUltimaNotificacao());

        assertTrue(tutor.getUltimaNotificacao().contains("EM_ATENDIMENTO"));
    }

    @Test
    void veterinarioNotificadoAoCancelar() {
        Veterinario vet = new Veterinario("Dra. Ana");
        AtendimentoClinica atendimento = new AtendimentoClinica();

        vet.observar(atendimento);

        atendimento.cancelar();

        assertNotNull(vet.getUltimaNotificacao());
        assertTrue(vet.getUltimaNotificacao().contains("CANCELADO"));
    }

    @Test
    void recepcaoNotificadaAoFinalizar() {
        Recepcao recepcao = new Recepcao("Recepção");
        AtendimentoClinica atendimento = new AtendimentoClinica();

        recepcao.observar(atendimento);

        atendimento.atender();

        atendimento.finalizar();

        assertNotNull(recepcao.getUltimaNotificacao());
        assertTrue(recepcao.getUltimaNotificacao().contains("FINALIZADO"));
    }

}
