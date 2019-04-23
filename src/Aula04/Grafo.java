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
public class Grafo {

    private final ArrayList<Vertice> lista = new ArrayList<>();
    private int conexo;
    private int tempo;

    public ArrayList<Vertice> criaGrafo(String nomeArquivo) {
        ArrayList<Vertice> grafo = new ArrayList<>();

        ArrayList<String> palavras;
        ManipulaArquivo ler = new ManipulaArquivo();
        palavras = ler.LerArquivoLinha(nomeArquivo);
        ArrayList<Vertice> listaDeVertice = criaVertices(palavras);
        grafo = criaListaAdjacencia(listaDeVertice);

        return grafo;
    }

    private ArrayList<Vertice> criaVertices(ArrayList<String> palavras) {
        ArrayList<Vertice> listaVeritice = new ArrayList<>();
        for (int i = 0; i < palavras.size(); i++) {
            String array[] = new String[2];
            array = palavras.get(i).split(",");

            Vertice primeiro = new Vertice(array[0]);
            primeiro.setAdjacencia(new ArrayList<>());
            listaVeritice.add(primeiro);

            Vertice segundo = new Vertice(array[1]);
            segundo.setAdjacencia(new ArrayList<>());
            listaVeritice.add(segundo);
        }
        return listaVeritice;
    }

    private ArrayList<Vertice> criaListaAdjacencia(ArrayList<Vertice> listaDeVertice) {
        ArrayList<Vertice> grafo = new ArrayList<>();
        for (int i = 0; i < listaDeVertice.size() - 2;) {
            Vertice primeiro = ChecaVerticeNoGrafo(grafo, listaDeVertice.get(i));
            Vertice segundo = ChecaVerticeNoGrafo(grafo, listaDeVertice.get(i + 1));
            if (!primeiro.getAdjacencia().contains(segundo)) {
                primeiro.getAdjacencia().add(segundo);
            }
            i = i + 2;
        }
        System.out.println("\nCONCLUIDO");
        return grafo;
    }

    public ArrayList<Vertice> buscaEmLargura(ArrayList<Vertice> grafo, Vertice s) {
        Vertice u;
        ArrayList<Vertice> fila = new ArrayList<>();
        inicializa(grafo, s);
        s = buscaVertice(grafo, s);
        fila.add(s);
        while (!fila.isEmpty()) {
            u = fila.remove(0);
            for (Vertice v : u.getAdjacencia()) {
                if ("branco".equals(v.getCor())) {
                    v.setCor("cinza");
                    v.setDistancia(u.getDistancia() + 1);
                    v.setPredecessor(u);
                    fila.add(v);
                }
            }
            u.setCor("preto");
        }

        return grafo;
    }

    public int componenteConexo(ArrayList<Vertice> grafo) {
        for (Vertice v : grafo) {
            v.setCor("branco");
        }
        conexo = 0;
        for (Vertice v : grafo) {
            if ("branco".equals(v.getCor())) {
                conexo = conexo + 1;
                visita(v);
            }
        }
        return conexo;
    }

    private void visita(Vertice u) {
        u.setCor("cinza");
        u.setComponenteConexo(conexo);
        for (Vertice v : u.getAdjacencia()) {
            if ("branco".equals(v.getCor())) {
                visita(v);
            }
        }
        u.setCor("preto");
    }

    public ArrayList<Vertice> articulacao(ArrayList<Vertice> grafo) {
        lista.clear();
        for (Vertice v : grafo) {
            v.setCor("branco");
        }
        for (Vertice v : grafo) {
            if ("branco".equals(v.getCor())) {
                pontoArticulacao(v, grafo);
            }
        }
        return lista;
    }

