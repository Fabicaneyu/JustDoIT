import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {

        Conhecimento java = new Java("Java", "Linguagem de programação" +
                "orientada a objetos", "ALTA", "13.O", 10.0);

        Conhecimento mysql = new MySQL("MySQL", "Banco de dados relacional",
                "MÉDIA", 7.0);

        ConhecimentoController controller = new ConhecimentoController();

        controller.adicionaConhecimento(java);
        controller.adicionaConhecimento(mysql);

        controller.exibeConhecimento();



    }
}
