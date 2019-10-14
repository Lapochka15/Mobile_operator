package BusinessLayer.Services;

import BusinessLayer.Models.Comparator.SMSComparator.SmsByTextSizeComparator;
import BusinessLayer.Models.Comparator.ServiceComparator.ServiceByDateTimeComparator;
import BusinessLayer.Models.Comparator.ServiceComparator.ServiceByIdComparator;
import BusinessLayer.Models.Comparator.ServiceComparator.ServiceBySourceComparator;
import DataAccess.Models.SMS;

public class SMSService extends BaseService<SMS> {
    private String _fileName;
    public SMSService(String fileName){
        super(fileName);
        this._fileName = fileName;
    }

    public SMSService(){
        super("sms.txt");
        this._fileName = "sms.txt";
    }

    public void ShowSmsSortedByTextSize(){
        this._entities.sort(new SmsByTextSizeComparator());
        for (SMS client: _entities ) {
            System.out.println(client);
        }
    }

    public void ShowSmsSortedBySource(){
        this._entities.sort(new ServiceBySourceComparator());
        for (SMS client: _entities ) {
            System.out.println(client);
        }
    }

    public void ShowSmsSortedById(){
        this._entities.sort(new ServiceByIdComparator());
        for (SMS client: _entities ) {
            System.out.println(client);
        }
    }

    public void ShowSmsSortedByDate(){
        this._entities.sort(new ServiceByDateTimeComparator());
        for (SMS client: _entities ) {
            System.out.println(client);
        }
    }
}
