package Personajes;
import SistemaPersistencia.Equipamiento;

public class Arma implements Equipamiento {

    private String nombreArma;
    private boolean dosManos;
    private int modificadorAtaque;
    private int modificadorDefensa;

    public Arma(String nombreArma, boolean dosManos, int modificadorAtaque, int modificadorDefensa) {
        this.nombreArma = nombreArma;
        this.dosManos = dosManos;
        this.modificadorAtaque = modificadorAtaque;
        this.modificadorDefensa = modificadorDefensa;
    }

    public Arma(){}

    public String getNombreArma() {
        return nombreArma;
    }

    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }

    public boolean isDosManos() {
        return dosManos;
    }

    public void setDosManos(boolean dosManos) {
        this.dosManos = dosManos;
    }

    public int getModificadorAtaque() {
        return modificadorAtaque;
    }

    public void setModificadorAtaque(int modificadorAtaque) {
        this.modificadorAtaque = modificadorAtaque;
    }

    public int getModificadorDefensa() {
        return modificadorDefensa;
    }

    public void setModificadorDefensa(int modificadorDefensa) {
        this.modificadorDefensa = modificadorDefensa;
    }

    public boolean tieneModDefensa() {

        return this.modificadorDefensa != 0;
    }


    @Override
    public Equipamiento clone() {
        Arma newArma = new Arma();
        newArma.setNombreArma(this.nombreArma);
        newArma.setDosManos(this.dosManos);
        newArma.setModificadorAtaque(this.modificadorAtaque);
        newArma.setModificadorDefensa(this.modificadorDefensa);
        return newArma;
    }

    @Override
    public int hashCode() {
        return 983*this.nombreArma.hashCode();
    }

}