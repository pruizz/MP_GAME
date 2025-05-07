package Personajes;


public class Ghouls implements Esbirro{
    private String name;
    private int salud;
    private int dependencia;

    @Override
    public void initialize() {
        this.name = "Ghoul";
        this.salud = 20;
        this.dependencia = 5;
    }

    public int getDependencia() {

        return this.dependencia;
    }
    public String getName() {

        return this.name;
    }
    public int getSalud() {

        return this.salud;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setDependencia(int dependencia) {
        this.dependencia = dependencia;
    }
}