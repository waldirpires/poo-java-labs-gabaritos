package br.newton.poo.u3.lab3;

import java.util.ArrayList;
import java.util.List;

public class Editora {

    private String id;

    private String nome;

    private String endereco;

    private List<Revista> revistas = new ArrayList<Revista>();

    public Editora(String id, String nome, String endereco) {
        super();
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public void imprimirRevistas() {
        System.out.println("\nREVISTAS:\n");
        for (var r : revistas) {
            System.out.println(r);
            r.imprimirArtigos();
            System.out.println();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Editora [id=" + id + ", nome=" + nome + ", endereco=" + endereco + "]";
    }

    public void adicionarRevista(Revista r) {
        if (revistas.contains(r)) {
            System.out.println("INFO: editora já possui a revista.\n");

            return;
        }

        revistas.add(r);
    }

    public void removerRevista(Revista r) {
        revistas.remove(r);
    }

}
