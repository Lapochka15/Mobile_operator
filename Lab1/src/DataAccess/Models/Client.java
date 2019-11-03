package DataAccess.Models;

import java.io.Serializable;
import java.io.StringReader;

public class Client  implements Serializable {
    public int clientId;
    public String name;
    public String surname;
    public Double bankAccount;
    public int tariffPlanId;
    public int companyId;
    public boolean isActiveClient;

    public Client(){

    }

    public Client(int id, String name, String surname, double bankAccount, int tariffId, int companyId, boolean isActive){
        this.bankAccount = bankAccount;
        this.companyId = companyId;
        this.isActiveClient = isActive;
        this.name = name;
        this.surname = surname;
        this.tariffPlanId = tariffId;
        this.clientId = id;
    }

    public String toString(){
        return String.format("%3d|%20s|%15s|%2f|%2d|%2d",clientId, name, surname, bankAccount, tariffPlanId, companyId);
    }


}
