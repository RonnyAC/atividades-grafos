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
public class Inicial {

    private final Scanner ler = new Scanner(System.in);
    Grafo g = new Grafo();
    private String nomeArquivo;
    Operacoes operacoes = new Operacoes();

    /**
     * Interface inicial com o usuário
     *
     */
    public void inciliazaPrograma() {
        int opcao = 0;

        while (opcao != 8) {
            System.out.println("******PROGRAMA PARA EXECUTAR OPERAÇÕES COM GRAFOS******\n");
            System.out.println("__________________________________");
            System.out.println(" O que deseja fazer?");
            System.out.println(" 1 - Criar uma lista de palavras");
            System.out.println(" 2 - Escolher uma lista ja pronta");
            System.out.println(" 8 - sair");
            System.out.println("__________________________________");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    criarArquivo();
                    break;
                case 2:
                    listarArquivos();
                    break;
            }
        }
    }

    public void listarArquivos() {
        ArrayList<String> arquivo;
        ManipulaArquivo listar = new ManipulaArquivo();
        arquivo = listar.listarArquivos();
        System.out.println("\n>LISTA DE ARQUIVOS \n");

        for (int i = 0; i < arquivo.size(); i++) {
            System.out.println("- " + arquivo.get(i));
        }

        System.out.println("\nDigite o nome do arquivo desejado");
        nomeArquivo = ler.next();
        while (!arquivo.contains(nomeArquivo)) {
            System.out.println("Não existe o arquivo digitado");
            nomeArquivo = ler.next();
        }
        operacoes.operacoes(nomeArquivo);
    }

    /**
     * Método responsavel por criar um arquivo com palavras a serem utilizadas
     * nas operações do programa.
     *
     * VARIAVEIS
     *
     * nomeArquivo(String) - Recebe o nome do arquivo que serácriado.
     * palavra(String) - Recebe a plavra que será armazeda no arquivo.
     * arquivoDados(ArrayList<String>) - Recebe cada palavra inserida pelo
     * usuário para ser adicionada no arquivo. numLetras(int) - Recebe o numero
     * de letras que terão as palavras do arquivo, impedindo que haja palavras
     * com tamanhos diferentes.
     *
     */
    private void criarArquivo() {
        System.out.println("Digite o nome do arquivo");
        nomeArquivo = ler.next();
        ArrayList<String> arquivoDados = new ArrayList<>();

        System.out.println("digite dois numeros/letras/palavras separados por virgula");
        String parPalavras = ler.next();
        String array[] = parPalavras.split(",");
        while (array.length != 2) {
            System.out.println("A palavra digitada nao tem os parametros pedidos");
            parPalavras = ler.next();
            array = null;
            array = parPalavras.split(",");
        }
        arquivoDados.add(parPalavras);

        while (!parPalavras.equals("/QUIT")) {
            System.out.println("Digite a palavra, ou </QUIT> para sair");
            parPalavras = ler.next();
            array = null;
            array = parPalavras.split(",");
            if (parPalavras.equals("/QUIT")) {
                continue;
            } else if (array.length != 2) {
                System.out.println("A palavra digitada nao tem os parametros pedidos\n");
                continue;
            }
            arquivoDados.add(parPalavras);
        }
        ManipulaArquivo criar = new ManipulaArquivo();
        criar.criarArquivo(arquivoDados, nomeArquivo);

        System.out.println("Arquivo criado com sucesso, agora realize as operações desejadas");
        operacoes.operacoes(nomeArquivo);
    }

}
