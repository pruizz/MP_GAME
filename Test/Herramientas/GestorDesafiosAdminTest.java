package Herramientas;

import SistemaDesafios.Desafio;
import SistemaDesafios.PendienteAceptacion;
import SistemaDesafios.PendienteValidacion;
import SistemaPersistencia.PersistenciaManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestorDesafiosAdminTest {

    @Test
    void validarDesafio() {
        GestorDesafiosAdmin gestor = new GestorDesafiosAdmin();
        Desafio desafio = new Desafio();
        desafio.setEstado(new PendienteValidacion());
        gestor.validarDesafio(desafio);
        boolean correct = desafio.getEstado() instanceof PendienteAceptacion;
        assertTrue(correct);
    }

    @Test
    void getDesafio() {
        GestorDesafiosAdmin gestor = new GestorDesafiosAdmin();
        ArrayList<Desafio> l = new ArrayList<>();
        gestor.setDesafios(l);
        for (int i = 0; i < 5; i++) {
            Desafio desafio = new Desafio();
            l.add(desafio);
        }
        for (int i = 4; i >=0; i--){
            assertEquals(l.get(i), gestor.getDesafio(i));
        }
    }

    @Test
    void getNumPendientesValidacion() {
        GestorDesafiosAdmin gestor = new GestorDesafiosAdmin();
        ArrayList<Desafio> l = new ArrayList<>();
        gestor.setDesafiosPendientesValidacion(l);
        Desafio desafio = new Desafio();
        desafio.setEstado(new PendienteValidacion());
        for (int i = 0; i<10000; i++){
            l.add(desafio);
        }
        int result = gestor.getNumPendientesValidacion();
        assertEquals(10000, result);

        for (int i = 0; i < 5000; i++){
            l.remove(i);
        }
        assertEquals(5000, gestor.getNumPendientesValidacion());
    }
}