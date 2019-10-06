package DataAccess.Models;

import java.io.Serializable;

public class Client  implements Serializable {
    String name;
    String surname;
    Double bankAccount;
    int tariffPlanId;
    int companyId;
    boolean isActiveClient;


}
