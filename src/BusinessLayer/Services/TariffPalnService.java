package BusinessLayer.Services;

import DataAccess.Models.TariffPlan;

public class TariffPalnService extends BaseService<TariffPlan> {
    private String _fileName;
    public TariffPalnService(String fileName){
        super(fileName);
        this._fileName = fileName;
    }

    public TariffPalnService(){
        super("tariffPlan.txt");
        this._fileName = "tariffPlan.txt";
    }
}
