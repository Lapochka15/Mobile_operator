package BusinessLayer.Services;

import BusinessLayer.Models.Comparator.ClientComparator.ClientByBankAccountComparator;
import BusinessLayer.Models.Comparator.ClientComparator.ClientByCompanyComparator;
import BusinessLayer.Models.Comparator.ClientComparator.ClientByIdComparator;
import BusinessLayer.Models.Comparator.ClientComparator.ClientBySurnameComparator;
import DataAccess.Models.Client;
import DataAccess.Models.Company;
import com.sun.corba.se.spi.protocol.CorbaClientDelegate;

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
        if (this._entities == null)
            LoadEntities();
        this._entities.sort(new ClientByBankAccountComparator());
        for (Client client: _entities ) {
            System.out.println(client);
        }
    }
    public void ShowClientsSortedByCompany(){
        if (this._entities == null)
            LoadEntities();
        this._entities.sort(new ClientByCompanyComparator());
        for (Client client: _entities ) {
            System.out.println(client);
        }
    }
    public void ShowClientsSortedBySurname(){
        if (this._entities == null)
            LoadEntities();
        this._entities.sort(new ClientBySurnameComparator());
        for (Client client: _entities ) {
            System.out.println(client);
        }
    }

    public void ShowClientsSortedById(){
        if (this._entities == null)
            LoadEntities();
        this._entities.sort(new ClientByIdComparator());
        for (Client client: _entities ) {
            System.out.println(client);
        }
    }


    public Client GetEntityByID(int id){
        if (this._entities == null)
            LoadEntities();
        for (Client entity: this._entities) {
            if(entity.clientId == id){
                return entity;
            }
        }
        return null;
    }
}
