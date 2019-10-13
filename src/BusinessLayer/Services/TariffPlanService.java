package BusinessLayer.Services;

import DataAccess.Models.TariffPlan;

public class TariffPlanService extends BaseService<TariffPlan> {
    private String _fileName;
    public TariffPlanService(String fileName){
        super(fileName);
        this._fileName = fileName;
    }

    public TariffPlanService(){
        super("tariffPlan.txt");
        this._fileName = "tariffPlan.txt";
    }
}
