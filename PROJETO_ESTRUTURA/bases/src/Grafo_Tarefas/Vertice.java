package Grafo_Tarefas;

import java.util.ArrayList;

class Vertice<Tipo> {
    private Tipo dado;
    private ArrayList<Aresta<Tipo>> arestasEntrada;
    private ArrayList<Aresta<Tipo>> arestasSaida;
    
    public Vertice(Tipo valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<Tipo>>();
        this.arestasSaida = new ArrayList<Aresta<Tipo>>();
    }

    public Tipo getDado() {
        return dado;
    }

    public void setDado(Tipo dado) {
        this.dado = dado;
    }
    
    public void adicionarArestaEntrada(Aresta<Tipo> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<Tipo> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<Tipo>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<Tipo>> getArestasSaida() {
        return arestasSaida;
    }
    
    
}