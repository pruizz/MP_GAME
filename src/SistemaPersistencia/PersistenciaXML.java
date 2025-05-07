package SistemaPersistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class PersistenciaXML {
    private UsersData usersData;
    private GameData gameData;

    public PersistenciaXML() {}

    public void setUsersData(UsersData usersData) {this.usersData = usersData;}
    public void setGameData(GameData gameData) {this.gameData = gameData;}

    public UsersData getUsersData() {
        return this.usersData;
    }
    public GameData getGameData() {
        return this.gameData;
    }



    public static PersistenciaXML loadDataFromDisk() throws FileNotFoundException {
        InputStream stream = new FileInputStream("data/persistencia.xml");
        XMLDecoder decoder = new XMLDecoder(stream);

        return (PersistenciaXML) decoder.readObject();
    }


    public void saveDataInDisk() throws FileNotFoundException {
        OutputStream stream = new FileOutputStream("data/persistencia.xml");
        XMLEncoder encoder = new XMLEncoder(stream);

        encoder.writeObject(this);
        encoder.close();
    }

}