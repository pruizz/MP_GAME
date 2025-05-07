package SistemaDesafios;


public class PendienteValidacion implements EstadoDesafio {

    public PendienteValidacion() {
    }

    @Override
    public void avanzarEstado(Desafio desafio) {
        desafio.setEstado(new PendienteAceptacion());
        desafio.setValidado(true);
    }


}