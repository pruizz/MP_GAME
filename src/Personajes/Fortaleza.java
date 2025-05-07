package Personajes;

public class Fortaleza {
    private String nombreFortaleza;
    private int eficacia;

    public Fortaleza() {

    }
    public void initialize(String nombre, int v){
        this.eficacia = v;
        this.nombreFortaleza = nombre;
    }

    public String getNombreFortaleza() {
        return nombreFortaleza;
    }

    public void setNombreFortaleza(String nombreFortaleza) {
        this.nombreFortaleza = nombreFortaleza;
    }

    public int getEficacia() {
        return eficacia;
    }

    public void setEficacia(int eficacia) {
        this.eficacia = eficacia;
    }

    public int getEfiacia() {
        return this.eficacia;
    }

    public String getNombre() {
        return this.nombreFortaleza;
    }

}