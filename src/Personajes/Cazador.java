package Personajes;


import SistemaPersistencia.PersistenciaManager;

public class Cazador extends Personaje {
    private int voluntad;
    private Talento talento;

    public Talento getTalento() {

        return this.talento;
    }
    public void setTalento(Talento talento) {

        this.talento = talento;
    }
    public int getVoluntad() {

        return this.voluntad;
    }

    public void disminuirVoluntad() {
        if (this.voluntad> 0) {
            this.voluntad -= 1;
        }
        ;
    }
    public void setVoluntad(int voluntad) {

        this.voluntad = voluntad;
    }


    @Override
    public void initializeValues() {
        this.salud = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Cazador").getSalud();
        this.poder = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Cazador").getPoder();
        this.modificadores = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Cazador").getModificadores();
        this.oro = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Cazador").getOro();
    }
}