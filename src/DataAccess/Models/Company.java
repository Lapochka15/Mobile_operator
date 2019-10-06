package DataAccess.Models;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {
    String name;
    Double discount;

    List<Client> clients;
}
