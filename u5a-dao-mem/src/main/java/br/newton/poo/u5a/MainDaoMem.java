package br.newton.poo.u5a;

import java.time.LocalDate;

public class MainDaoMem {

    public static void main(String[] args) {
        Dao<Aluno> dao = new DaoAluno();

        var a = new Aluno("123456", "José Pereira", "123.456.789-01", LocalDate.of(2010, 12, 20));

        // pesquisar
        var resultado = dao.get(a.getId());
        if (resultado.isEmpty()) {
            System.out.println("GET: vazio");
        } else {
            System.out.println("GET: " + resultado.get());
        }

        // inserir
        dao.save(a);

        // pesquisar
        resultado = dao.get(a.getId());
        if (resultado.isEmpty()) {
            System.out.println("GET: vazio");
        } else {
            System.out.println("GET: " + resultado.get());
        }

        // listar
        var lista = dao.getAll();
        System.out.println("GET all: " + lista);

        // atualizar
        a.setMatricula("654321");
        a.setNome("Maria Pereira");
        dao.update(a);

        // recuperar
        resultado = dao.get(a.getId());
        if (resultado.isEmpty()) {
            System.out.println("GET: vazio");
        } else {
            System.out.println("GET: " + resultado.get());
        }

        // remover
        dao.delete(a);

        // pesquisar
        resultado = dao.get(a.getId());
        if (resultado.isEmpty()) {
            System.out.println("GET: vazio");
        } else {
            System.out.println("GET: " + resultado.get());
        }

    }

}
