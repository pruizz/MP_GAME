package Personajes;

import SistemaPersistencia.Equipamiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmaduraTest {

    @Test
    void testClone() {
        //Caso 1 secuencia normal
        Armadura original = new Armadura();
        original.setNombreArmadura("Casco");
        original.setModificadorDefensa(3);
        original.setModificadorAtaque(5);
        Equipamiento copia = original.clone();
        assertNotSame(original,copia);
        assertTrue(copia instanceof Armadura);
        Armadura copiaArmadura = (Armadura) copia;
        assertEquals(original.getNombreArmadura(), copiaArmadura.getNombreArmadura());
        assertEquals(original.getModificadorAtaque(), copiaArmadura.getModificadorAtaque());
        assertEquals(original.getModificadorDefensa(), copiaArmadura.getModificadorDefensa());

        //Caso 2 clonar objeto vacio
        Armadura originalVacio = new Armadura();
        Equipamiento copiaVacia = originalVacio.clone();
        assertNotSame(originalVacio,copiaVacia);
        assertTrue(copiaVacia instanceof Armadura);
        Armadura copiaArmaduraVacia = (Armadura) copiaVacia;
        assertNull(copiaArmaduraVacia.getNombreArmadura());
        assertEquals(0,copiaArmaduraVacia.getModificadorAtaque());
        assertEquals(0,copiaArmaduraVacia.getModificadorDefensa());
    }
}