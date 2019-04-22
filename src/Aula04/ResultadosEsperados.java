/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04;

import java.util.Scanner;

/**
 *
 * @author Ronny
 */
public class ResultadosEsperados {

    public void mostrarResultados() {
        Scanner ler = new Scanner(System.in);
        String sair = "continuar";
        int opcao = 0;

        while (!sair.equals("sair")) {
            System.out.println("Foram efetuados alguns testes na mão com os grafos a seguir\n"
                    + "para verificar se os resultados conferem.\n");

            System.out.println("__________________________________");
            System.out.println(" 1 - exemploteste-1");
            System.out.println(" 2 - exemploteste-2");
            System.out.println(" 3 - exemploteste-3");
            System.out.println("__________________________________");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    exemploteste1();
                    break;
                case 2:
                    exemploteste2();
                    break;
                case 3:
                    exemploteste3();
                    break;
            }

            System.out.println("Digite 'sair' para voltar ao menu inicial ou qualquer "
                    + "caracter para voltar ao menu anterior.");
            sair = ler.next();
        }

    }

    public void exemploteste1() {
        System.out.println("O grafo montado com o arquivo exemploteste-1 tem como resultado\n"
                + " esperado as seguintes informações:");

        System.out.println("\n1º - As palavras usadas para montar o grafo são:\n"
                + "ralo, rato, ramo, rata, reta e rito");

        System.out.println("\n2º - A lista de adjacencia esperada é a seguir:\n"
                + "ralo --> rato --> ramo.\n"
                + "rato --> ralo --> ramo --> rata --> rito.\n"
                + "ramo --> ralo --> rato.\n"
                + "rato --> rata --> reta.\n"
                + "reta --> rata.\n"
                + "rito --> rato.\n");

        System.out.println("\n3º - Usando como referencia o vertice 'ralo' e o vertice\n"
                + "'reta', temos que a distancia entre os dois é 3");

        System.out.println("\n4º - Usando como referencia o vertice 'ralo' e o vertice\n"
                + "'reta', temos que o caminho entre eles é ralo --- rato --- rata --- reta ");

        System.out.println("\n5º - A quantidade de componentes conexos deste grafo é de 1");

        System.out.println("\n6º - Os pontos de articulação deste grafo são:\n"
                + "rata e rato");

        System.out.println("\n7º - As pontes deste grafo são:\n"
                + "Aresta entre rata --- reta\n"
                + "Aresta entre rato --- rata\n"
                + "Aresta entre reto --- rito\n");

    }

    public void exemploteste2() {
        System.out.println("O grafo montado com o arquivo exemploteste-2 tem como resultado\n"
                + " esperado as seguintes informações:");

        System.out.println("\n1º - As palavras usadas para montar o grafo são:\n"
                + "aaaa, aaab, abcd, aaca, aacb, abcb, abcf, aacc, bbbb, bbba");

        System.out.println("\n2º - A lista de adjacencia esperada é a seguir:\n"
                + "aaaa --> aaab --> aaca.\n"
                + "aaab --> aaaa --> aacb.\n"
                + "abcd --> abcb --> abcf.\n"
                + "aaca --> aaaa --> aacb --> aacc.\n"
                + "aacb --> aaab --> aaca --> abcb --> aacc.\n"
                + "abcb --> abcd --> aacb --> abcf.\n"
                + "abcf --> abcd --> abcb.\n"
                + "aacc --> aaca --> aacb.\n"
                + "bbbb --> bbba.\n"
                + "bbba --> bbbb.\n");

        System.out.println("\n3º - Usando como referencia o vertice 'aaaa' e o vertice\n"
                + "'abcf', temos que a distancia entre os dois é 4");

        System.out.println("\n4º - Usando como referencia o vertice 'aaaa' e o vertice\n"
                + "'abcf', temos que o caminho entre eles é aaaa --- aaab --- aacb --- abcb --- abcf ");

        System.out.println("\n5º - A quantidade de componentes conexos deste grafo é de 2");

        System.out.println("\n6º - Os pontos de articulação deste grafo são:\n"
                + "abcb e aacb");

        System.out.println("\n7º - As pontes deste grafo são:\n"
                + "Aresta entre aacb --- abcb\n"
                + "Aresta entre bbbb --- bbba\n");

    }

    public void exemploteste3() {
        System.out.println("O grafo montado com o arquivo exemploteste-3 tem como resultado\n"
                + " esperado as seguintes informações:");

        System.out.println("\n1º - As palavras usadas para montar o grafo são:\n"
                + "nnnn, nnnk, nknn, nnkn, aaca, aacc, aacb, bbbb, bbba");

        System.out.println("\n2º - A lista de adjacencia esperada é a seguir:\n"
                + "nnnn --> nnnk --> nknn --> nnkn.\n"
                + "nnnk --> nnnn.\n"
                + "nknn --> nnnn.\n"
                + "nnkn --> nnnn.\n"
                + "aaca --> aacc --> aacb.\n"
                + "aacc --> aaca --> aacb.\n"
                + "aacb --> aaca --> aacc.\n"
                + "bbbb --> bbba.\n"
                + "bbba --> bbbb.\n");

        System.out.println("\n3º - Usando como referencia o vertice 'nnnn' e o vertice\n"
                + "'nknn', temos que a distancia entre os dois é 1");

        System.out.println("\n4º - Usando como referencia o vertice 'nnnn' e o vertice\n"
                + "'nknn', temos que o caminho entre eles é nnnn --- nknn ");

        System.out.println("\n5º - A quantidade de componentes conexos deste grafo é de 3");

        System.out.println("\n6º - O ponto de articulação deste grafo é:\n"
                + "nnnn");

        System.out.println("\n7º - As pontes deste grafo são:\n"
                + "Aresta entre nnnn --- nnnk\n"
                + "Aresta entre nnnn --- nknn\n"
                + "Aresta entre nnnn --- nnkn\n"
                + "Aresta entre bbbb --- bbba\n");

    }
}
