package main.atendimento;

public class ServicoVeterinario {
    private String nome;
    private float valor;

    public ServicoVeterinario(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() { return nome; }

    public float getPreco() { return this.valor; }
}
