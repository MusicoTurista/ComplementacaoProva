package main.atendimento;

public class AtendimentoFactory {
    public static Atendimento obterServico(String tipo) {
        Object objeto = null;
        try {
            Class<?> classe = Class.forName("main.atendimento.Atendimento" + tipo);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Tipo inexistente: " + tipo, ex);
        }
        if (!(objeto instanceof Atendimento)) {
            throw new IllegalArgumentException("Tipo inválido: " + tipo);
        }
        return (Atendimento) objeto;
    }
}
