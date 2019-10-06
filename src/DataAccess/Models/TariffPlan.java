package DataAccess.Models;

import java.io.Serializable;

public class TariffPlan implements Serializable {
    public String name;
    public Double subscriptionFee;
    public Debit debit;

    public Double smsPrice;
    public Double callPrice;

}
