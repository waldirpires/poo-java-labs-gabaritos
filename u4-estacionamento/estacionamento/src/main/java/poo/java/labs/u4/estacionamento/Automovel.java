package poo.java.labs.u4.estacionamento;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class Automovel {

    private String placa;

    private LocalDateTime entrada;

    private LocalDateTime saida;

    private float tempoDePermanencia; // h

    private float valorTotal;

    /**
     * @param placa
     */
    public Automovel(String placa) {
        this.placa = placa;
        this.entrada = LocalDateTime.now();
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public float calcularSaida(float valorHora, LocalDateTime saida) {
        this.saida = saida;

        var diff = this.saida.toEpochSecond(ZoneOffset.UTC) - this.entrada.toEpochSecond(ZoneOffset.UTC);

        diff = diff / (3600); // segundos em uma hora

        this.tempoDePermanencia = ChronoUnit.SECONDS.between(entrada, saida) / (3600.0f);

        this.valorTotal = this.tempoDePermanencia * valorHora;

        return this.valorTotal;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Automovel [placa=" + placa + ", entrada=" + entrada + ", saida=" + saida + ", tempoDePermanencia="
                + tempoDePermanencia + String.format(", valorTotal= R$ %5.2f", +valorTotal) + "]";
    }

}
