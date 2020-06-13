import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        int[] vetor = new int[10];
        FilaPilha queueStack = new FilaPilha(10);
        Scanner scanner = new Scanner(System.in);


        int cont = 0;
        do{
            System.out.println("Digite um número -->");
            vetor[cont] = scanner.nextInt();
            cont++;
        } while (cont <10);


        for(int i : vetor) {
            if(i <= 18) {
                queueStack.insert(i);
            } else {
                queueStack.push(i);
            }
        }



        while (!queueStack.isFilaEmpty()) {
            System.out.print(queueStack.poll() + " \t");
        }
        while (!queueStack.isPilhaEmpty()) {
            System.out.print(queueStack.pop() + " \t");
        }
    }

}
