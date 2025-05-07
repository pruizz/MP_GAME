package Personajes;

import java.util.Scanner;

public class LicantropoFactory extends PersonajeFactory {

    public Personaje crearPersonaje() {
        Scanner scanner = new Scanner(System.in);
        Licantropo licantropo = new Licantropo();
        licantropo.initializeValues();
        solicitarDatos(licantropo, scanner);
        licantropo.setRabia(0);
        licantropo.setPeso(90);
        licantropo.setAltura(50);
        System.out.println("Como has seleccionado un licantropo, tendras la habilidad especial: Don");
        Don don = new Don();
        don.inicializate("Don");
        licantropo.setDon(don);
        licantropo.setFormaBipeda(false);
        System.out.println("Tu licantropo podra cambiar de forma aumentando su peso y altura");
        System.out.println("El licantropo tiene la debilidad: Lazo Lunar y la fortaleza: Furia Primigenia");

        return licantropo;
    }

}