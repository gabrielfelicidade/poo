package fatec.poo.model;

/**
 *
 * @author Gabriel
 */
public abstract class Pessoa {

    private String nome;
    private int anoInscricao;
    private double totalCompras;

    public Pessoa(String nome, int anoInscricao) {
        this.nome = nome;
        this.anoInscricao = anoInscricao;
    }

    public abstract double calcBonus(int ano);

    public void addCompras(double valor) {
        this.totalCompras += valor;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoInscricao() {
        return anoInscricao;
    }

    public double getTotalCompras() {
        return totalCompras;
    }

}
