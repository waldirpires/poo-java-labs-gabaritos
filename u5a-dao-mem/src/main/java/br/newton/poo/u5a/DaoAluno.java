package br.newton.poo.u5a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DaoAluno implements Dao<Aluno> {

    private List<Aluno> alunos = new ArrayList<>();

    public Optional<Aluno> get(Integer id) {
        for (var a : alunos) {
            if (a.getId().equals(id)) {
                return Optional.of(a);
            }
        }

        return Optional.empty();
    }

    public List<Aluno> getAll() {
        return Collections.unmodifiableList(alunos);
    }

    public Aluno save(Aluno a) {
        this.alunos.add(a);

        return a;
    }

    public Aluno update(Aluno a) {
        var exists = get(a.getId());

        if (exists.isEmpty()) {
            return null;
        }

        this.alunos.remove(exists.get());
        this.alunos.add(a);

        return a;
    }

    public void delete(Aluno a) {
        var exists = get(a.getId());

        if (exists.isPresent()) {
            this.alunos.remove(a);
        }
    }
}
