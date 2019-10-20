package BusinessLayer.Services;

import BusinessLayer.Models.Comparator.CallComparator.CallByDurationComparator;
import BusinessLayer.Models.Comparator.ServiceComparator.ServiceByDateTimeComparator;
import BusinessLayer.Models.Comparator.ServiceComparator.ServiceByIdComparator;
import BusinessLayer.Models.Comparator.ServiceComparator.ServiceBySourceComparator;
import DataAccess.Models.Call;

import java.io.IOException;

public class CallService extends BaseService<Call> {
    private String _fileName;

    public CallService(String fileName){
        super(fileName);
        this._fileName = fileName;
    }

    public CallService(){
        super("call.txt");
        this._fileName = "call.txt";
    }

    public void ShowCallSortedById()  {
        if (_entities == null)
            LoadEntities();
        this._entities.sort(new ServiceByIdComparator());
        for (Call call: _entities ) {
            System.out.println(call);
        }
    }

    public void ShowCallSortedByDate() {
        if (_entities == null)
            LoadEntities();
        this._entities.sort(new ServiceByDateTimeComparator());
        for (Call call: _entities ) {
            System.out.println(call);
        }
    }

    public void ShowCallSortedBySource()  {
        if (_entities == null)
            LoadEntities();
        this._entities.sort(new ServiceBySourceComparator());
        for (Call call: _entities ) {
            System.out.println(call);
        }
    }

    public void ShowCallSortedByDuration() {
        if (_entities == null)
            LoadEntities();
        this._entities.sort(new CallByDurationComparator());
        for (Call call: _entities ) {
            System.out.println(call);
        }
    }

    public Call GetEntityByID(int id){
        if (this._entities == null)
            LoadEntities();
        for (Call call: _entities) {
            if(call.serviceId == id){
                return call;
            }
        }
        return null;
    }
}

