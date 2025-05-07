package Personajes;


import SistemaPersistencia.PersistenciaManager;

public class Licantropo extends Personaje {

    private Don don;
    private int peso;
    private int altura;
    private boolean formaBipeda;
    private int rabia;

    public Don getDon() {
        return this.don;
    }

    public void setDon(Don don) {
        this.don = don;
    }
    public int getPeso() {
        return this.peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public int getAltura() {
        return this.altura;
    }
    public void setAltura(int altura){
            this.altura = altura;
    }
    public boolean cambiarForma() {
       if(!this.formaBipeda) {
            this.formaBipeda = true;
            this.peso = 110;
            this.altura = 100; //centimetros
        } else {
            this.formaBipeda = false;
            this.peso = 90;
            this.altura = 50;
        }
        return this.formaBipeda;
    }
    public boolean getFormaBipeda() {
        return this.formaBipeda;
    }
    public void setFormaBipeda(boolean formaBipeda) {
        this.formaBipeda = formaBipeda;
    }

    public int getRabia() {
        return this.rabia;
    }
    public void setRabia(int rabia) {
        this.rabia = rabia;
    }

    @Override
    public void initializeValues() {
        this.salud = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Licantropo").getSalud();
        this.poder = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Licantropo").getPoder();
        this.oro = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Licantropo").getOro();
        this.modificadores = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Licantropo").getModificadores();


    }
}

