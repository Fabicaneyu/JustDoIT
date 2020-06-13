

public class FilaPilha {

    private int topoPilha;
    private int tamanhoFila;
    private int[] pilhaFila;

    public FilaPilha(int capacidade) {
        this.tamanhoFila = 0;
        this.pilhaFila = new int[capacidade];
        this.topoPilha = pilhaFila.length -1;
    }

    public boolean isFilaEmpty() {

        return tamanhoFila == 0;

    }

    public boolean isPilhaEmpty() {

        return topoPilha == pilhaFila.length-1;

    }

    public boolean isFull() {
        return topoPilha == tamanhoFila -1;
    }

    public void push(int value) {

        if(!isFull()) {
            pilhaFila[--topoPilha] = value;
        } else {
            System.out.println("Pilha cheia.");
        }
    }

    public int pop() {
        if(!isPilhaEmpty()) {
            return pilhaFila[topoPilha++];
        } else {
            System.out.println("Pilha vazia.");
            return 0;
        }

    }

    public void insert(int value) {
        if(!isFull()) {
            pilhaFila[tamanhoFila++] = value;
        } else {
            System.out.println("Fila cheia.");
        }
    }

    public int poll() {
        if(!isFilaEmpty()) {
            int first = pilhaFila[0];
            for(int i=0; i < tamanhoFila; i++) {
                pilhaFila[i] = pilhaFila[i+1];
            }
            tamanhoFila --;
            return first;
        } else{
            System.out.println("Fila vazia.");
            return 0;
        }

    }

    public void exibeFila() {

        if(!isFilaEmpty()) {
            for(int i=0; i < tamanhoFila; i++) {
                System.out.print(pilhaFila[i] + "\t ");
            }
        } else {
            System.out.println("Fila vazia.");
        }


    }

    public void exibePilha() {

        if(!isPilhaEmpty()) {
            for(int i=pilhaFila.length-1; i > topoPilha; i--) {
                System.out.print(pilhaFila[i] + "\t ");
            }
        } else {
            System.out.println("Pilha vazia.");
        }

    }

}
