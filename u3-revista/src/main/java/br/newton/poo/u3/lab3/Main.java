package br.newton.poo.u3.lab3;

public class Main {

    public static void main(String[] args) {
        var a = new Artigo("b1fc7004-74f5-423e-b2eb-cc5b3f3fe73b", "Albert Einstein", "The Theory of Relavivity",
                "01/02/1903");
        var a2 = new Artigo("b5a9e2d4-9e55-4dbe-ab77-848abd03af55", "Albert Einstein", "Black holes", "01/02/1912");

        var r = new Revista("5e4a04ea-dff8-48b0-947d-22a36756cc62", "Physics");
        r.adicionarArtigo(a);
        r.adicionarArtigo(a2);

        var e = new Editora("5d2e8e32-df10-494d-9721-a61410fa7466", "Thompson", "www.thompson.com");
        e.adicionarRevista(r);

        e.imprimirRevistas();
    }
}
