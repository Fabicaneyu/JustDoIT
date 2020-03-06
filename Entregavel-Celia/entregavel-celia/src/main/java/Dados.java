import java.sql.Timestamp;

public abstract class Dados extends Conhecimento {

    public Dados(String nome, String descricao, String complexidade, String versao, double tempo) {
        super(nome, descricao, complexidade, versao, tempo);
    }

}
