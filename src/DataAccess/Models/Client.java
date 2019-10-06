package DataAccess.Models;

import java.io.Serializable;

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


}
