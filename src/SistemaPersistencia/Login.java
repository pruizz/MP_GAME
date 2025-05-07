package SistemaPersistencia;

import Herramientas.Jugador;
import Herramientas.Usuario;
import Personajes.*;

import java.util.*;

public class Login {

    public Login() {
    }

    public Usuario iniciarSesion(String usuario, String password) {
        Usuario userToLogin = PersistenciaManager.getInstance().getPersistencia().getUsersData().getUsuarioByNick(usuario);
        if (userToLogin != null && validarInicioSesion(userToLogin, password)){
            return userToLogin;
        } else {
            return null;
        }
    }

    private boolean validarInicioSesion(Usuario usuario, String password) {
        String passw = usuario.getPassword();
        return passw.equals(password);
    }

    public Usuario registrarJugador() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Registrando Nuevo Jugador:");
        System.out.println("Introduce el nickname del jugador:");
        String newUserName = sc.nextLine();
        System.out.println("Introduce la contraseña del jugador:");
        String newUserPassword = sc.nextLine();

        Usuario checkNoExiste = this.iniciarSesion(newUserName, newUserPassword);
        if (checkNoExiste != null) {
            System.out.println("Usuario ya existe, iniciando sesión...");
            return checkNoExiste;
        }
        Jugador newPlayer = new Jugador(newUserName, newUserPassword);
        boolean valid = false;
        PersonajeFactory factory = null;


        while (!valid){
            System.out.println("Elige el personaje entre Licantropo, Cazador o Vampiro");
            String option = sc.nextLine();
            switch (option){
                case "Cazador":
                    factory = new CazadorFactory();
                    valid = true;
                    break;
                case "Vampiro":
                    factory  = new VampiroFactory();
                    valid = true;
                    break;
                case "Licantropo":
                    factory = new LicantropoFactory();
                    valid = true;
                    break;
                default:
                    break;
            }
        }
        ServicioPersonaje servicioPersonaje = new ServicioPersonaje(factory);
        Personaje newPersonaje = servicioPersonaje.crearPersonaje();
        newPlayer.setPersonaje(newPersonaje);

        PersistenciaManager.getInstance().getPersistencia().getUsersData().addNewUser(newPlayer);
        return newPlayer;
    }

}