package BusinessLayer.Services;

import DataAccess.Models.Call;

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
}

