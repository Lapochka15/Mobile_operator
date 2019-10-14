import BusinessLayer.Services.CallService;
import BusinessLayer.Services.ClientService;
import DataAccess.Models.Call;
import DataAccess.Models.Client;
import DataPresentation.ManageController;
import DataPresentation.Menu;
import sun.security.acl.AclEntryImpl;

import java.io.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            /*ClientService clientService = new ClientService();
            clientService._entities = new ArrayList<Client>();
            clientService.AddEntity(new Client(1,"akatya1", "idub1", 9,1,1,true));
            clientService.AddEntity(new Client(2, "bkatya1", "sdub1", 10,1,3,true));
            clientService.AddEntity(new Client(3, "ckatya1", "ddub1", 19,1,2,true));
            clientService.AddEntity(new Client(4, "dkatya1", "kdub1", 4,1,1,true));

            //clientService.RemoveEntity(clientService.GetEntity(0));
            clientService.SaveEntities();
            clientService.ShowAll();*/

        CallService callService = new CallService();
        /*callService.AddEntity(new Call(1, 2, new Time(30), 1));
        callService.AddEntity(new Call(2, 1, new Time(40), 2));
        callService.AddEntity(new Call(1, 2, new Time(50), 3));
        callService.AddEntity(new Call(2, 1, new Time(50), 4));
        callService.SaveEntities();*/
        ManageController manageController = new ManageController();
        manageController.EntryPoint();
    }
}
