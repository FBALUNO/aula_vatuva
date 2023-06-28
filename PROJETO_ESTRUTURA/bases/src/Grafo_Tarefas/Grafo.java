
package Grafo_Tarefas;

import java.util.ArrayList;

class Grafo<Tipo> {
    private ArrayList<Vertice<Tipo>> vertices;
    private ArrayList<Aresta<Tipo>> arestas;
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<Tipo>>();
        this.arestas = new ArrayList<Aresta<Tipo>>();
    }
    
    public void adicionarVertice(Tipo dado){
        Vertice<Tipo> novoVertice = new Vertice<Tipo>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta(Double peso, Tipo dadoInicio, Tipo dadoFim){
        Vertice<Tipo> inicio = this.getVertice(dadoInicio);
        Vertice<Tipo> fim = this.getVertice(dadoFim);
        Aresta<Tipo> aresta = new Aresta<Tipo>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    
    public Vertice<Tipo> getVertice(Tipo dado){
        Vertice<Tipo> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    public void buscarLargura(){
        ArrayList<Vertice<Tipo>> marcar = new ArrayList<Vertice<Tipo>>();
        ArrayList<Vertice<Tipo>> fila = new ArrayList<Vertice<Tipo>>();
        Vertice<Tipo> atual = this.vertices.get(0);
        marcar.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while(fila.size() > 0){
            Vertice<Tipo> visitado = fila.get(0);
            for(int i=0; i < visitado.getArestasSaida().size(); i++){
                Vertice<Tipo> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcar.contains(proximo)){ 
                    marcar.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }
    
    public void removerVerticesPrioritarios(){
        ArrayList<Vertice<Tipo>> verticesRemover = new ArrayList<Vertice<Tipo>>();
        for (Vertice<Tipo> vertice : vertices) {
            ArrayList<Aresta<Tipo>> arestasEntrada = vertice.getArestasEntrada();
            boolean prioritario = false;
            for (Aresta<Tipo> aresta : arestasEntrada) {
                if (aresta.isPrioritaria()) {
                    prioritario = true;
                    break;
                }
            }
            if (prioritario) {
                verticesRemover.add(vertice);
            }
        }
        vertices.removeAll(verticesRemover);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertice<Tipo> vertice : vertices) {
            sb.append(vertice.getDado()).append(":");
            ArrayList<Aresta<Tipo>> arestasSaida = vertice.getArestasSaida();
            for (Aresta<Tipo> aresta : arestasSaida) {
                sb.append(" ").append(aresta.getFim().getDado());
                if (aresta.isPrioritaria()) {
                    sb.append(" (Prioritário)");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}