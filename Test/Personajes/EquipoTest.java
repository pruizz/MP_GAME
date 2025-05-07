package Personajes;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {

    @Test
    void getArmaActiva() {
        //Caso 1 secuencia normal
        Arma arma = new Arma();
        arma.setNombreArma("Pistola");
        Map<String,Arma> armas = new HashMap<>();
        armas.put(arma.getNombreArma(), arma);
        Equipo equipo = new Equipo();
        equipo.setArmas(armas);
        equipo.setNombreArmaActiva(arma.getNombreArma());
        assertEquals(equipo.getArmaActiva(), arma);

        // Caso 2 el arma activa no existe en el mapa de armas
        Map<String, Arma> armasInexistente = new HashMap<>();
        Arma armaInexistente = new Arma();
        armaInexistente.setNombreArma("Rifle");
        armasInexistente.put(armaInexistente.getNombreArma(), armaInexistente);
        Equipo equipoInvalido = new Equipo();
        equipoInvalido.setArmas(armasInexistente);
        equipoInvalido.setNombreArmaActiva("Espada");
        assertNull(equipoInvalido.getArmaActiva());
    }

    @Test
    void getArmaduraActiva() {
        //Caso 1 secuencia normal
        Armadura armadura = new Armadura();
        armadura.setNombreArmadura("Chaleco antibalas");
        Map<String, Armadura> armaduras = new HashMap<>();
        armaduras.put(armadura.getNombreArmadura(), armadura);
        Equipo equipo = new Equipo();
        equipo.setArmaduras(armaduras);
        equipo.setNombreArmaduraActiva(armadura.getNombreArmadura());
        assertEquals(equipo.getArmaduraActiva(), armadura);

        //Caso 2 no existe equipo
        Equipo equipoVacio = new Equipo();
        equipoVacio.setArmas(new HashMap<>());
        equipoVacio.setNombreArmaActiva("Chaleco antibalas");
        assertNull(equipoVacio.getArmaActiva());
    }
}