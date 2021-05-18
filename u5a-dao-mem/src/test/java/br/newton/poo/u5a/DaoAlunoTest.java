package br.newton.poo.u5a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DaoAlunoTest {

    private Dao<Aluno> unit;

    private Aluno a;

    @BeforeEach
    void setUp() throws Exception {
        unit = new DaoAluno();
        a = new Aluno("123456", "José Pereira", "123.456.789-01", LocalDate.of(2010, 12, 20));
    }

    @Test
    void testGet_empty() {
        // when
        var result = unit.get(1);

        // then
        assertEquals(Optional.empty(), result);
    }

    @Test
    void testGet_withValue() {
        // given:
        unit.save(a);

        // when
        var result = unit.get(a.getId());

        // then
        assertEquals(Optional.of(a), result);
    }

    @Test
    void testGetAll() {
        // given:
        unit.save(a);

        // when
        var result = unit.getAll();

        // then
        assertEquals(Arrays.asList(a), result);
    }

    @Test
    void testSave() {
        // when
        unit.save(a);

        // then
        assertEquals(a, unit.get(a.getId()).get());
    }

    @Test
    void testUpdate_notExists() {
        // when
        var result = unit.update(a);

        // then
        assertNull(result);
    }

    @Test
    void testUpdate_exists() {
        // given:
        unit.save(a);

        a.setNome("João Guilherme");

        // when
        var result = unit.update(a);

        // then
        assertEquals(a, result);
    }

    @Test
    void testDelete_exists() {
        // given:
        unit.save(a);

        // when
        unit.delete(a);

        // then
        assertTrue(unit.get(a.getId()).isEmpty());
    }

    @Test
    void testDelete_notExists() {
        // when
        unit.delete(a);

        // then
        assertTrue(unit.getAll().isEmpty());
    }

}
