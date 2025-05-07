package Personajes;
import java.util.*;

public class Disciplina extends Habilidades {

    private int costeSangre;

    public Disciplina() {

    }

    @Override
    public void inicializate(String nombre) {
        super.inicializate(nombre);
        Random random = new Random();
        this.costeSangre = random.nextInt(3) + 1;
    }

    public int getCosteSangre() {
        return this.costeSangre;
    }
}