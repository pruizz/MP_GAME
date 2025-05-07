package Personajes;


public class Debilidad {

    private String nombreDebilidad;
    private int sensibilidad;


    public Debilidad() {

    }

    public void initialize(String nombre, int v) {
        this.nombreDebilidad= nombre;
        this.sensibilidad = v;
    }

    public String getNombreDebilidad() {
        return nombreDebilidad;
    }

    public void setNombreDebilidad(String nombreDebilidad) {
        this.nombreDebilidad = nombreDebilidad;
    }

    public void setSensibilidad(int sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public int getSensibilidad() {
        return this.sensibilidad;
    }


}