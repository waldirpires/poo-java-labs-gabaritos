package br.newton.poo.u3.lab3;

public class Artigo {

    private String id;

    private String autor;

    private String conteudo;

    private String data;

    public Artigo(String id, String autor, String conteudo, String data) {
        super();
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Artigo [id=" + id + ", autor=" + autor + ", conteudo=" + conteudo + ", data=" + data + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int obterTamanho() {
        return conteudo.length();
    }
}
