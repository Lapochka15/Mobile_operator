import BusinessLayer.Services.ClientService;
import DataAccess.Models.Client;
import netscape.javascript.JSException;
import sun.plugin.javascript.navig.Array;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            ClientService clientService = new ClientService();
            /*clientService.AddElement( new Client("katya", "dub", 10,1,1,true));
            clientService.AddElement( new Client("katya1", "dub1", 10,1,1,true));
            clientService.AddElement( new Client("katya2", "dub2", 10,1,1,true));
            clientService.AddElement( new Client("katya3", "dub3", 10,1,1,true));*/

            ArrayList<Client> clients =  clientService.GetEntities();
            //clientService.RemoveElement(clients.get(0));
            clientService.Save();
            clientService.ShowAll();
    }
}
