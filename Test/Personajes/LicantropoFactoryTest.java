package Personajes;

import SistemaPersistencia.PersistenciaManager;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class LicantropoFactoryTest {

    @Test
    void crearPersonaje() {
        String datos ="Licantropo\nLanza\nCuchillo\nArmadura de hierro\nArmadura de cuero";
        ByteArrayInputStream in = new ByteArrayInputStream(datos.getBytes());
        System.setIn(in);
        LicantropoFactory licantropoFactory = new LicantropoFactory();
        Licantropo lic = (Licantropo) licantropoFactory.crearPersonaje();
        assertNotNull(lic);
        assertEquals("Licantropo", lic.getNombre());
        assertEquals("Lanza", lic.getEquipo().getNombreArmaActiva());
        assertEquals("Armadura de hierro", lic.getEquipo().getNombreArmaduraActiva());
        assertEquals(90, lic.getPeso());
        assertEquals(50, lic.getAltura());
        assertEquals(0, lic.getRabia());
        assertEquals("Don", lic.getDon().getName());
        assertFalse(lic.getFormaBipeda());

        //VALORES SERIALIZADOS
        Licantropo licantropo= (Licantropo) PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Licantropo");
        assertNotNull(licantropo);
        assertInstanceOf(Licantropo.class, licantropo);
        assertEquals(licantropo.getSalud(), lic.getSalud());
        assertEquals(licantropo.getPoder(), lic.getPoder());
        assertEquals(licantropo.getOro(), lic.getOro());
        assertEquals(licantropo.getDebilidades().getFirst().getSensibilidad(), lic.getDebilidades().getFirst().getSensibilidad());
        assertEquals(licantropo.getFortalezas().getFirst().getEficacia(), lic.getFortalezas().getFirst().getEficacia());
        assertEquals("Lazo Lunar", licantropo.getDebilidades().getFirst().getNombreDebilidad());
        assertEquals("Furia Primigenia", licantropo.getFortalezas().getFirst().getNombreFortaleza());






    }
}