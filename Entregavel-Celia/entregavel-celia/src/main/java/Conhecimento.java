public abstract class Conhecimento {

    private String nome;
    private String descricao;
    private String complexidade;
    private String versao;
    private double tempo;

    public Conhecimento(String nome, String descricao, String complexidade, String versao, double tempo) {
        this.nome = nome;
        this.descricao = descricao;
        this.complexidade = complexidade;
        this.versao = versao;
        this.tempo = tempo;
    }

    public abstract double getAvaliacao() ;

    public abstract double getTempoMedio() ;

    public abstract String getDificuldade() ;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(String complexidade) {
        this.complexidade = complexidade;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }
}