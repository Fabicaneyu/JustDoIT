public class Participantes {
    private String nome;
    private String rg;

    public Participantes(String nome, String rg) {
        this.nome = nome;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Participantes{" +
                "nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                '}';
    }
}
