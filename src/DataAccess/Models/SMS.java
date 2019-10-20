package DataAccess.Models;

import java.time.LocalDateTime;

public class SMS extends Service {
    public int textSize;

    public SMS(){

    }

    public SMS(int id, int source, int destination, int textSize){
        this.sourceClientId = source;
        this.textSize = textSize;
        this.destinationClientId = destination;
        this.serviceId = id;
        this.dateTime = LocalDateTime.now();

    }

    public String toString(){
        return String.format("%6d|%6d|%d|%t", this.sourceClientId, this.destinationClientId, this.textSize, this.dateTime);
    }
}
