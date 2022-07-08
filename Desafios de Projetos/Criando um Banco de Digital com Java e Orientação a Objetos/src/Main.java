
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Cliente novoCli() {
        Cliente cli = new Cliente();
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o nome do Correntista :: ");
        cli.setNome(scan.nextLine());
        System.out.println("Informe o CFP do Correntista  :: ");
        cli.setCpf(scan.nextInt());
        return cli;
    }

    public static void main(String[] args) {
        Banco bancoDigital = new Banco();
        bancoDigital.setNome("Banco Digital D1000");

        // Adicionando Novas Contas
        for (int i = 0; i < 3; i++) {
            List<Conta> lsConta = new ArrayList<>();
            Conta conta;
            if (i % 2 == 0) {
                conta = new ContaCorrente(novoCli());
            } else {
                conta = new ContaPoupanca(novoCli());
            }
            lsConta = bancoDigital.getContas();
            lsConta.add(conta);
            bancoDigital.setContas(lsConta);
        }

        // Apresentar Extrato e infos
        for (Conta conta : bancoDigital.getContas()) {
            conta.imprimirExtrato();
        }

    }

}
