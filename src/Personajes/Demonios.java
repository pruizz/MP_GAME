package Personajes;

import java.util.ArrayList;

public class Demonios implements Esbirro {
    private String nombre;
    private int salud;
    private String pacto;
    private AlmacenEsbirros esbirros;

    public Demonios(){ }

    @Override
    public void initialize(){
        this.nombre = "Demonio";
        this.salud = 20;
        this.esbirros = new AlmacenEsbirros(new ArrayList<Esbirro>());
        this.pacto = "Pacto";
    }


    public String getPacto() {
        return this.pacto;
    }
    public String getName() {
        return this.nombre;
    }
    public int getSalud() {
        return this.salud;
    }
    public AlmacenEsbirros getEsbirros() {
        return this.esbirros;
    }
    public void setPacto(String pacto) {
        this.pacto = pacto;
    }
    public void setEsbirros(AlmacenEsbirros esbirros) {
        this.esbirros = esbirros;
    }


}