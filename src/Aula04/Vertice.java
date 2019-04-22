/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04;

import java.util.ArrayList;

/**
 *
 * @author Ronny
 */
public class Vertice {
    private String cor;
    private String palavra;
    private int distancia;
    private int tempoDescoberta;
    private int tempoTermino;
    private int componenteConexo;
    private int low;
    private Vertice predecessor;
    private Vertice ponte;
    private ArrayList<Vertice> adjacencia;    
    
    public Vertice (){
    }
    
    public Vertice(String palavra){
        super();
        this.palavra = palavra;
    }

    public Vertice getPonte() {
        return ponte;
    }

    public void setPonte(Vertice ponte) {
        this.ponte = ponte;
    }
    
    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }    
    
    public int getComponenteConexo() {
        return componenteConexo;
    }

    public void setComponenteConexo(int componenteConexo) {
        this.componenteConexo = componenteConexo;
    }
    
    public int getTempoDescoberta() {
        return tempoDescoberta;
    }

    public void setTempoDescoberta(int tempoDescoberta) {
        this.tempoDescoberta = tempoDescoberta;
    }

    public int getTempoTermino() {
        return tempoTermino;
    }

    public void setTempoTermino(int tempoTermino) {
        this.tempoTermino = tempoTermino;
    }
    
    public Vertice getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertice predecessor) {
        this.predecessor = predecessor;
    }
        
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public ArrayList<Vertice> getAdjacencia() {
        return adjacencia;
    }

    public void setAdjacencia(ArrayList<Vertice> adjacencia) {
        this.adjacencia = adjacencia;
    }   
}
