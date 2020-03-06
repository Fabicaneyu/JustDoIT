import java.sql.Timestamp;

public abstract class InfraEstrutura extends Conhecimento {

    public InfraEstrutura(String nome, String descricao, String complexidade, String versao, double tempo) {
        super(nome, descricao, complexidade, versao, tempo);
    }
}
