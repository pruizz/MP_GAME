package Herramientas;

import Personajes.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GestorEquipamientoTest {

    @Test
    void elegirArmaActiva() {
        //Caso 1 secuencia normal
        Cazador cazador = new Cazador();
        Equipo equipo = new Equipo();
        Arma arma = new Arma();
        arma.setNombreArma("Espada");
        arma.setDosManos(true);
        arma.setModificadorAtaque(5);
        arma.setModificadorDefensa(5);
        Map<String,Arma> armas = new HashMap<>();
        armas.put("Espada", arma);
        equipo.setArmas(armas);
        equipo.setNombreArmaActiva("Espada");
        cazador.setEquipo(equipo);
        GestorEquipamiento gestor = new GestorEquipamiento();
        gestor.setPersonaje(cazador);
        String datos = "Espada";
        ByteArrayInputStream in = new ByteArrayInputStream(datos.getBytes());
        System.setIn(in);
        gestor.elegirArmaActiva();
        assertEquals("Espada",cazador.getEquipo().getNombreArmaActiva());

        //Caso 2 no hay armas en el equipo
        Cazador cazadorSinArma = new Cazador();
        Equipo equipoVacio = new Equipo();
        equipoVacio.setArmas(new HashMap<>());
        equipoVacio.setNombreArmaActiva(null);
        cazadorSinArma.setEquipo(equipoVacio);
        GestorEquipamiento gestor2 = new GestorEquipamiento();
        gestor2.setPersonaje(cazadorSinArma);
        String datosVacio = "Espada";
        ByteArrayInputStream inVacio = new ByteArrayInputStream(datosVacio.getBytes());
        System.setIn(inVacio);
        assertNull(cazadorSinArma.getEquipo().getNombreArmaActiva());
    }

    @Test
    void elegirArmadura() {
        Vampiro vampiro = new Vampiro();
        Equipo equipo = new Equipo();
        Armadura armadura = new Armadura();
        armadura.setNombreArmadura("Casco");
        armadura.setModificadorDefensa(5);
        armadura.setModificadorAtaque(5);
        Map<String,Armadura> armaduras = new HashMap<>();
        armaduras.put("Casco", armadura);
        equipo.setArmaduras(armaduras);
        equipo.setNombreArmaduraActiva("Casco");
        vampiro.setEquipo(equipo);
        String datos = "Casco";
        ByteArrayInputStream in = new ByteArrayInputStream(datos.getBytes());
        System.setIn(in);
        GestorEquipamiento gestor = new GestorEquipamiento();
        gestor.setPersonaje(vampiro);
        gestor.elegirArmadura();
        assertEquals("Casco",vampiro.getEquipo().getNombreArmaduraActiva());
    }
}