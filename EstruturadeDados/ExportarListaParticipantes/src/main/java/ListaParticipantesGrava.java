import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListaParticipantesGrava {

    //Início do Método que grava lista
    public static void gravaLista(ListaObj<Participantes> lista, boolean isCSV) {
        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;
        String nomeArquivo;

        if (isCSV) {
            nomeArquivo = "participantes.csv";
        } else {
            nomeArquivo = "participantes.txt";
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
            for (int i = 0; i < lista.getTamanho(); i++) {
                Participantes p = lista.getElemento(i);

                if (isCSV) {
                    saida.format("%s;%s%n",p.getNome(), p.getRg());
                }
                else {
                    saida.format(" %s %s%n",p.getNome(), p.getRg());
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim = true;
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

    //Término do Método que grava lista
    //Início do método que lê e exibe arquivo

        public static void leExibeArquivo(boolean isCSV) {
            FileReader arq= null;
            Scanner entrada = null;
            String nomeArquivo;
            boolean deuRuim= false;

            if (isCSV) {
                nomeArquivo= "participantes.csv";
            }
            else {
                nomeArquivo= "participantes.txt";
            }

            try {
                arq = new FileReader(nomeArquivo);
                if (isCSV) {
                    entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
                }
                else {
                    entrada = new Scanner(arq);
                }
            }
            catch (FileNotFoundException erro) {
                System.err.println("Arquivo não encontrado");
                System.exit(1);
            }

            try {
                System.out.printf("%-10s%-12s\n","NOME","RG" );

                while (entrada.hasNext()) {
                    String nome = entrada.next();
                    String rg = entrada.next();
                    System.out.printf("%-10s%-12s\n",nome,rg);
                }
            }
            catch (NoSuchElementException erro)
            {
                System.err.println("Arquivo com problemas."); //se arquivo txt com espaço no nome
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
    //Fim do método que lê e exibe arquivo
    //Início do método que main

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean fim = false;
        String nome;
        String rg;
        int opcao;

        ListaObj<Participantes> lista = new ListaObj(5);

        while (!fim) {

            System.out.println("\nEscolha uma das opções:");
            System.out.println("1- Adicionar um participante");
            System.out.println("2- Exibir a lista");
            System.out.println("3- Gravar a lista num arquivo txt");
            System.out.println("4- Gravar a lista num arquivo csv");
            System.out.println("5- Ler e exibir arquivo txt");
            System.out.println("6- Ler e exibir arquivo csv");
            System.out.println("7- Fim");

            opcao= leitor.nextInt();

            switch(opcao) {
                // Opção 1 - Adicionar um participante
                case 1:
                    System.out.println("Digite o nome do participante:");
                    nome= leitor.next();
                    System.out.println("Digite o rg do participante");
                    rg= leitor.next();

                    Participantes participantes = new Participantes(nome,rg);

                    lista.adiciona(participantes);
                    break;

                // Opção 2 - Exibir a lista
                case 2:
                    if (lista.getTamanho() == 0)  {
                        System.out.println("Lista vazia");
                    }
                    else {
                        lista.exibe();
                    }
                    break;

                // Opção 3 - Gravar a lista num arquivo txt
                case 3:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que gravar.");
                    }
                    else {
                        gravaLista(lista, false);
                        lista.limpa();
                    }
                    break;

                // Opção 4 - Grava em csv
                case 4:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que gravar.");
                    }
                    else {
                        gravaLista(lista, true);
                        lista.limpa();
                    }
                    break;

                // Opção 5 - Ler e exibir arquivo txt
                case 5:
                    leExibeArquivo(false);
                    break;

                // Opção 6 - Ler e exibir arquivo csv
                case 6:
                    leExibeArquivo(true);
                    break;

                // Opção 7 - Fim
                case 7:
                    fim = true;
                    break;

                // Opção diferente de 1 a 7
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    //fim do método que main
}


