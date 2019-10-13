package DataAccess.Models;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Service implements Serializable {
    public int serviceId;
    public int sourceClientId;
    public int destinationClientId;
    public LocalDateTime dateTime;



}
