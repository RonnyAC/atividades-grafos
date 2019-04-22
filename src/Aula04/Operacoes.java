/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ronny
 */
public class Operacoes {

    private final Scanner ler = new Scanner(System.in);
    Grafo g = new Grafo();

    public void operacoes(String nomeArquivo) {
        int opcao = 0;
        while (opcao != 8) {
            System.out.println("____________________________________________");
            System.out.println("\n>Digite qual operação deseja realizar: \n");
            System.out.println("1 - Calcular distancia entre vertices");
            System.out.println("2 - Mostrar Caminho dos grafos");
            System.out.println("3 - Identificar numero de componentes conexos");
            System.out.println("4 - Identificar pontos de articulação");
            System.out.println("5 - Identificar pontes");
            System.out.println("6 - Imprimir lista de adjacencia");
            System.out.println("7 - ");
            System.out.println("8 - Sair");
            System.out.println("____________________________________________");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    distancia(nomeArquivo);
                    break;
                case 2:
                    caminho(nomeArquivo);
                    break;
                case 3:
                    componenteConexo(nomeArquivo);
                    break;
                case 4:
                    pontosDeArticulacao(nomeArquivo);
                    break;
                case 5:
                    pontes(nomeArquivo);
                    break;
                case 6:
                    adjacencia(nomeArquivo);
                    break;
                case 7:
                    System.out.println("Opção 7 escolhida");
                    break;

            }

        }
    }

    //Metodo para imprimir a distancia entre um vertice s e um vertice d.
    private void distancia(String nomeArquivo) {

        ArrayList<Vertice> grafo = g.criaGrafo(nomeArquivo);

        int distancia;
        int inicial;
        int destino;
        String imprimir;

        System.out.println("\n>Deseja imprimir a lista de vertices? Digite sim para imprimir");
        imprimir = ler.next();

        if ("sim".equals(imprimir)) {
            imprimeVertices(grafo);
        }
        System.out.println("\n");
        System.out.println("\n>Digite o numero do vertice inicial");
        inicial = ler.nextInt();

        System.out.println("\n>Digite o numero do vertice destino");
        destino = ler.nextInt();

        distancia = g.calculaDistancia(grafo, grafo.get(inicial), grafo.get(destino));

        if (distancia == -1) {
            System.out.println(">A distancia entre o vertice " + grafo.get(inicial).getPalavra().toUpperCase() + " e o vertice "
                    + grafo.get(destino).getPalavra().toUpperCase() + " é infinito. ");
        } else {
            System.out.println("\nA distancia entre o vertice " + grafo.get(inicial).getPalavra().toUpperCase() + " e o vertice "
                    + grafo.get(destino).getPalavra().toUpperCase() + " é " + distancia);
        }
    }

    //Metodo para immprimir o caminho de um vertice s até um um vertice d.
    private void caminho(String nomeArquivo) {
        ArrayList<Vertice> grafo;
        grafo = g.criaGrafo(nomeArquivo);
        ArrayList<Vertice> caminho = new ArrayList<>();
        Scanner lerVariavel = new Scanner(System.in);

        int inicial;
        int destino;
        String imprimir;

        System.out.println("\n>Deseja imprimir a lista de grafos? (Digite sim para imprimir)");
        imprimir = lerVariavel.next();

        if ("sim".equals(imprimir)) {
            imprimeVertices(grafo);
        }

        System.out.println("\n\n>Digite o numero do vertice inicial");
        inicial = lerVariavel.nextInt();

        System.out.println("\n>Digite o numero do vertice destino");
        destino = lerVariavel.nextInt();

        System.out.println("");

        grafo = g.buscaEmLargura(grafo, grafo.get(inicial));

        caminho = g.calculaCaminho(caminho, grafo, grafo.get(inicial), grafo.get(destino));

        if (caminho.isEmpty()) {
            System.out.println("Não existe caminho de " + grafo.get(inicial).getPalavra().toUpperCase()
                    + " á " + grafo.get(destino).getPalavra().toUpperCase());
        } else {
            System.out.println("O caminho entre " + grafo.get(inicial).getPalavra().toUpperCase() + " e " + grafo.get(destino).getPalavra().toUpperCase() + " é:\n");
            for (int i = 0; i < caminho.size(); i++) {
                if (i != caminho.size() - 1) {
                    System.out.print(caminho.get(i).getPalavra().toUpperCase() + " ---- ");
                } else {
                    System.out.print(caminho.get(i).getPalavra().toUpperCase() + ".\n");
                }
            }
        }
    }

    //Metodo para imprimir a quantidade de componentes conexos.
    private void componenteConexo(String nomeArquivo) {
        ArrayList<Vertice> grafo = g.criaGrafo(nomeArquivo);
        int conexos;

        conexos = g.componenteConexo(grafo);
        System.out.println("\nO numero de componentes conexos é: " + conexos);
    }

    //Metodo para imprimir os pontos de articulação do grafo.
    private void pontosDeArticulacao(String nomeArquivo) {
        ArrayList<Vertice> grafo = g.criaGrafo(nomeArquivo);
        ArrayList<Vertice> pontosArticulacao;

        pontosArticulacao = g.articulacao(grafo);
        System.out.println("\n>PONTOS DE ARTICULAÇÃO<\n");
        pontosArticulacao.forEach((v) -> {
            System.out.println(v.getPalavra().toUpperCase() + " é um Ponto de Articulação");
        });
    }

    //Metodo para imprimir os pontos de ponte do grafo.
    private void pontes(String nomeArquivo) {
        ArrayList<Vertice> grafo = g.criaGrafo(nomeArquivo);
        ArrayList<Vertice> listaPontes = new ArrayList<>();

        listaPontes = g.pontes(grafo);

        System.out.println("\n>PONTES<\n");

        for (Vertice v : listaPontes) {
            System.out.println("A aresta entre os vertices: " + v.getPalavra().toUpperCase() + " ---- " + v.getPonte().getPalavra().toUpperCase() + " é Pontes");
        }
    }

    //Metodo para imprimir a lista de adjacencias.
    private void adjacencia(String nomeArquivo) {
        ArrayList<Vertice> grafo;
        grafo = g.criaGrafo(nomeArquivo);

        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).getAdjacencia().isEmpty()) {
                System.out.print("\n" + grafo.get(i).getPalavra() + ".\n");
            } else {
                System.out.print("\n" + grafo.get(i).getPalavra() + " --> ");
            }
            int aux = grafo.get(i).getAdjacencia().size();
            for (int j = 0; j < aux; j++) {
                if (j == aux - 1) {
                    System.out.print(grafo.get(i).getAdjacencia().get(j).getPalavra() + ".\n");
                } else {
                    System.out.print(grafo.get(i).getAdjacencia().get(j).getPalavra() + " --> ");
                }
            }
        }
    }

    //Metodo para realizar a impressão de todos os  vertices do grafo.
    private void imprimeVertices(ArrayList<Vertice> grafo) {
        for (int i = 0; i < grafo.size(); i++) {
            if (i % 4 == 0) {
                System.out.print("\n");
            }
            if (i <= 9) {
                System.out.print("000" + i + " - " + grafo.get(i).getPalavra() + " | ");
            } else if (i <= 99) {
                System.out.print("00" + i + " - " + grafo.get(i).getPalavra() + " | ");            
            }else if (i <= 999){     
                System.out.print("0" + i + " - " + grafo.get(i).getPalavra() + " | ");
            } else {
                System.out.print(i + " - " + grafo.get(i).getPalavra() + " | ");
            }
        }
        System.out.println("\n");
    }
}
