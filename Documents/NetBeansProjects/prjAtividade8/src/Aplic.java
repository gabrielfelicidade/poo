
import fatec.poo.model.Pessoa;
import fatec.poo.model.PessoaFisica;
import fatec.poo.model.PessoaJuridica;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Aplic {

    public static void main(String[] args) {

        int opc = 0, anoInscricao, iMat = 0;
        Scanner scan = new Scanner(System.in);
        String nome, cpf, cgc, tipo, doc;
        double valor, total, base, taxaIncentivo;
        Pessoa matPes[] = new Pessoa[20];
        DecimalFormat df = new DecimalFormat("#,##0.00");

        do {
            System.out.println("\n1 - Cadastrar Pessoa Física\n"
                    + "2 - Cadastrar Pessoa Jurídica\n"
                    + "3 - Listar\n"
                    + "4 - Sair");
            System.out.print("\nDigite a opção: ");
            opc = scan.nextInt();

            if (opc == 1 || opc == 2) {
                if (iMat == 20) {
                    System.out.println("\nLimite de pessoas atingido.");
                } else {
                    scan.nextLine();
                    System.out.print("Informe o nome da pessoa: ");
                    nome = scan.nextLine();
                    System.out.print("Informe o ano de inscrição: ");
                    anoInscricao = scan.nextInt();
                    total = 0;

                    do {
                        System.out.print("Informe o valor da compra(0 para finalizar): ");
                        valor = scan.nextDouble();
                        total += valor;
                    } while (valor > 0);

                    if (opc == 1) {
                        System.out.print("Informe o CPF: ");
                        cpf = scan.next();
                        System.out.print("Informe a base salarial: ");
                        base = scan.nextDouble();
                        matPes[iMat] = new PessoaFisica(cpf, nome, anoInscricao);
                        matPes[iMat].addCompras(total);
                        ((PessoaFisica) matPes[iMat]).setBase(base);
                        iMat++;
                    } else {
                        System.out.print("Informe o CGC: ");
                        cgc = scan.next();
                        System.out.print("Informe a taxa de incentivo: ");
                        taxaIncentivo = scan.nextDouble();
                        matPes[iMat] = new PessoaJuridica(cgc, nome, anoInscricao);
                        matPes[iMat].addCompras(total);
                        ((PessoaJuridica) matPes[iMat]).setTaxaIncentivo(taxaIncentivo);
                        iMat++;
                    }
                }
            } else if (opc == 3) {
                if (iMat == 0) {
                    System.out.println("\nNenhuma pessoa cadastrada.");
                } else {
                    System.out.printf("\n%-15s %-20s %-25s %15s %15s\n\n", "Tipo", "CPF/CGC", "Nome", "Ano Inscrição", "Bônus");
                    for (int i = 0; i < iMat; i++) {
                        tipo = (matPes[i] instanceof PessoaFisica) ? "Pessoa Física" : "Pessoa Jurídica";
                        doc = (matPes[i] instanceof PessoaFisica) ? ((PessoaFisica) matPes[i]).getCpf() : ((PessoaJuridica) matPes[i]).getCgc();
                        System.out.printf("%-15s %-20s %-25s %15d %15s\n",
                                tipo,
                                doc,
                                matPes[i].getNome(),
                                matPes[i].getAnoInscricao(),
                                "R$ " + df.format(matPes[i].calcBonus(Calendar.getInstance().get(Calendar.YEAR))));
                    }
                }
            }
        } while (opc != 4);

    }

}