    private void pontoArticulacao(Vertice u, ArrayList<Vertice> grafo) {
        tempo = tempo + 1;
        u.setCor("cinza");
        u.setTempoDescoberta(tempo);
        u.setLow(u.getTempoDescoberta());
        for (Vertice v : u.getAdjacencia()) {
            if ("branco".equals(v.getCor())) {
                v.setPredecessor(u);
                pontoArticulacao(v, grafo);
                if (u.getPredecessor() == null) {
                    if (checaSegundoFilho(v, u, grafo)) {
                        if (!lista.contains(u)) {
                            lista.add(u);
                        }
                    }
                } else {
                    u.setLow(Integer.min(u.getLow(), v.getLow()));
                    if (v.getLow() >= u.getTempoDescoberta()) {
                        if (!lista.contains(u)) {
                            lista.add(u);
                        }
                    }
                }
            } else {
                if (v != u.getPredecessor() && (v.getTempoDescoberta() < u.getTempoDescoberta())) {
                    u.setLow(Integer.min(u.getLow(), v.getTempoDescoberta()));
                }
            }
        }
        u.setCor("preto");
        tempo = tempo + 1;
        u.setTempoTermino(tempo);
    }

    private boolean checaSegundoFilho(Vertice v, Vertice u, ArrayList<Vertice> grafo) {
        boolean retorno = false;
        if (v.getPredecessor() == u) {
            for (Vertice vertice : grafo) {
                if ((vertice.getPredecessor() == u) && (vertice != v)) {
                    retorno = true;
                }
            }
        }
        return retorno;
    }

    public ArrayList<Vertice> pontes(ArrayList<Vertice> grafo) {
        lista.clear();
        for (Vertice v : grafo) {
            v.setCor("branco");
        }
        for (Vertice v : grafo) {
            if ("branco".equals(v.getCor())) {
                calculaPontes(v);
            }
        }
        return lista;
    }

    private void calculaPontes(Vertice u) {
        tempo = tempo + 1;
        u.setCor("cinza");
        u.setTempoDescoberta(tempo);
        u.setLow(u.getTempoDescoberta());

        for (Vertice v : u.getAdjacencia()) {
            if ("branco".equals(v.getCor())) {
                v.setPredecessor(u);
                calculaPontes(v);
                u.setLow(Integer.min(u.getLow(), v.getLow()));
                if (v.getLow() > u.getTempoDescoberta()) {
                    Vertice p = new Vertice();
                    p.setPalavra(u.getPalavra());
                    p.setPonte(v);
                    lista.add(p);
                }
            } else {
                if ((v != u.getPredecessor()) && (v.getTempoDescoberta() < u.getTempoDescoberta())) {
                    u.setLow(Integer.min(u.getLow(), v.getTempoDescoberta()));
                }
            }
        }
        u.setCor("preto");
        tempo = tempo + 1;
        u.setTempoTermino(tempo);
    }

    public ArrayList<Vertice> calculaCaminho(ArrayList<Vertice> caminho,
            ArrayList<Vertice> grafo, Vertice s, Vertice d) {
        if (d == s) {
            caminho.add(s);
        } else {
            if (d.getPredecessor() == null) {
                caminho.clear();
            } else {
                calculaCaminho(caminho, grafo, s, d.getPredecessor());
                caminho.add(d);
            }
        }
        return caminho;
    }

    public int calculaDistancia(ArrayList<Vertice> grafo, Vertice s, Vertice d) {
        int dist = 0;
        grafo = buscaEmLargura(grafo, s);

        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i) == d) {
                dist = grafo.get(i).getDistancia();
                break;
            }
        }
        return dist;
    }

    private ArrayList<Vertice> inicializa(ArrayList<Vertice> grafo, Vertice s) {
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i) == s) {
                grafo.get(i).setCor("cinza");
                grafo.get(i).setDistancia(0);
                grafo.get(i).setPredecessor(null);
            } else {
                grafo.get(i).setCor("branco");
                grafo.get(i).setDistancia(-1);
                grafo.get(i).setPredecessor(null);
            }
        }
        return grafo;
    }

    public Vertice buscaVertice(ArrayList<Vertice> grafo, Vertice s) {

        for (Vertice v : grafo) {
            if (v.getPalavra().equals(s.getPalavra())) {
                s = v;
                break;
            }
        }
        return s;
    }

    private Vertice ChecaVerticeNoGrafo(ArrayList<Vertice> grafo, Vertice vertice) {
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).getPalavra().equals(vertice.getPalavra())) {
                return grafo.get(i);
            }
        }
        grafo.add(vertice);
        return vertice;
    }
}
