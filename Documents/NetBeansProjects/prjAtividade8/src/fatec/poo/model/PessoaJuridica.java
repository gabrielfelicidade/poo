package fatec.poo.model;

/**
 *
 * @author Gabriel
 */
public class PessoaJuridica extends Pessoa {

    private String cgc;
    private double taxaIncentivo;

    public PessoaJuridica(String cgc, String nome, int anoInscricao) {
        super(nome, anoInscricao);
        this.cgc = cgc;
    }

    @Override
    public double calcBonus(int ano) {
        return (this.taxaIncentivo / 100 * getTotalCompras()) * (ano - getAnoInscricao());
    }

    public void setTaxaIncentivo(double taxaIncentivo) {
        this.taxaIncentivo = taxaIncentivo;
    }

    public String getCgc() {
        return cgc;
    }

    public double getTaxaIncentivo() {
        return taxaIncentivo;
    }

}
