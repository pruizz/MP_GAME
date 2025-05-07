package SistemaPersistencia;

import Herramientas.Jugador;
import Herramientas.Usuario;
import Personajes.Cazador;
import Personajes.Personaje;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
class UsersDataTest {

    @Test
    void addNewUser() {
        Jugador j = new Jugador("Jugador1", "Jugador1");
        Personaje personaje = new Cazador();
        j.setPersonaje(personaje);

        UsersData usersData = PersistenciaManager.getInstance().getPersistencia().getUsersData();
        usersData.addNewUser(j);

        Personaje result = usersData.getPersonajeUsuario(j);
        assertNotNull(result);
        Usuario result2 = usersData.getUsuarioByNick("Jugador1");
        assertNotNull(result2);
    }

    @Test
    void mostrarJugadores() {
        Jugador j = new Jugador("Jugador2", "Jugador2");
        Personaje personaje = new Cazador();
        j.setPersonaje(personaje);

        UsersData usersData = PersistenciaManager.getInstance().getPersistencia().getUsersData();
        usersData.addNewUser(j);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            usersData.mostrarJugadores();

        } finally {
            System.setOut(originalOut);
        }
        String salida = outputStream.toString().trim();
        boolean result = salida.contains("Jugador2");
        assertTrue(result);
    }

    @Test
    void mostrarJugadoresNoAdmin() {
        UsersData usersData = PersistenciaManager.getInstance().getPersistencia().getUsersData();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            usersData.mostrarJugadores();

        } finally {
            System.setOut(originalOut);
        }
        String salida = outputStream.toString().trim();
        boolean result = salida.contains("Admin");
        assertFalse(result);
    }

    @Test
    void mostrarBloqueados() {
        Jugador j = new Jugador("Jugador3", "Jugador3");
        Personaje personaje = new Cazador();
        j.setPersonaje(personaje);
        j.setBlock(true);

        UsersData usersData = PersistenciaManager.getInstance().getPersistencia().getUsersData();
        usersData.addNewUser(j);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            usersData.mostrarBloqueados();

        } finally {
            System.setOut(originalOut);
        }
        String salida = outputStream.toString().trim();
        boolean result = salida.contains("Jugador3");
        assertTrue(result);

    }

    @Test
    void mostrarBloqueadosFalse() {
        Jugador j = new Jugador("Jugador4", "Jugador4");
        Personaje personaje = new Cazador();
        j.setPersonaje(personaje);
        j.setBlock(false);

        UsersData usersData = PersistenciaManager.getInstance().getPersistencia().getUsersData();
        usersData.addNewUser(j);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            usersData.mostrarBloqueados();

        } finally {
            System.setOut(originalOut);
        }
        String salida = outputStream.toString().trim();
        boolean result = salida.contains("Jugador4");
        assertFalse(result);

    }
}