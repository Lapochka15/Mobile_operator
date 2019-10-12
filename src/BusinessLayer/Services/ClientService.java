package BusinessLayer.Services;

import BusinessLayer.Models.Comparator.ClientComparator.ClientByBankAccountComparator;
import BusinessLayer.Models.Comparator.ClientComparator.ClientByCompanyComparator;
import BusinessLayer.Models.Comparator.ClientComparator.ClientByIdComparator;
import BusinessLayer.Models.Comparator.ClientComparator.ClientBySurnameComparator;
import DataAccess.Models.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientService extends BaseService<Client> {

    public ClientService(String fileName){
        super(fileName);
    }

    public ClientService(){
        super("./clients.txt");
    }

    public void ShowClientsSortedByBankAccount(){
        this._entities.sort(new ClientByBankAccountComparator());
        for (Client client: _entities ) {
            System.out.println(client);
        }
    }
    public void ShowClientsSortedByCompany(){
        this._entities.sort(new ClientByCompanyComparator());
        for (Client client: _entities ) {
            System.out.println(client);
        }
    }
    public void ShowClientsSortedBySurname(){
        this._entities.sort(new ClientBySurnameComparator());
        for (Client client: _entities ) {
            System.out.println(client);
        }
    }

    public void ShowClientsSortedById(){
        this._entities.sort(new ClientByIdComparator());
        for (Client client: _entities ) {
            System.out.println(client);
        }
    }
}
