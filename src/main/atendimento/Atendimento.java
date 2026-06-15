package main.atendimento;

import main.atendimento.estado.AtendimentoEstado;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class Atendimento extends Observable implements ICalculaPreco  {
    protected AtendimentoEstado estado;

    private List<ServicoVeterinario> servicos = new ArrayList<>();

    private Animal animal;

    public float getPreco(){
        float precoFinal = 0.0f;
        for (ServicoVeterinario servico : servicos) {
            precoFinal += servico.getPreco();
        }
        return precoFinal;
    }

    public void addServico(ServicoVeterinario servico){
        servicos.add(servico);
    }

    public void setEstado(AtendimentoEstado estado){
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getEstado()  { return estado.getEstado(); }

    public boolean agendar(){
        return estado.agendar(this);
    }

    public boolean cancelar(){
        return estado.cancelar(this);
    }

    public boolean atender(){
        return estado.atender(this);
    }

    public boolean finalizar(){
        return estado.finalizar(this);
    }

    public String toString() {
        return "Atendimento" + estado.getEstado();
    }
}
