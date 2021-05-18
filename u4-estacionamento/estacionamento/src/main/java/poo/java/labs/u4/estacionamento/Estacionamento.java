package poo.java.labs.u4.estacionamento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private String nome;

    private int totalVagas;

    private float valorHora;

    private List<Automovel> automoveis;

    public Estacionamento(String nome, int totalVagas, float valorHora) {
        this.nome = nome;
        this.totalVagas = totalVagas;
        this.valorHora = valorHora;

        this.automoveis = new ArrayList<>();
    }

    public Automovel pesquisarPorAutomovel(String placa) {
        for (var a : automoveis) {
            if (a.getPlaca().equalsIgnoreCase(placa)) {
                return a;
            }
        }

        return null;
    }

    public Automovel cadastrarEntrada(String placa) {
        var a = pesquisarPorAutomovel(placa);
        // verificar se já existe um automovel estacionado com a mesma placa
        if (a != null && a.getSaida() == null) {
            System.out.println("ALERTA: placa já existe dentro do estacionamento.\n");

            return null;
        }

        // verificar se há vagas disponíveis
        if (getQuantVagasDisponiveis() == 0) {
            System.out.println("ALERTA: não há vagas disponíveis no estacionamento.\n");

            return null;
        }

        a = new Automovel(placa);

        this.automoveis.add(a);

        return a;
    }

    public Automovel cadastrarSaida(String placa, LocalDateTime saida) {
        // verificar se a placa existe
        var a = pesquisarPorAutomovel(placa);
        if (a == null) {
            System.out.println("ALERTA: placa não existe.\n");

            return null;
        }

        a.calcularSaida(this.valorHora, saida);

        return a;
    }

    public int getQuantVagasDisponiveis() {
        return totalVagas - automoveis.size();
    }

    public int getQuantVagasOcupadas() {
        return automoveis.size();
    }

    public float getTaxaDeOcupacao() {
        return automoveis.size() / (totalVagas * 1.0f);
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public String getNome() {
        return nome;
    }

    public int getTotalVagas() {
        return totalVagas;
    }
}
