package Herramientas;

import Personajes.Arma;
import Personajes.Armadura;
import SistemaPersistencia.PersistenciaManager;
import SistemaPersistencia.RegistroEquipamiento;

import java.util.*;

public class HerramientasDeAdministrador extends HerramientasRol {

    private EditarPersonaje editorPersonajes;
    private GestorDesafiosAdmin desafios;

    public HerramientasDeAdministrador() {
    }

    public EditarPersonaje getEditorPersonajes() {
        if (editorPersonajes == null) {
            editorPersonajes = new EditarPersonaje();
        }
        return editorPersonajes;
    }

    public void setEditorPersonajes(EditarPersonaje editorPersonajes) {
        this.editorPersonajes = editorPersonajes;
    }

    public void setDesafios(GestorDesafiosAdmin desafios) {
        this.desafios = desafios;
    }

    public void crearArmadura() {
        Scanner sc = new Scanner(System.in);
        int modificadorAtaque;
        int modificadorDefensa;
        System.out.print("Introduce el nombre de la armadura: ");
        String nombreArmadura = sc.nextLine();
        do {
            System.out.print("Introduce el modificador de ataque (1-3): ");
            try {
                modificadorAtaque = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                modificadorAtaque = -1;
            }
        } while (modificadorAtaque < 1 || modificadorAtaque > 3);
        do {
            System.out.print("Introduce el modificador de defensa (1-3): ");
            try {
                modificadorDefensa = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                modificadorDefensa = -1;
            }
        } while (modificadorDefensa < 1 || modificadorDefensa > 3);
        Armadura nuevaArmadura = new Armadura(nombreArmadura,modificadorAtaque,modificadorDefensa);
        PersistenciaManager p = PersistenciaManager.getInstance();
        RegistroEquipamiento equipamiento = p.getPersistencia().getGameData().getEquipamiento();
        equipamiento.addEquipment(nombreArmadura,nuevaArmadura);
    }

    public void crearArma() {
        Scanner sc = new Scanner(System.in);
        int modificadorAtaque;
        int modificadorDefensa;
        String input;
        System.out.print("Introduce el nombre del arma: ");
        String nombreArma = sc.nextLine();
        do {
            System.out.print("¿Es un arma de dos manos? (true/false): ");
            input = sc.nextLine().toLowerCase();    //por si pone alguna letra en mayusculas
        } while (!input.equals("true") && !input.equals("false"));
        boolean dosManos = Boolean.parseBoolean(input);
        do {
            System.out.print("Introduce el modificador de ataque (1-3): ");
            try {
                modificadorAtaque = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                modificadorAtaque = -1;
            }
        } while (modificadorAtaque < 1 || modificadorAtaque > 3);
        do {
            System.out.print("Introduce el modificador de defensa (1-3): ");
            try {
                modificadorDefensa = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                modificadorDefensa = -1;
            }
        } while (modificadorDefensa < 1 || modificadorDefensa > 3);
        Arma nuevaArma = new Arma(nombreArma,dosManos,modificadorAtaque,modificadorDefensa);
        PersistenciaManager p = PersistenciaManager.getInstance();
        RegistroEquipamiento equipamiento = p.getPersistencia().getGameData().getEquipamiento();
        equipamiento.addEquipment(nombreArma,nuevaArma);
    }

    public GestorDesafiosAdmin getDesafios() {
        if (desafios == null) {
            desafios = new GestorDesafiosAdmin();
        }
        return this.desafios;
    }

    public void bloquearJugador(){
        Scanner sc = new Scanner(System.in);
        PersistenciaManager.getInstance().getPersistencia().getUsersData().mostrarJugadores();
        System.out.println("Ingrese el nombre de usuario a bloquear");
        String nick = sc.nextLine();
        Usuario user = PersistenciaManager.getInstance().getPersistencia().getUsersData().getUsuarioByNick(nick);
        if (user == null) {
            System.out.println("No existe un usuario asociado.");
        } else if (user instanceof Jugador j) {
            if (!j.isBlock()) {
                j.setBlock(true);
                System.out.println("El usuario ha sido bloqueado.");
            } else
                System.out.println("El usuario ya está bloqueado.");
        } else {
            System.out.println("El usuario no es un jugador.");
        }
    }

    public void desbloquearJugador(){
        Scanner sc = new Scanner(System.in);
        PersistenciaManager.getInstance().getPersistencia().getUsersData().mostrarBloqueados();
        String nick = sc.nextLine();
        Usuario user = PersistenciaManager.getInstance().getPersistencia().getUsersData().getUsuarioByNick(nick);
        if (user == null) {
            System.out.println("No existe un usuario asociado.");
        } else if (user instanceof  Jugador j) {
            if (j.isBlock()) {
                j.setBlock(false);
                System.out.println("El usuario ha sido desbloqueado.");
            } else
                System.out.println("El usuario no está bloqueado.");
        } else {
            System.out.println("El usuario no es un jugador.");
        }
    }

    @Override
    public void show() {
        System.out.println("1.Gestionar Desafíos\n2.Editar personajes\n3.Bloqueo de usuarios\n4.Crear Equipamiento\n5.Salir");
    }
}