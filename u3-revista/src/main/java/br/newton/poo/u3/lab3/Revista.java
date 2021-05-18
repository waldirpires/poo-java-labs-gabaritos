package br.newton.poo.u3.lab3;

import java.util.ArrayList;
import java.util.List;

public class Revista {

    private String id;

    private String nome;

    private List<Artigo> artigos = new ArrayList<Artigo>();

    public Revista(String id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public void adicionarArtigo(Artigo a) {
        if (artigos.contains(a)) {
            System.out.println("INFO: artigo já existe.\n");

            return;
        }

        artigos.add(a);
    }

    public void removerArtigo(Artigo a) {
        artigos.remove(a);
    }

    public void imprimirArtigos() {
        System.out.println("\nArtigos:\n");
        for (var a : artigos) {
            System.out.println(a.obterTamanho() + ": " + a);
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

    @Override
    public String toString() {
        return "Revista [id=" + id + ", nome=" + nome + ", artigos=" + this.artigos.size() + "]";
    }

}
