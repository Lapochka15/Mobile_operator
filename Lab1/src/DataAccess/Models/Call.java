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

    public Call(int source, int destination, Time duration, int id){
        this.sourceClientId = source;
        this.destinationClientId = destination;
        this.duration = duration;
        this.dateTime = LocalDateTime.now();
        this.serviceId = id;
    }

    public Call(){
    }

    public String toString(){
        return String.format("%3d|%6d|%6d|%tr|%tr",this.serviceId, this.sourceClientId, this.destinationClientId, this.duration, this.dateTime);
    }
}
