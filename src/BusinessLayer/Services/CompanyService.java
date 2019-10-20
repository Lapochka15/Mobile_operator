package BusinessLayer.Services;

import BusinessLayer.Models.Comparator.CompanyComparator.CompanyByIdComparator;
import BusinessLayer.Models.Comparator.CompanyComparator.CompanyByNameComparator;
import DataAccess.Models.Company;

public class CompanyService extends BaseService<Company> {
    private String _fileName;
    public CompanyService(String fileName){
        super(fileName);
        this._fileName = fileName;
    }

    public CompanyService(){
        super("company.txt");
        this._fileName = "company.txt";
    }

    public void ShowCompaniesSortedByName(){
        this._entities.sort(new CompanyByNameComparator());
        for (Company client: _entities ) {
            System.out.println(client);
        }
    }

    public void ShowCompaniesSortedById(){
        this._entities.sort(new CompanyByIdComparator());
        for (Company client: _entities ) {
            System.out.println(client);
        }
    }
    public Company GetEntityByID(int id){
        if (this._entities == null)
            LoadEntities();
        for (Company entity: this._entities) {
            if(entity.companyId == id){
                return entity;
            }
        }
        return null;
    }
}
