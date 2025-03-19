package br.edu.insper.desagil.aps5.insee;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class AgendaTest {

    @Test
    public void constroi() {
        Agenda agenda = new Agenda();
        assertTrue(agenda.getEventos().isEmpty());
    }

    @Test
    public void adicionaValido() {
        Agenda agenda = new Agenda();

        Data dataInicio = new Data("");
        dataInicio.atualiza(26, 9, 2024);
        Tempo tempoInicio = new Tempo("");
        tempoInicio.atualiza(15, 30);
        DataTempo dtInicio = new DataTempo("", dataInicio, tempoInicio);

        Data dataFim = new Data("");
        dataFim.atualiza(2024, 9, 27);
        Tempo tempoFim = new Tempo("");
        tempoFim.atualiza(10, 0);
        DataTempo dtFim = new DataTempo("", dataFim, tempoFim);

        Evento evento = new Evento(dtInicio, dtFim);
        agenda.adiciona(evento);

        List<Evento> eventos = agenda.getEventos();
        assertEquals(1, eventos.size());
        assertSame(evento, eventos.get(0));
    }

    @Test
    public void adicionaInvalido() {
        Agenda agenda = new Agenda();

        Data dataInicio = new Data("");
        dataInicio.atualiza(2024, 9, 26);
        Tempo tempoInicio = new Tempo("");
        tempoInicio.atualiza(15, 30);
        DataTempo dtInicio = new DataTempo("", dataInicio, tempoInicio);

        Data dataFim = new Data("");
        dataFim.atualiza(2024, 9, 26);
        Tempo tempoFim = new Tempo("");
        tempoFim.atualiza(15, 30);
        DataTempo dtFim = new DataTempo("", dataFim, tempoFim);

        Evento eventoInvalido = new Evento(dtInicio, dtFim);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            agenda.adiciona(eventoInvalido);
        });

        assertEquals("Evento invalido!", ex.getMessage());
    }

}
