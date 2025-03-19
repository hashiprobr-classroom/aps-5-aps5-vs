package br.edu.insper.desagil.aps5.insee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TempoTest {

    @Test
    public void constroi(){
        Tempo tempo = new Tempo("");
        assertEquals(0, tempo.getHora());
        assertEquals(0, tempo.getMinuto());
    }

    @Test
    public void naoAtualizaMenor(){
        Tempo tempo = new Tempo("");
        tempo.atualiza(-1, -1);
        assertEquals(0, tempo.getHora());
        assertEquals(0, tempo.getMinuto());
    }

    @Test
    public void atualizaMaior() {
        Tempo tempo = new Tempo("");
        tempo.atualiza(24, 60);
        assertEquals(23, tempo.getHora());
        assertEquals(59, tempo.getMinuto());
    }

    @Test
    public void atualiza() {
        Tempo tempo = new Tempo("");
        tempo.atualiza(15, 30);
        assertEquals(15, tempo.getHora());
        assertEquals(30, tempo.getMinuto());
    }

    @Test
    public void comoZero() {
        Tempo tempo = new Tempo("");
        assertEquals(0, tempo.comoInteiro());
    }

    @Test
    public void comoAgora() {
        Tempo tempo = new Tempo("");
        tempo.atualiza(15, 30);
        assertEquals(930, tempo.comoInteiro());
    }

}
