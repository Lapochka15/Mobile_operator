package DataAccess.Models;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {
    public int companyId;
    public String name;
    public Double discount;

    public Company(){

    }

    public Company(int companyId, String name, Double discount){
        this.companyId = companyId;
        this.name = name;
        this.discount = discount;
    }

    public String toString(){
        return String.format("%6d|%12s|%f", this.companyId, this.name, this.discount);
    }
}
