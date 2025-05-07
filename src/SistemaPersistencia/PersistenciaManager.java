package SistemaPersistencia;
public class PersistenciaManager {

    private static PersistenciaManager instance;
    private PersistenciaXML persistencia;

    private PersistenciaManager() {
        try {
            this.persistencia = PersistenciaXML.loadDataFromDisk();
        }catch(Exception e) {
            this.persistencia = new PersistenciaXML();
            System.out.println("nueva persistencia");
        }
    }

    public static PersistenciaManager getInstance() {
        if (instance == null){
            instance = new PersistenciaManager();
        }
        return instance;
    }

    public PersistenciaXML getPersistencia() {
        return persistencia;
    }

}