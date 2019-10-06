package BusinessLayer.Services;

import DataAccess.Models.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientService extends BaseService<Client> {

    private String _fileName;
    public ClientService(String fileName){
        super(fileName);
        this._fileName = fileName;
    }

    public ClientService(){
        super("clients.txt");
        this._fileName = "clients.txt";
    }
}
