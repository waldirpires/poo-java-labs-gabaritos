package br.newton.poo.u5a;

import java.time.LocalDate;

public class Aluno {

    private static int SEQUENCE = 1;

    private Integer id;

    private String matricula;

    private String cpf;

    private String nome;

    private LocalDate dataDeNascimento;

    public Aluno(String matricula, String cpf, String nome, LocalDate dataDeNascimento) {
        this.id = SEQUENCE++;

        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", matricula=" + matricula + ", cpf=" + cpf + ", nome=" + nome
                + ", dataDeNascimento=" + dataDeNascimento + "]";
    }

}
