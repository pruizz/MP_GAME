package Personajes;

import SistemaPersistencia.Equipamiento;

public class Armadura implements Equipamiento {

    private String nombreArmadura;
    private int modificadorDefensa = 0;
    private int modificadorAtaque = 0;

    public Armadura(String name, int ataque, int defensa) {
        nombreArmadura = name;
        modificadorDefensa = defensa;
        modificadorAtaque = ataque;
    }

    public Armadura() { }

    public String getNombreArmadura() {
        return nombreArmadura;
    }

    public void setNombreArmadura(String nombreArmadura) {
        this.nombreArmadura = nombreArmadura;
    }

    public int getModificadorDefensa() {
        return modificadorDefensa;
    }

    public void setModificadorDefensa(int modificadorDefensa) {
        this.modificadorDefensa = modificadorDefensa;
    }

    public int getModificadorAtaque() {
        return modificadorAtaque;
    }

    public void setModificadorAtaque(int modificadorAtaque) {
        this.modificadorAtaque = modificadorAtaque;
    }

    public boolean tieneModAtaque() {
        return this.modificadorAtaque != 0;
    }


    @Override
    public Equipamiento clone() {
        Armadura newArmadura = new Armadura();
        newArmadura.setNombreArmadura(this.nombreArmadura);
        newArmadura.setModificadorDefensa(this.modificadorDefensa);
        newArmadura.setModificadorAtaque(this.modificadorAtaque);

        return newArmadura;
    }

}