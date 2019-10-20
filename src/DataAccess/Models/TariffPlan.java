package DataAccess.Models;

import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;

import java.io.Serializable;

public class TariffPlan implements Serializable {
    public int id;

    public String name;
    public Double subscriptionFee;
    public Debit debit;

    public Double smsPrice;
    public Double callPrice;

    public TariffPlan(){

    }

    public TariffPlan(int id, String name, Double subscriptionFee, Debit debit, Double smsPrice, Double callPrice){
        this.callPrice = callPrice;
        this.debit = debit;
        this.name = name;
        this.smsPrice = smsPrice;
        this.subscriptionFee = subscriptionFee;
        this.id = id;
    }

    public String toString(){
        return String.format("%15s|%6f|%h|%f|%f", this.name, this.subscriptionFee, this.debit, this.smsPrice, this.callPrice);
    }

}
