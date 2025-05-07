package Personajes;

import java.util.Random;

public abstract class Habilidades {


    protected String nombre;
    protected int valorAtaque;
    protected int valorDefensa;

    public String getName() {

        return this.nombre;
    }

    public int getValorAtaque() {

        return this.valorAtaque;
    }

    public int getValorDefensa() {

        return this.valorDefensa;
    }
    public void inicializate(String nombre) {
        Random random = new Random();
        this.nombre = nombre;
        this.valorAtaque = random.nextInt(3) + 1;
        this.valorDefensa = random.nextInt(3) + 1;
    }

}
