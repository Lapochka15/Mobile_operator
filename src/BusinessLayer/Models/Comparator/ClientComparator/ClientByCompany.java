package BusinessLayer.Models.Comparator.ClientComparator;

import DataAccess.Models.Client;

import java.util.Comparator;

public class ClientByCompany implements Comparator<Client> {
    @Override
    public int compare(Client client1, Client client2){
        return client1.companyId - client2.companyId;
    }
}

