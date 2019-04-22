/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ronny
 */
public class ManipulaArquivo {

    ArrayList<String> dados = new ArrayList<>();

    public ArrayList<String> LerArquivoLinha(String nomeArquivo) {
        dados.clear();
        try {
            File file = new File("src//Arquivos//" + nomeArquivo + ".txt");
            FileReader arquivo = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arquivo);
            String linha = lerArq.readLine();

            while (linha != null) {
                dados.add(linha);
                linha = lerArq.readLine();
            }

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo:", e.getMessage());
        }

        return dados;
    }

    public ArrayList<String> LerArquivo(String nomeArquivo) {
        dados.clear();
        try {
            FileReader arquivo = new FileReader("src//Arquivos//" + nomeArquivo + ".txt");
            BufferedReader lerArq = new BufferedReader(arquivo);
            String texto = lerArq.readLine();
            String palavras = texto;

            while (texto != null) {
                texto = lerArq.readLine();
                palavras = palavras + texto;
            }

            char[] chPalavra = palavras.toCharArray();
            String palavra = "";
            int inicial = 0;
            for (int i = 0; i < chPalavra.length; i++) {
                if (i == inicial + 4) {
                    dados.add(palavra);
                    inicial = i;
                    palavra = "";
                }
                palavra = palavra + chPalavra[i];
            }

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo:", e.getMessage());
        }

        return dados;
    }

    public void criarArquivo(ArrayList<String> dados, String nome) {
        try {
            File arquivo = new File("src//Arquivos//" + nome + ".txt");
            try (BufferedWriter gravarArquivo = new BufferedWriter(new FileWriter(arquivo))) {
                for (int i = 0; i < dados.size(); i++) {
                    gravarArquivo.write(dados.get(i));
                    gravarArquivo.newLine();
                }

                gravarArquivo.flush();
            }
        } catch (IOException e) {
            System.err.printf("Falha na criação do arquivo", e.getMessage());
        }

    }

    public ArrayList<String> listarArquivos(){
        File file = new File("src//Arquivos");

        File[] arquivos = file.listFiles();
        ArrayList<String> nomes = new ArrayList<>();

        for (File fileTmp : arquivos) {
            char[] nome = fileTmp.getName().toCharArray();
            String palavra = "";
            for (char c : nome) {
                if (c == '.') {
                    break;
                }
                palavra = palavra + c;
            }
            nomes.add(palavra);
        }
        return nomes;
    }
}
