package Personajes;

import SistemaPersistencia.PersistenciaManager;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class VampiroFactoryTest {

    @Test
    void solicitarDatos() {
        String datos ="Fernando\nCenit\nLanza\nArmadura con pinchos\nArmadura de hierro";
        ByteArrayInputStream in = new ByteArrayInputStream(datos.getBytes());
        PersonajeFactory personajeFactory = new VampiroFactory();
        Vampiro vampiro = new Vampiro();
        personajeFactory.solicitarDatos(vampiro,new Scanner(in));
        assertEquals("Fernando", vampiro.getNombre());
        assertEquals("Cenit", vampiro.getEquipo().getNombreArmaActiva());
        assertEquals("Armadura con pinchos", vampiro.getEquipo().getNombreArmaduraActiva());
        assertInstanceOf(Vampiro.class, vampiro);

    }

    @Test
    void crearPersonaje() {
        String datos ="Fernando\nCenit\nLanza\nArmadura con pinchos\nArmadura de hierro\n135";
        ByteArrayInputStream in = new ByteArrayInputStream(datos.getBytes());
        System.setIn(in);
        VampiroFactory personajeFactory = new VampiroFactory();
        Vampiro vampiro = (Vampiro) personajeFactory.crearPersonaje();
        assertNotNull(vampiro);
        assertEquals("Fernando", vampiro.getNombre());
        assertEquals("Cenit", vampiro.getEquipo().getNombreArmaActiva());
        assertEquals("Armadura con pinchos", vampiro.getEquipo().getNombreArmaduraActiva());
        assertEquals(135, vampiro.getEdad());
        assertEquals("Disciplina", vampiro.getDisciplina().getName());
        //VALORES SERIALIZADOS
        Vampiro vamp= (Vampiro) PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Vampiro");
        assertNotNull(vamp);
        assertInstanceOf(Vampiro.class, vamp);
        assertEquals(vamp.getSalud(), vampiro.getSalud());
        assertEquals(vamp.getPoder(), vampiro.getPoder());
        assertEquals(vamp.getOro(), vampiro.getOro());
        assertEquals(vamp.getDebilidades().getFirst().getSensibilidad(), vampiro.getDebilidades().getFirst().getSensibilidad());
        assertEquals(vamp.getFortalezas().getFirst().getEficacia(), vampiro.getFortalezas().getFirst().getEficacia());
        assertEquals("El Beso del Alba", vamp.getDebilidades().getFirst().getNombreDebilidad());
        assertEquals("Voluntad de la Noche", vamp.getFortalezas().getFirst().getNombreFortaleza());

    }
}