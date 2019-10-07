package BusinessLayer.Services;

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
}
