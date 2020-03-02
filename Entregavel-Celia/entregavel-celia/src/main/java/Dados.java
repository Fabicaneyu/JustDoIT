public class Dados extends Conhecimento {

    private String tipo;

    public Dados(String nome, String descricao, String complexidade,
                 String versao, double tempo, String tipo) {
        super(nome, descricao, complexidade, versao, tempo);
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }
}
