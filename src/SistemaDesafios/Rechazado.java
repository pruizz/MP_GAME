package SistemaDesafios;

public class Rechazado implements EstadoDesafio{
    @Override
    public void avanzarEstado(Desafio desafio) {
        System.out.println("Rechazado");
    }

}
