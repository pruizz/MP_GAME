package Herramientas;

import SistemaPersistencia.PersistenciaManager;
import SistemaPersistencia.UsersData;

import java.util.*;

public class HerramientasDeJugador extends HerramientasRol {
    private Jugador user;
    private GestorDesafiosJugador desafios;
    private GestorEquipamiento gestorEquipamiento;
    private Consultas consultas;


    public HerramientasDeJugador(Jugador jugador) {
        this.desafios = new GestorDesafiosJugador(jugador);
        this.gestorEquipamiento = new GestorEquipamiento(jugador.getPersonaje());
        this.consultas = new Consultas();
    }

    public HerramientasDeJugador() { }

    public Jugador getUser() {
        return user;
    }

    public void setUser(Jugador user) {
        this.user = user;
    }

    public void setDesafios(GestorDesafiosJugador desafios) {
        this.desafios = desafios;
    }

    public GestorEquipamiento getGestorEquipamiento() {
        return gestorEquipamiento;
    }

    public void setGestorEquipamiento(GestorEquipamiento gestorEquipamiento) {
        this.gestorEquipamiento = gestorEquipamiento;
    }

    public Consultas getConsultas() {
        return consultas;
    }

    public void setConsultas(Consultas consultas) {
        this.consultas = consultas;
    }

    @Override
    public void show(){
        System.out.println("1: Gestionar desafíos"+"\n"+"2: Gestionar equipamiento"+"\n"+"3: Consultas\n4: Salir");
    }

    public GestorDesafiosJugador getDesafios() {
        return this.desafios;
    }

    public void eliminarCuenta() {
        System.out.println("Para eliminar su cuenta introduzca su contraseña:");
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();
        if (!pass.equals(this.user.getPassword())){
            System.out.println("Contraseña incorrecta no se puedo eliminar la cuenta");
            return;
        }
        UsersData u = PersistenciaManager.getInstance().getPersistencia().getUsersData();
        u.getPersonajesJugadores().remove(this.user);
        u.getUsuarios().remove(this.user.getUserName());
        u.getAlmacenDesafios().getDesafios().remove(this.user);
        System.out.println("Cuenta eliminada con éxito");
    }

    public void verDesafiosPendientes(){
        this.desafios.mostrarDesafiosPendientes();
        System.out.println("Si quiere aceptar un desafio introduzca su índice, si no pulse cualquier otra tecla:");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.nextLine();
        try {
            int opIndex = Integer.parseInt(opcion);
            this.desafios.aceptarDesafio(opIndex);
        } catch (NumberFormatException e) {
            System.out.println("Ningún desafío aceptado");
        }
    }

    public void consultarCombates() {

    }

}