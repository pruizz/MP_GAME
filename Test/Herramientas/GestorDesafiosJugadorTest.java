package Herramientas;

import SistemaDesafios.Desafio;
import SistemaDesafios.PendienteAceptacion;
import SistemaPersistencia.PersistenciaManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorDesafiosJugadorTest {

    @Test
    void desafiarJugador() {
    }

    @Test
    void aceptarDesafio() {
    }

    @Test
    void hasDesafiosPendientes() {
        Jugador j1 = new Jugador("J1", "prueba");
        Jugador j2 = new Jugador("J2", "prueba");
        Desafio desafio = new Desafio(j1, j2, 1000);
        desafio.setEstado(new PendienteAceptacion());
        PersistenciaManager.getInstance().getPersistencia().getUsersData().getDesafios().aniadirDesafio(j1.getUserName(), desafio);
        PersistenciaManager.getInstance().getPersistencia().getUsersData().getDesafios().aniadirDesafio(j2.getUserName(), desafio);

        GestorDesafiosJugador g1 = new GestorDesafiosJugador(j1);
        GestorDesafiosJugador g2 = new GestorDesafiosJugador(j2);
        assertEquals(false, g1.hasDesafiosPendientes());
        assertEquals(true, g2.hasDesafiosPendientes());

        

    }
}