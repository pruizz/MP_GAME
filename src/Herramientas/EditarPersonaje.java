package Herramientas;

import Personajes.Personaje;
import SistemaPersistencia.PersistenciaManager;

public class EditarPersonaje {

    private String tipo;

    public EditarPersonaje() {
    }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public void editarSalud(int nuevoValor) {
        Personaje personaje = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje(tipo);
        personaje.setSalud(nuevoValor);
    }

    public void editarPoder(int nuevoValor) {
        Personaje personaje = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje(tipo);
        personaje.setPoder(nuevoValor);
    }

    public void editarOroInicial(int nuevoValor) {
        Personaje personaje = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje(tipo);
        personaje.setOro(nuevoValor);
    }

    public void editarDebilidad(int nuevoValor){
        Personaje personaje = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje(tipo);
        personaje.getModificadores().getDebilidades().get(0).setSensibilidad(nuevoValor);
    }

    public void editarFortaleza(int nuevoValor){
        Personaje personaje = PersistenciaManager.getInstance().getPersistencia().getGameData().getPersonaje(tipo);
        personaje.getModificadores().getFortalezas().get(0).setEficacia(nuevoValor);
    }



}