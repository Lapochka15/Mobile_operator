package DataAccess.Models;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Service implements Serializable {
    int sourceClientId;
    int destinationClientId;
    LocalDateTime dateTime;



}
