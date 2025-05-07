package SistemaDesafios;

import Herramientas.GestorEquipamiento;
import Herramientas.HerramientasDeJugador;
import Herramientas.Jugador;
import Personajes.Cazador;
import Personajes.CazadorFactory;
import Personajes.Licantropo;
import Personajes.LicantropoFactory;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class CombateTest {

    @Test
    void empezarCombate() {
        Combate combate = new Combate();
        String datos ="Licantropo\nLanza\nCuchillo\nArmadura de hierro\nArmadura de cuero";
        ByteArrayInputStream in = new ByteArrayInputStream(datos.getBytes());
        System.setIn(in);
        LicantropoFactory licantropoFactory = new LicantropoFactory();
        Licantropo lic = (Licantropo) licantropoFactory.crearPersonaje();
        Jugador jugador1 = new Jugador();
        jugador1.setUserName("Jugador1");
        HerramientasDeJugador herramientasJug = new HerramientasDeJugador();
        jugador1.setHerramientas(herramientasJug);
        herramientasJug.setGestorEquipamiento(new GestorEquipamiento());
        jugador1.setPersonaje(lic);

        String datos2 ="Cazador\nLanza\nCuchillo\nArmadura de hierro\nArmadura de cuero";
        ByteArrayInputStream in2 = new ByteArrayInputStream(datos2.getBytes());
        System.setIn(in2);
        CazadorFactory cazadorFactory = new CazadorFactory();
        Cazador cazador = (Cazador) cazadorFactory.crearPersonaje();
        Jugador jugador2 = new Jugador();
        jugador2.setUserName("Jugador2");
        jugador2.setHerramientas(herramientasJug);
        jugador2.setPersonaje(cazador);

        // Asignar los jugadores al combate
        combate.setDesafiante(jugador1);
        combate.setDesafiado(jugador2);
        for (int i = 0; i < 500; i++) {
            combate.empezarCombate();
            if (combate.isEsEmpate()){
                assertEquals(0,combate.getGanador().getPersonaje().getSalud());
                assertEquals(0,combate.getPerdedor().getPersonaje().getSalud());
            }
        }

        assertNotNull(combate.getGanador());
        assertNotNull(combate.getPerdedor());
        assertNotEquals(combate.getGanador(), combate.getPerdedor());
        assertTrue(combate.getNumRondas() > 0);
        assertNotNull(combate.getCombatLog());
        assertFalse(combate.getCombatLog().isEmpty());
    }


}