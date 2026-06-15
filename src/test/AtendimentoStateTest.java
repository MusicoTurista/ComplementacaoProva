package test;

import main.Recepcao;
import main.Tutor;
import main.atendimento.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtendimentoStateTest {
    @Test
    void agendadoDeveMudarParaEmAtendimento() {

        AtendimentoClinica atendimento = new AtendimentoClinica();

        boolean resultado = atendimento.atender();

        assertTrue(resultado);
        assertEquals("EM_ATENDIMENTO", atendimento.getEstado());
    }

    @Test
    void agendadoDeveMudarParaCancelado() {
        AtendimentoClinica atendimento = new AtendimentoClinica();

        boolean resultado = atendimento.cancelar();

        assertTrue(resultado);
        assertEquals("CANCELADO", atendimento.getEstado());
    }

    @Test
    void emAtendimentoDeveMudarParaFinalizado() {
        AtendimentoClinica atendimento = new AtendimentoClinica();
        atendimento.atender();

        boolean resultado = atendimento.finalizar();

        assertTrue(resultado);
        assertEquals("FINALIZADO", atendimento.getEstado());
    }

    @Test
    void devePercorrerFluxoCompleto() {
        AtendimentoClinica atendimento = new AtendimentoClinica();
        assertEquals("AGENDADO", atendimento.getEstado());

        atendimento.atender();
        assertEquals("EM_ATENDIMENTO", atendimento.getEstado());

        atendimento.finalizar();
        assertEquals("FINALIZADO", atendimento.getEstado());
    }

    @Test
    void finalizadoNaoDeveMudarParaCancelar() {
        AtendimentoClinica atendimento = new AtendimentoClinica();
        atendimento.atender();
        atendimento.finalizar();

        boolean resultado = atendimento.cancelar();

        assertFalse(resultado);
        assertEquals("FINALIZADO", atendimento.getEstado());
    }

    @Test
    void canceladoNaoDeveMudarParaAtender() {
        AtendimentoClinica atendimento = new AtendimentoClinica();
        atendimento.cancelar();

        boolean resultado = atendimento.atender();

        assertFalse(resultado);
        assertEquals("CANCELADO", atendimento.getEstado());
    }

    @Test
    void canceladoNaoDeveMudarParaFinalizar() {
        AtendimentoClinica atendimento = new AtendimentoClinica();
        atendimento.cancelar();

        boolean resultado = atendimento.finalizar();

        assertFalse(resultado);
        assertEquals("CANCELADO", atendimento.getEstado());
    }

    @Test
    void agendadoNaoDeveMudarParaFinalizar() {
        AtendimentoClinica atendimento = new AtendimentoClinica();

        boolean resultado = atendimento.finalizar();

        assertFalse(resultado);
        assertEquals("AGENDADO", atendimento.getEstado());
    }

    @Test
    void emAtendimentoNaoDeveMudarParaCancelar() {
        AtendimentoClinica atendimento = new AtendimentoClinica();
        atendimento.atender();

        boolean resultado = atendimento.cancelar();

        assertFalse(resultado);
        assertEquals("EM_ATENDIMENTO", atendimento.getEstado());
    }
}
