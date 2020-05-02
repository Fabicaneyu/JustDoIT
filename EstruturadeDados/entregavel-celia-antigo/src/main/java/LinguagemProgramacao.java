import java.sql.Timestamp;

public abstract class LinguagemProgramacao extends Conhecimento {

	private String versao;

    public LinguagemProgramacao(String nome, String descricao, String complexidade, String versao, double tempo) {
        super(nome, descricao, complexidade, tempo);
	    this.versao = versao;
    }



}
