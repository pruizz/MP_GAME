package Herramientas;

import SistemaDesafios.Finalizado;
import SistemaPersistencia.PersistenciaManager;
import SistemaDesafios.Desafio;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Consultas {

    public Consultas() {
    }

    public void consultarRanking() {
        PriorityQueue<Jugador> ranking = PersistenciaManager.getInstance().getPersistencia().getUsersData().getRanking();
        for (Jugador j : ranking) {
            System.out.println(j.getUserName() + " Oro: "+j.getPersonaje().getOro());
        }
    }

    public void consultarJugadores() {
        Map<String, Usuario> users = PersistenciaManager.getInstance().getPersistencia().getUsersData().getUsuarios();
        for (Usuario u : users.values()) {
            if (u instanceof Jugador){
                System.out.println(u.getUserName());
            }
        }

    }

    public void consultarDesafiosPasados(Jugador j){
        List<Desafio> l = PersistenciaManager.getInstance().getPersistencia().getUsersData().getAlmacenDesafios().getDesafiosJugador(j.getUserName());
        for (Desafio d : l){
            if (d.getEstado() instanceof Finalizado){
                System.out.println(d.toString());
            }
        }
    }
}