package DataAccess.Models;

import java.io.Serializable;
import java.io.StringReader;

public class Client  implements Serializable {
    public String name;
    public String surname;
    public Double bankAccount;
    public int tariffPlanId;
    public int companyId;
    public boolean isActiveClient;

    public Client(){

    }

    public Client(String name, String surname, double bankAccount, int tariffId, int companyId, boolean isActive){
        this.bankAccount = bankAccount;
        this.companyId = companyId;
        this.isActiveClient = isActive;
        this.name = name;
        this.surname = surname;
        this.tariffPlanId = tariffId;
    }

    public String toString(){
        return String.format("%s, %s, %f %d %d", name, surname, bankAccount, tariffPlanId, companyId);
    }


}
