package Personajes;


public class Humanos implements Esbirro{

    private String lealtad;
    private String name;
    private int salud;

    public Humanos(){ }

    @Override
    public void initialize() {
        this.lealtad = "Muy leal";
        this.salud = 20;
        this.name = "Humano";
    }

    public String getLealtad() {

        return this.lealtad;
    }

    public String getName() {

        return this.name;
    }
    public int getSalud() {

        return this.salud;
    }

    public void setLealtad(String lealtad) {
        this.lealtad = lealtad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
}