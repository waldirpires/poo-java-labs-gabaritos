package poo.java.labs.u4.estacionamento;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Sistema implements ControleDeEstacionamento {

    private Estacionamento estacionamento;

    public Sistema(String nome, int totalVagas, float valorHora) {
        this.estacionamento = new Estacionamento(nome, totalVagas, valorHora);
    }

    public void exibirMenu() {
        System.out.println("\nESTACIONAMENTO " + estacionamento.getNome());
        System.out.println();
        System.out.println("1. Cadastrar entrada");
        System.out.println("2. Cadastrar Saída");
        System.out.println("3. Exibir total vagas");
        System.out.println("4. Exibir vagas disponiveis");
        System.out.println("5. Exibir taxa de ocupação");
        System.out.println("6. Exibir listagem");
        System.out.println("9. Sair");
    }

    public void executar() {
        int op = 0;
        String placa;
        Automovel a;
        var scanner = new Scanner(System.in);

        while (op != 9) {
            exibirMenu();
            op = scanner.nextInt();

            switch (op) {
            case 1:
                System.out.println("Digite a placa: ");
                placa = scanner.next();

                cadastrarEntradaVeiculo(placa);

                break;
            case 2:
                System.out.println("Digite a placa: ");
                placa = scanner.next();

                cadastrarSaidaVeiculo(placa);

                break;
            case 3:
                System.out.println("Total de vagas: " + obterNumeroTotalDeVagas());
                break;
            case 4:
                System.out.println("Total de vagas disponiveis: " + obterNumeroTotalDeAutomoveis());
                break;
            case 6:
                exibirVeiculosEstacionados();
                break;
            case 5:
                System.out.println("Taxa de ocupação: " + obterTaxaDeOcupacao());
                break;
            case 9:
                System.out.println("Saindo do sistema.\n\nObrigado!\n");
                break;
            }

            System.out.println("Aperte [c] para continuar . . .");
            scanner.next();
        }
        scanner.close();
    }

    @Override
    public void cadastrarEntradaVeiculo(String placa) {
        var a = estacionamento.cadastrarEntrada(placa);

        if (a != null) {
            System.out.println("INFO: entrada cadastrada com sucesso.\n");
        }
    }

    @Override
    public void cadastrarSaidaVeiculo(String placa) {
        var a = estacionamento.cadastrarSaida(placa, LocalDateTime.now());

        if (a != null) {
            System.out.println("INFO: saída cadastrada com sucesso.\n");

            System.out.println(a);
        }
    }

    @Override
    public float calcularValorEstacionamento(String placa) {
        var a = estacionamento.pesquisarPorAutomovel(placa);

        if (a == null || a.getSaida() == null) {
            return 0.0f;
        }

        return a.getValorTotal();
    }

    @Override
    public void exibirVeiculosEstacionados() {
        System.out.println("\nListagem: " + estacionamento.getAutomoveis().size());
        for (var auto : estacionamento.getAutomoveis()) {
            System.out.println(auto);
        }
    }

    @Override
    public float obterTaxaDeOcupacao() {
        return estacionamento.getTaxaDeOcupacao();
    }

    @Override
    public int obterNumeroTotalDeVagas() {
        return estacionamento.getTotalVagas();
    }

    @Override
    public int obterNumeroTotalDeAutomoveis() {
        return estacionamento.getQuantVagasOcupadas();
    }
}
