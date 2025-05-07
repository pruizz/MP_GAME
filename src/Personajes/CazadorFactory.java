package Personajes;


import java.util.Scanner;

public class CazadorFactory extends PersonajeFactory {

    // Este metodo crea un objeto de tipo Cazador
    public Personaje crearPersonaje() {
        Scanner scanner = new Scanner(System.in);
        Cazador cazador = new Cazador();
        cazador.initializeValues();
        solicitarDatos(cazador,scanner);
        System.out.println("Tu cazador tendrá un valor de Voluntad, el cual se reducirá cada vez que reciba daño.");
        cazador.setVoluntad(3);
        System.out.println("Como has seleccionado un cazador, dispondrás de la habilidad especial: Talento.");
        Talento talento = new Talento();
        talento.inicializate("Talento");
        cazador.setTalento(talento);
        System.out.println("El cazador tiene la debilidad: Fe Quebrada y la fortaleza: Instinto Letal");
        return cazador;
    }
}