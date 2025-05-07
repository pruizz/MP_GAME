package SistemaDesafios;

import Herramientas.Jugador;
import SistemaPersistencia.PersistenciaManager;
import java.util.PriorityQueue;

public class Finalizado implements EstadoDesafio {


    public void avanzarEstado(Desafio desafio) {
        Jugador ganador = desafio.getCombate().getGanador();
        Jugador perdedor = desafio.getCombate().getPerdedor();
        PriorityQueue<Jugador> ranking = PersistenciaManager.getInstance().getPersistencia().getUsersData().getRanking();
        ranking.remove(ganador);
        ranking.remove(perdedor);
        ganador.getPersonaje().setOro(ganador.getPersonaje().getOro() + desafio.getOroApostado());
        perdedor.getPersonaje().setOro(perdedor.getPersonaje().getOro() - desafio.getOroApostado());
        ranking.add(perdedor);
        ranking.add(ganador);
        System.out.println("El desafío ha terminado el ganador "+ ganador.getUserName()+ " ha ganado "+desafio.getOroApostado()+ " monedas de oro");
        System.out.println("El jugador "+ perdedor.getUserName() + " ha perdido "+desafio.getOroApostado()+ " monedas de oro");
        desafio.getDesafiante().addNotificación(desafio.getCombate().getCombatLog());
    }

}