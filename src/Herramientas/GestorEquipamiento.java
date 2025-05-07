package Herramientas;

import Personajes.Arma;
import Personajes.Armadura;
import Personajes.Personaje;

import java.util.Map;
import java.util.Scanner;

public class GestorEquipamiento {
    private Personaje personaje;

    public GestorEquipamiento(Personaje personaje) {
        this.personaje = personaje;
    }

    public GestorEquipamiento(){ }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }



    public void elegirArmaActiva() {
        Map<String, Arma> l = this.personaje.getEquipo().getArmas();
        for (String n : l.keySet()){
            System.out.print(n + " ");
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige el arma para tu personaje:");
        String nombre = sc.nextLine();
        if (!l.containsKey(nombre)){
            System.out.println("No dispones del arma "+nombre);
            return;
        }
        this.personaje.getEquipo().setNombreArmaActiva(nombre);
    }


    public void elegirArmadura() {
        Map<String, Armadura> l = this.personaje.getEquipo().getArmaduras();
        for (String n : l.keySet()){
            System.out.print(n + " ");
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige el armadura para tu personaje:");
        String nombre = sc.nextLine();
        if (!l.containsKey(nombre)){
            System.out.println("No dispones de la armadura "+nombre);
            return;
        }
        this.personaje.getEquipo().setNombreArmaduraActiva(nombre);
    }

}