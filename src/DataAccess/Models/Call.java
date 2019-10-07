package DataAccess.Models;

import DataAccess.Models.Service;

import java.sql.Time;
import java.time.LocalDateTime;

public class Call extends Service {
    public Time duration;

    public Call(int source, int destination, Time duration){
        this.sourceClientId = source;
        this.destinationClientId = destination;
        this.duration = duration;
        this.dateTime = LocalDateTime.now();
    }

    public Call(){
    }

    public String toString(){
        return String.format("%6d|%6d|%t|%t", this.sourceClientId, this.destinationClientId, this.duration, this.dateTime);
    }
}
