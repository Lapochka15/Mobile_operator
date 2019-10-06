import DataAccess.Models.Client;
import netscape.javascript.JSException;
import sun.plugin.javascript.navig.Array;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Client client1 = new Client("Katya", "Dub", 10, 1,1,true );
            Client client3 = new Client("Katya1", "Dub", 10, 1,1,true );
            oos.writeObject(new Client[]{client1, client3});
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("temp.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            Client[] clientList1 = (Client[]) oin.readObject();
            System.out.println(clientList1[0].name);
            System.out.println(clientList1[1].name);
    }
}
