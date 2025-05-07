package Personajes;

import SistemaPersistencia.Equipamiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ArmaTest {

    @Test
    void testClone() {
        //Caso 1 secuencia normal
        Arma original = new Arma();
        original.setNombreArma("Espada Larga");
        original.setDosManos(true);
        original.setModificadorAtaque(5);
        original.setModificadorDefensa(2);
        Equipamiento copia = original.clone();
        assertNotSame(original, copia);
        assertTrue(copia instanceof Arma);
        Arma copiaArma = (Arma) copia;
        assertEquals(original.getNombreArma(), copiaArma.getNombreArma());
        assertEquals(original.isDosManos(), copiaArma.isDosManos());
        assertEquals(original.getModificadorAtaque(), copiaArma.getModificadorAtaque());
        assertEquals(original.getModificadorDefensa(), copiaArma.getModificadorDefensa());

        //Caso 2 clonar valores nulos
        Arma originalNulos = new Arma();
        originalNulos.setNombreArma(null);
        originalNulos.setDosManos(true);
        originalNulos.setModificadorAtaque(5);
        originalNulos.setModificadorDefensa(2);
        Equipamiento copiaNulos = originalNulos.clone();
        assertNotSame(originalNulos, copiaNulos);
        assertTrue(copiaNulos instanceof Arma);
        Arma copiaNulosArma = (Arma) copiaNulos;
        assertEquals(originalNulos.getNombreArma(), copiaNulosArma.getNombreArma());
        assertEquals(originalNulos.getModificadorAtaque(), copiaNulosArma.getModificadorAtaque());
        assertEquals(originalNulos.getModificadorDefensa(), copiaNulosArma.getModificadorDefensa());
        assertEquals(originalNulos.isDosManos(), copiaNulosArma.isDosManos());
    }

    @Test
    void testHashCode() {
        Arma arma = new Arma();
        arma.setNombreArma("Espada Larga");
        int expectedHash = 983 * "Espada Larga".hashCode();
        assertEquals(expectedHash, arma.hashCode());
    }

}