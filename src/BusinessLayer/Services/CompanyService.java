package BusinessLayer.Services;

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
}
