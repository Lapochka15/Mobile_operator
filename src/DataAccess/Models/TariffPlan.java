package DataAccess.Models;

import java.io.Serializable;

public class TariffPlan implements Serializable {
    String name;
    Double subscriptionFee;
    Debit debit;

    Double smsPrice;
    Double callPrice;

}
