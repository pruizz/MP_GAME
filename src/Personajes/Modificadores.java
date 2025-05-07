package Personajes;
import java.util.*;

public class Modificadores {

    public Modificadores(ArrayList<Debilidad> d, ArrayList<Fortaleza> f) {
        this.debilidades= d;
        this.fortalezas= f;
    }

    private List<Debilidad> debilidades;
    private List<Fortaleza> fortalezas;

    public Modificadores() { }

    public List<Debilidad> getDebilidades() {
        return this.debilidades;
    }

    public List<Fortaleza> getFortalezas() {
        return this.fortalezas;
    }

    public void setDebilidades(List<Debilidad> debilidades) {
        this.debilidades = debilidades;
    }

    public void setFortalezas(List<Fortaleza> fortalezas) {
        this.fortalezas = fortalezas;
    }

    public void aniadirFortaleza(String nombre, int value) {
        Fortaleza fortaleza= new Fortaleza();
        fortaleza.initialize(nombre, value);
        this.fortalezas.add(fortaleza);
    }

    public void aniadirDebilidad(String nombre, int value) {
        Debilidad debilidad= new Debilidad();
        debilidad.initialize(nombre, value);
        this.debilidades.add(debilidad);
    }

}