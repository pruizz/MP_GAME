package SistemaPersistencia;

import Personajes.Personaje;

import java.util.*;

public class GameData {

    private Map<String, Personaje> personajes;
    private RegistroEquipamiento equipamiento;

    public Map<String, Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Map<String, Personaje> personajes) {
        this.personajes = personajes;
    }

    public void setEquipamiento(RegistroEquipamiento equipamiento) {
        this.equipamiento = equipamiento;
    }

    public GameData() {}

    public RegistroEquipamiento getEquipamiento() {
        return equipamiento;
    }

    public Personaje getPersonaje(String key) {
        return personajes.get(key);
    }

    public void verPersonajes(){
        for (String name : personajes.keySet()) {
            System.out.print(name +" ");
        }
    }

}