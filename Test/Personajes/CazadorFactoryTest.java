package Personajes;

import SistemaPersistencia.PersistenciaManager;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class CazadorFactoryTest {

    @Test
    void crearPersonaje() {
        String datos = "Cazador\nEspada\nGuadaña\nArmadura de cuero\nArmadura de hierro";
        ByteArrayInputStream in = new ByteArrayInputStream(datos.getBytes());
        System.setIn(in);
        CazadorFactory cazadorFactory = new CazadorFactory();
        Cazador cazador = (Cazador) cazadorFactory.crearPersonaje();
        assertNotNull(cazador);
        assertEquals("Cazador", cazador.getNombre());
        assertEquals("Espada", cazador.getEquipo().getNombreArmaActiva());
        assertEquals("Armadura de cuero", cazador.getEquipo().getNombreArmaduraActiva());
        assertEquals("Talento", cazador.getTalento().getName());
        assertEquals(3, cazador.getVoluntad());
        //VALORES SERIALIZADOS
        Cazador cazadorSerializado = (Cazador) PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Cazador");
        assertNotNull(cazadorSerializado);
        assertInstanceOf(Cazador.class, cazadorSerializado);
        assertEquals(cazadorSerializado.getSalud(), cazador.getSalud());
        assertEquals(cazadorSerializado.getPoder(), cazador.getPoder());
        assertEquals(cazadorSerializado.getOro(), cazador.getOro());
        assertEquals(cazadorSerializado.getDebilidades().getFirst().getSensibilidad(), cazador.getDebilidades().getFirst().getSensibilidad());
        assertEquals(cazadorSerializado.getFortalezas().getFirst().getEficacia(), cazador.getFortalezas().getFirst().getEficacia());
        assertEquals("Fe Quebrada", cazadorSerializado.getDebilidades().getFirst().getNombreDebilidad());
        assertEquals("Instinto Letal", cazadorSerializado.getFortalezas().getFirst().getNombreFortaleza());

        
    }
}