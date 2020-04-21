package com.bandtec.provinha.tres;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteLivro {
    boolean sair = false;
    int qtdPagina;
    int idLivro;
    String titulo;
    String autor;
    double preco;

    public static void gravaLista(ListaObj<Livro> lista, boolean isCSV) {
        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;
        String nomeArquivo;


        if (isCSV) {
            nomeArquivo= "livro.csv";
        }
        else {
            nomeArquivo = "";
            deuRuim = true;
        }

        try {
            arq = new FileWriter(nomeArquivo, true);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }

        try {
            for (int i=0; i< lista.getTamanho(); i++) {
                Livro l = lista.getElemento(i);

                if (isCSV) {
                    saida.format("%d;%s;%s;%.2f;%d%n",l.getIdLivro(),l.getTitulo(),l.getAutor(),
                            l.getPreco(), l.getQtdPagina());
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }


    public static void leExibeArquivo(boolean isCSV) {
        FileReader arq= null;
        Scanner entrada = null;
        String nomeArquivo;
        boolean deuRuim= false;

        if (isCSV) {
            nomeArquivo= "livro.csv";
        }
        else {
            nomeArquivo= "";
            deuRuim = true;
        }


        try {
            arq = new FileReader(nomeArquivo);
            if (isCSV) {
                entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
            }

        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%-8s %-10s %-10S %-10S %-10s\n","ID","TITULO","PREÇO", "AUTOR", "QTDPAGINAS" );
            // Enquanto tem registro a ser lido
            while (entrada.hasNext()) {
                int idLivro = entrada.nextInt();
                String titulo = entrada.next();
                String autor = entrada.next();
                double preco = entrada.nextDouble();
                int qtdPaginas = entrada.nextInt();
                System.out.printf("%-8d %-10s %7.2f %-10s %-8d\n",idLivro,titulo, preco,autor, qtdPaginas);
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        }
        catch (IllegalStateException erro)
        {
            System.err.println("Erro na leitura do arquivo.");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
    public static void gravaListaAutor( ListaObj<Livro> lista, boolean isCSV) {
        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;
        String nomeArquivo;

        if (isCSV) {
            nomeArquivo= "autor.csv";
        }
        else {
            nomeArquivo= "";
            deuRuim=true;
        }

        try {
            arq = new FileWriter(nomeArquivo, false);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }


        try {

            for (int i=0; i< lista.getTamanho(); i++) {
                Livro a = lista.getElemento(i);

                if (isCSV) {
                    saida.format("%s;%d;%.2f;%d;%s%n",a.getAutor(), a.getIdLivro(),
                            a.getPreco(),a.getQtdPagina(), a.getTitulo());
                }
                else {
                    saida.format("%s %d %.2f %d %s%n",a.getAutor(), a.getIdLivro(),
                            a.getPreco(),a.getQtdPagina(), a.getTitulo());
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoAutor(boolean isCSV) {
        FileReader arq= null;
        Scanner entrada = null;
        Scanner entrada2 = null;
        String nomeArquivo;
        boolean deuRuim= false;


        if (isCSV) {
            nomeArquivo= "autor.csv";
        }
        else {
            nomeArquivo= "";
            deuRuim = true;
        }


        try {
            arq = new FileReader(nomeArquivo);
            if (isCSV) {
                entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
            }

        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%-8s %-10s %-10S %-10S %-10s\n","ID","TITULO","PREÇO", "AUTOR", "QTDPAGINAS" );
            // Enquanto tem registro a ser lido
            while (entrada.hasNext()) {
                int idLivro = entrada.nextInt();
                String autor = entrada.next();
                double preco = entrada.nextDouble();
                String titulo = entrada2.nextLine();
                int qtdPaginas = entrada.nextInt();
                System.out.printf("%-8d %-10s %7.2f %-10s %-8d\n",idLivro,titulo,preco,autor,qtdPaginas);
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        }
        catch (IllegalStateException erro)
        {
            System.err.println("Erro na leitura do arquivo.");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }


    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);

        boolean sair = false;
        int idLivro;
        String titulo;
        String autor;
        double preco;
        int qtdPagina;
        int opcao;

        ListaObj<Livro> lista = new ListaObj<>(5);
        ListaObj<Livro> listaAutor12 = new ListaObj<>(5);

        while (!sair) {
            System.out.println("\nEscolha uma das opções:");
            System.out.println("1- Adicionar um Livro");
            System.out.println("2- Exibir a lista");
            System.out.println("3- Gravar a lista em arquivo csv");
            System.out.println("4- Ler e exibir o arquivo gravado na opção 3");
            System.out.println("5- Gravar apenas livros de um determinado autor em arquivo");
            System.out.println("6- Ler e exibir o arquivo gravado na opção 5");
            System.out.println("7- sair");

            opcao= leitor.nextInt();

            switch(opcao) {
                // Opção 1 - Adicionar um Livro
                case 1:

                    System.out.println("Digite o id do Livro");
                    idLivro= leitor.nextInt();
                    System.out.println("Digite o titulo do Livro");
                    titulo= leitor2.nextLine();
                    System.out.println("Digite o preço do livro");
                    preco=leitor.nextDouble();
                    System.out.println("Digite  autor do Livro");
                    autor= leitor.next();
                    System.out.println("Quantas páginas tem o livro?");
                    qtdPagina=leitor.nextInt();

                    Livro livro = new Livro(idLivro,titulo,autor, preco, qtdPagina);

                    listaAutor12.adiciona(livro);
                    lista.adiciona(livro);
                    break;

                // Opção 2 - Exibir a lista
                case 2:
                    if (lista.getTamanho() == 0)  {
                        System.out.println("Lista está vazia");
                    }
                    else {
                        lista.exibe();
                    }
                    break;

                // Opção 3 - Gravar a lista num arquivo (csv)
                case 3:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há nada a gravar.");
                    }
                    else {
                        gravaLista(lista, true);
                        lista.limpa();
                    }
                    break;

                // Opção 4 - Ler e exibir o arquivo gravado na opção 3
                case 4:
                    leExibeArquivo(true);
                    break;

                // Opção 5 - Gravar apenas livros de um determinado autor em arquivo (csv)
                case 5:
                    if (listaAutor12.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que gravar." +listaAutor12.getTamanho());
                    }
                    else {
                        System.out.println("Digite o autor do livro");

                        String autor1 = leitor.next();

                        ListaObj<Livro> listaAutor = new ListaObj(10);

                        for(int i =0; i < listaAutor12.getTamanho(); i++){
                            if(listaAutor12.getElemento(i).getAutor().equals(autor1)){
                                listaAutor.adiciona(listaAutor12.getElemento(i));
                                gravaListaAutor(listaAutor,true);

                            }

                        }
                    }
                    break;

                // Opção 6 - Ler e exibir arquivo gravado na opção 5
                case 6:
                    System.out.println("Digite o nome do autor");
                    leExibeArquivoAutor(true);
                    break;


                // Opção 7 - Sair
                case 7:
                    sair = true;
                    break;

                // Opção inválida
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
