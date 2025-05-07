package SistemaPersistencia;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameDataTest {

    @Test
    void verPersonajes() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            GameData gameData = PersistenciaManager.getInstance().getPersistencia().getGameData();
            gameData.verPersonajes();

        } finally {
            System.setOut(originalOut);
        }
        String salida = outputStream.toString().trim();
        assertEquals("Licantropo Vampiro Cazador", salida);

    }
}