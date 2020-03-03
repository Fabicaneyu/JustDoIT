public class InfraEstrutura extends Conhecimento {

    public InfraEstrutura(String nome, String descricao, String complexidade, String versao, double tempo) {
        super(nome, descricao, complexidade, versao, tempo);
    }

    @Override
    public double getAvaliacao() {
        return 0;
    }

    @Override
    public double getTempoMedio() {
        return 0;
    }

    @Override
    public String getDificuldade() {
        return null;
    }


}
