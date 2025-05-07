package Personajes;

import java.util.Random;

public class Don extends Habilidades {

    private int valorRabia;

    public Don() {

    }

    @Override
    public void inicializate(String nombre) {
        super.inicializate(nombre);
        Random random = new Random();
        this.valorRabia = random.nextInt(3) + 1;
    }

    public int getValorRabia() {

        return this.valorRabia;
    }


    public boolean permiteUtilizar(int rabia) {
        //si rabia es mayor o igual al coste de la habilidad, se puede usar
        return rabia >= this.valorRabia;
    }




}