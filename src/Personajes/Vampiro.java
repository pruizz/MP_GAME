package Personajes;

import SistemaPersistencia.PersistenciaManager;

public class Vampiro extends Personaje {

    private int puntosSangre;
    private Disciplina disciplina;
    private int edad;

    public Vampiro() {

    }
    public int getPuntosSangre() {
        return this.puntosSangre;
    }
    public void setPuntosSangre(int sangre) {

        this.puntosSangre = sangre;
    }
    public Disciplina getDisciplina() {

        return this.disciplina;
    }
    public int getEdad() {

        return this.edad;
    }
    public void setEdad(int edad) {

        this.edad = edad;
    }
    public void setDisciplina(Disciplina disciplina) {

        this.disciplina = disciplina;
    }

    @Override
    public void initializeValues() {
        this.salud = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Vampiro").getSalud();
        this.poder = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Vampiro").getPoder();
        this.modificadores = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Vampiro").getModificadores();
        this.oro = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje("Vampiro").getOro();



    }
}