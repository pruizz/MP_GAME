package SistemaDesafios;

import Herramientas.Jugador;
import Personajes.*;
import java.util.Random;

public class Combate {

    private Jugador desafiante;
    private Jugador desafiado;
    private Jugador ganador;
    private Jugador perdedor;
    private boolean esEmpate;
    private int numRondas;
    private String combatLog;

    public String getCombatLog() {
        return combatLog;
    }
    public void setCombatLog(String combateLog) {
        this.combatLog = combateLog;
    }
    public Jugador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Jugador desafiante) {
        this.desafiante = desafiante;
    }

    public Jugador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Jugador desafiado) {
        this.desafiado = desafiado;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public boolean isEsEmpate() {
        return esEmpate;
    }

    public void setEsEmpate(boolean esEmpate) {
        this.esEmpate = esEmpate;
    }

    public void setNumRondas(int numRondas) {
        this.numRondas = numRondas;
    }

    public Jugador getGanador() {
        if (this.esEmpate) {
            return null;
        }
        else {
            return this.ganador;
        }

    }

    public void empezarCombate() {
        limpiarConsola();
        this.numRondas = 0;
        StringBuilder combateLog = new StringBuilder();
        Personaje personajeDesafiante = desafiante.getPersonaje();
        Personaje personajeDesafiado = desafiado.getPersonaje();
        inicializarRabiaSiLicantropo(personajeDesafiante);
        inicializarRabiaSiLicantropo(personajeDesafiado);
        int vidaTotalDesafiante = personajeDesafiante.getSalud() + personajeDesafiante.getEsbirros().getSaludTotal();
        int vidaTotalDesafiado = personajeDesafiado.getSalud() + personajeDesafiado.getEsbirros().getSaludTotal();
        Random random = new Random();
        String inicioCombate = "Comienza el combate entre " + desafiante.getUserName() + " y " + desafiado.getUserName() + "\n";
        System.out.println(inicioCombate);
        combateLog.append(inicioCombate);
        String vidaInicial= "Vida total de " + desafiante.getUserName() + ": " + vidaTotalDesafiante + "\n" +
                "Vida total de " + desafiado.getUserName() + ": " + vidaTotalDesafiado + "\n";

        System.out.println(vidaInicial);
        combateLog.append(vidaInicial);
        while (vidaTotalDesafiante!= 0 && vidaTotalDesafiado!=0) {
            this.numRondas++;
            String ronda = "Ronda: " + this.numRondas + "\n";
            System.out.println(ronda);
            combateLog.append(ronda);

            int potencialAtaqueDesafiante = calcularPotencial(personajeDesafiante,true);
            int potencialAtaqueDesafiado = calcularPotencial(personajeDesafiado,true);
            int potencialDefensaDesafiante = calcularPotencial(personajeDesafiante,false);
            int potencialDefensaDesafiado = calcularPotencial(personajeDesafiado,false);

            int valorAtaqueDesafiante = calcularExito(potencialAtaqueDesafiante,random);
            int valorDefensaDesafiante = calcularExito(potencialDefensaDesafiante,random);
            int valorAtaqueDesafiado = calcularExito(potencialAtaqueDesafiado,random);
            int valorDefensaDesafiado = calcularExito(potencialDefensaDesafiado,random);


            if (valorAtaqueDesafiante >= valorDefensaDesafiado) {
                vidaTotalDesafiado -= 1;
                String ataqueDesafiante = "Ataque de " + desafiante.getUserName() + " a " + desafiado.getUserName() + " y le quita 1 de vida\n";
                System.out.println(ataqueDesafiante);
                combateLog.append(ataqueDesafiante);

                aumentarRabiaSiEsLicantropo(personajeDesafiado);
                disminuirVoluntadSiEsCazador(personajeDesafiado);
            }

            if (valorAtaqueDesafiado >= valorDefensaDesafiante) {
                vidaTotalDesafiante -= 1;
                String ataqueDesafiado = "Ataque de " + desafiado.getUserName() + " a " + desafiante.getUserName() + " y le quita 1 de vida\n";
                System.out.println(ataqueDesafiado);
                combateLog.append(ataqueDesafiado);
                aumentarRabiaSiEsLicantropo(personajeDesafiante);
                disminuirVoluntadSiEsCazador(personajeDesafiante);
            }
             if (valorAtaqueDesafiante <valorDefensaDesafiado && valorAtaqueDesafiado < valorDefensaDesafiante) {
                 String nada = "Nadie ha conseguido golpear al otro en esta ronda\n";
                 System.out.println(nada);
                 combateLog.append(nada);
             }

        }
        boolean flag = false;
        if (vidaTotalDesafiante <= 0) {
            this.ganador = desafiado;
            this.perdedor = desafiante;
            String desafianteMuerto = "Has perdido el combate " + desafiante.getUserName() + "tu personaje ha muerto\n";
            combateLog.append(desafianteMuerto);
            flag = true;

        } else if (vidaTotalDesafiado <= 0 && !flag) {
            this.ganador = desafiante;
            this.perdedor = desafiado;
            String desafienteGana = "Has ganado el combate " + desafiante.getUserName() + "\n";
            combateLog.append(desafienteGana);
        }
        else{
            this.esEmpate = true;
        }
        String finalvida = "Vida final de " + desafiante.getUserName() + ": " + vidaTotalDesafiante + "\n" +
                "Vida final de " + desafiado.getUserName() + ": " + vidaTotalDesafiado + "\n";
        System.out.println(finalvida);
        combateLog.append(finalvida);

        setCombatLog(combateLog.toString());

    }

    private void limpiarConsola() {
        System.out.print("\n".repeat(30));
    }


    private void inicializarRabiaSiLicantropo(Personaje personaje) {
        if (personaje instanceof Licantropo ) {
            ((Licantropo) personaje).setRabia(0);
        }
    }

    private void disminuirVoluntadSiEsCazador(Personaje personajeDesafiante) {
        if (personajeDesafiante instanceof Cazador cazador) {
            cazador.disminuirVoluntad();

        }
    }

    private void aumentarRabiaSiEsLicantropo(Personaje personaje) {
        if (personaje instanceof Licantropo licantropo && licantropo.getRabia() < 3) {
            licantropo.setRabia(licantropo.getRabia() + 1);
        }
    }
    private int calcularExito(int potencial,Random random) {

        int numeroExitos=0;
        for (int i = 0; i < potencial; i++) {
            int numeroAleatorio = random.nextInt(6) + 1; // Entre 1 y 6
            if (numeroAleatorio == 5 || numeroAleatorio == 6) {
                numeroExitos++;
            }

        }
        return numeroExitos;
    }

    public int getNumRondas() {
        return this.numRondas;
    }

    private int calcularPotencial(Personaje personaje, boolean esAtaque) {
        int poderBase = personaje.getPoder();
        // Se obtiene el poder de ataque o defensa del arma y armadura activa
        int poderEquipos = esAtaque ?
                personaje.getEquipo().getArmaActiva().getModificadorAtaque() + personaje.getEquipo().getArmaduraActiva().getModificadorAtaque():
                personaje.getEquipo().getArmaActiva().getModificadorDefensa() + personaje.getEquipo().getArmaduraActiva().getModificadorDefensa();

        int poderTotal = poderBase + poderEquipos;

        switch (personaje) {
            case Vampiro vampiro -> {
                int valorSangre = vampiro.getPuntosSangre();
                int poderSangre = valorSangre >= 5 ? 2 : 0;
                int costeDisciplina = vampiro.getDisciplina().getCosteSangre();
                int poderDisciplina = valorSangre <= costeDisciplina ?
                        (esAtaque ?
                                vampiro.getDisciplina().getValorAtaque() :
                                vampiro.getDisciplina().getValorDefensa())
                        : 0;
                poderTotal += poderDisciplina + poderSangre;
            }
            case Licantropo licantropo -> {
                int valorRabia = licantropo.getRabia();
                int poderDon = licantropo.getDon().permiteUtilizar(valorRabia) ?
                        (esAtaque ?
                                licantropo.getDon().getValorAtaque() :
                                licantropo.getDon().getValorDefensa())
                        : 0;
                poderTotal += poderDon + valorRabia;
            }
            case Cazador cazador -> {
                int poderTalento = esAtaque ?
                        cazador.getTalento().getValorAtaque() :
                        cazador.getTalento().getValorDefensa();
                poderTotal += poderTalento + cazador.getVoluntad();
            }
            default -> {}
        }

        poderTotal+= personaje.getValorFortalezas();
        poderTotal-= personaje.getValorDebilidades();

        return poderTotal;
    }

    public Jugador getPerdedor() {
        return perdedor;
    }

    public void setPerdedor(Jugador perdedor) {
        this.perdedor = perdedor;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("Ganador: "+ this.ganador.getUserName()+"\n");
        builder.append("Perdedor: "+this.perdedor.getUserName()+"\n");
        builder.append("Número de rondas: "+this.numRondas);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o){
        if (o == null)
            return false;
        else if (o instanceof Combate){
            if (o == this)
                return true;
            else
                return this.ganador.equals(((Combate)o).getGanador()) && this.numRondas == ((Combate) o).getNumRondas();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.ganador.hashCode() + (this.numRondas*983);
    }
}


