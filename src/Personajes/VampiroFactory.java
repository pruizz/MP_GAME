package Personajes;


import java.util.Random;
import java.util.Scanner;

public class VampiroFactory extends PersonajeFactory {

    public Personaje crearPersonaje() {
        Scanner scanner = new Scanner(System.in);
        Vampiro vampiro = new Vampiro();
        vampiro.initializeValues();
        solicitarDatos(vampiro, scanner);
        boolean entradaValida = false;
        int valorEdad = 0;
        while (!entradaValida) {
            System.out.print("Introduce la edad de tu vampiro: ");
            String linea = scanner.nextLine();

            try {
                valorEdad = Integer.parseInt(linea); // intenta convertirlo
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número. Inténtalo otra vez.");
            }
        }
        vampiro.setEdad(valorEdad);
        System.out.println("Como has seleccionado un vampiro, dispondrás de la habilidad especial: Disciplina");
        Disciplina disciplina = new Disciplina();
        disciplina.inicializate("Disciplina");
        vampiro.setDisciplina(disciplina);
        System.out.println("Tu vampiro tendrá un valor de Sangre, el cual se utilizará para activar sus disciplinas.");
        Random random = new Random();
        int sangre = random.nextInt(10)+1;
        vampiro.setPuntosSangre(sangre);
        System.out.println("El vampiro tiene la debilidad: El Beso del Alba y la fortaleza: Voluntad de la Noche");


        return vampiro;
    }


}