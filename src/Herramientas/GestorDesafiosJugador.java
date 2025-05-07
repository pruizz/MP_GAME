package Herramientas;

import SistemaDesafios.Desafio;
import SistemaDesafios.PendienteAceptacion;
import SistemaDesafios.Rechazado;
import SistemaPersistencia.PersistenciaManager;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GestorDesafiosJugador {
    private List<Desafio> desafios;
    private Jugador jugador;


    public GestorDesafiosJugador(Jugador jugador) {
        this.jugador = jugador;
        this.desafios = PersistenciaManager.getInstance().getPersistencia().getUsersData().getDesafios().getDesafiosJugador(jugador.getUserName());

        if (this.desafios == null){
            PersistenciaManager.getInstance().getPersistencia().getUsersData().getDesafios().addJugador(jugador.getUserName());
            this.desafios = PersistenciaManager.getInstance().getPersistencia().getUsersData().getDesafios().getDesafiosJugador(jugador.getUserName());
        }
    }

    public GestorDesafiosJugador(){
    }

    public List<Desafio> getDesafios() {
        return desafios;
    }

    public void setDesafios(List<Desafio> desafios) {
        this.desafios = desafios;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void desafiarJugador(Jugador desafiado, int oro) {
        Desafio desafio = new Desafio(this.jugador, desafiado, oro);
        PersistenciaManager.getInstance().getPersistencia().getUsersData().getDesafios().aniadirDesafio(this.jugador.getUserName(), desafio);
        PersistenciaManager.getInstance().getPersistencia().getUsersData().getDesafios().aniadirDesafio(desafiado.getUserName(), desafio);
    }

    public void aceptarDesafio(int desafioIndex) {
        Desafio desafio = desafios.get(desafioIndex);
        if (desafio.getEstado() instanceof PendienteAceptacion){
            desafio.avanzarEstado();
        }

    }

    public void mostrarDesafiosPendientes() {
        int i = 0;
        for (Desafio desafio : this.desafios) {
            System.out.println(i);
            if (desafio.getEstado() instanceof PendienteAceptacion && desafio.getDesafiante() != this.jugador){
                System.out.println(desafio.toString());
                System.out.println("Aceptas o Rechazas:\n");
                System.out.println("1. Aceptar\n2. Rechazar");
                int subopcion = Manager.readOption(1, 2);
                if (subopcion == 1) {
                    this.aceptarDesafio(i);
                } else {
                    System.out.println("Desafío rechazado");
                    Integer oroPerdido = desafio.getOroApostado() * 10/100;
                    System.out.println("Oro perdido: " + oroPerdido);
                    desafio.setEstado(new Rechazado());
                    PriorityQueue<Jugador> ranking = PersistenciaManager.getInstance().getPersistencia().getUsersData().getRanking();
                    ranking.remove(this.jugador);
                    this.jugador.getPersonaje().setOro(this.jugador.getPersonaje().getOro() - oroPerdido);
                    ranking.add(this.jugador);
                }
            }
            i++;
        }
    }

    public boolean hasDesafiosPendientes() {
        for (Desafio d : this.desafios) {
            if (d.getEstado() instanceof PendienteAceptacion && d.getDesafiado() == this.jugador){
                return true;
            }
        }
        return false;
    }

    public int getNumDesafios(){
        return this.desafios.size();
    }

}