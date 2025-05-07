package Personajes;
import java.util.*;

public class Equipo {

    public Equipo() { }

    private Map<String, Arma> armas;
    private Map<String, Armadura> armaduras;
    private String nombreArmaActiva;
    private String nombreArmaduraActiva;

    public void setNombreArmaActiva(String name) {
        this.nombreArmaActiva = name;
    }

    public void setNombreArmaduraActiva(String name) {
        this.nombreArmaduraActiva = name;
    }

    public String getNombreArmaActiva() {
        return nombreArmaActiva;
    }

    public String getNombreArmaduraActiva() {
        return nombreArmaduraActiva;
    }

    public void setArmas(Map<String, Arma> armas) {
        this.armas = armas;
    }

    public void setArmaduras(Map<String, Armadura> armaduras) {
        this.armaduras = armaduras;
    }

    public Map<String, Armadura> getArmaduras() {

        return this.armaduras;
    }

    public Map<String, Arma> getArmas() {
        return this.armas;
    }

    public void aniadirArma(String name, Arma arma) {
        this.armas.put(name, arma);
    }

    public void aniadirArmadura(String name, Armadura armadura) {

        this.armaduras.put(name, armadura);
    }
    public Arma getArmaActiva() {
        return this.armas.get(this.nombreArmaActiva);
    }
    public Armadura getArmaduraActiva() {
        return this.armaduras.get(this.nombreArmaduraActiva);
    }

}