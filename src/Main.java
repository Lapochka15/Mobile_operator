import BusinessLayer.Services.ClientService;
import DataAccess.Models.Client;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            ClientService clientService = new ClientService();
            /*clientService.AddElement( new Client("katya", "dub", 10,1,1,true));
            clientService.AddElement( new Client("katya1", "dub1", 10,1,1,true));
            clientService.AddElement( new Client("katya2", "dub2", 10,1,1,true));
            clientService.AddElement( new Client("katya3", "dub3", 10,1,1,true));*/

            clientService.AddEntity(new Client("katya3", "dub3", 10,1,1,true));
            clientService.ShowAll();
            Client client = clientService.GetEntity(1000);

            System.out.println(client);
            clientService.RemoveEntity(clientService.GetEntity(0));
            //clientService.SaveEntities();
            clientService.ShowAll();
    }
}
