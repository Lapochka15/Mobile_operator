package BusinessLayer.Services;

import BusinessLayer.Models.Comparator.TariffPlanComparator.TariffPlanByIdComparator;
import BusinessLayer.Models.Comparator.TariffPlanComparator.TariffPlanBySubscriptionFreeComparator;
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

    public void ShowTariffPlanSortedById(){
        this._entities.sort(new TariffPlanByIdComparator());
        for (TariffPlan client: _entities ) {
            System.out.println(client);
        }
    }

    public void ShowTariffPlanSortedBySubscriptionFree(){
        this._entities.sort(new TariffPlanBySubscriptionFreeComparator());
        for (TariffPlan client: _entities ) {
            System.out.println(client);
        }
    }

    public TariffPlan GetEntityByID(int id){
        if (this._entities == null)
            LoadEntities();
        for (TariffPlan entity: this._entities) {
            if(entity.id == id){
                return entity;
            }
        }
        return null;
    }
}
