import java.util.ArrayList;

public class ConhecimentoController {

    private ArrayList<Conhecimento> list;

    public ConhecimentoController() {

        list = new ArrayList<Conhecimento>();

    }

    public void adicionaConhecimento(Conhecimento c) {
        list.add(c);
    }

    public void exibeConhecimento() {
        for(Conhecimento c : list) {
            System.out.println(c);
        }
    }

}
