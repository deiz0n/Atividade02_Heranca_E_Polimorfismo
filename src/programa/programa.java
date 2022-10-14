package programa;

import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import entidades.TipoPessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class programa {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<TipoPessoa> list = new ArrayList<>();

        int quantiContribui;
        double taxaTotal = 0.0;

        System.out.print("Digite o número de contribuintes: ");
        quantiContribui = input.nextInt();

        for (int x = 1; x <= quantiContribui; x++) {
            System.out.println("Informações do contribuinte #" + x);
            System.out.print("Pessoa Fisíca (f) ou Pessoa Jurídica (j)? ");
            char tipo = input.next().charAt(0);
            System.out.print("Nome: ");
            String nome = input.next();
            System.out.print("Renda anual: ");
            double rendaAnual = input.nextDouble();
            if (tipo == 'f') {
                System.out.print("Despesas com saúde: ");
                double despesaSaude = input.nextDouble();

                TipoPessoa typesPeople = new PessoaFisica(nome, rendaAnual, despesaSaude);
                list.add(typesPeople);
            } else if (tipo == 'j') {
                System.out.print("Quantidade de funcionários: ");
                int quantiFuncionario = input.nextInt();;

                TipoPessoa typesPeople = new PessoaJuridica(nome, rendaAnual, quantiFuncionario);
                list.add(typesPeople);
            }
        }

        System.out.println("");
        System.out.println("Impostos pagos: ");
        for (TipoPessoa lista : list) {
            System.out.println(lista.getNome() + ": $ " + String.format("%.2f", lista.taxa()));
            taxaTotal += lista.taxa();;
        }
        System.out.println("");
        System.out.println("Imposto total: $ " + String.format("%.2f", taxaTotal));

        input.close();

    }

}
