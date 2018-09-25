package fatec.poo.model;

/**
 *
 * @author Gabriel
 */
public class PessoaFisica extends Pessoa {

    private String cpf;
    private double base;

    public PessoaFisica(String cpf, String nome, int anoInscricao) {
        super(nome, anoInscricao);
        this.cpf = cpf;
    }

    @Override
    public double calcBonus(int ano) {
        if (getTotalCompras() > 12000) {
            return (ano - getAnoInscricao()) * this.base;
        } else {
            return 0;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

}
