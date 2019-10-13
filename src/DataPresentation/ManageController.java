package DataPresentation;

import BusinessLayer.Services.*;
import DataPresentation.EntityMenu.BaseMenu;

public class ManageController {

    private ClientService _clientService;
    private CallService _callService;
    private CompanyService _companyService;
    private SMSService _smsService;
    private TariffPlanService _tariffPlanService;

    public ManageController(){
        _callService = new CallService();
        _clientService = new ClientService();
        _companyService = new CompanyService();
        _smsService = new SMSService();
        _tariffPlanService = new TariffPlanService();
    }


    public void EntryPoint(){
        BaseMenu chosenEntityMenu = Menu.ChooseEntity();

        if (chosenEntityMenu == null)
            return;

        int crudChoice = Menu.CRUDMenu();

        switch(crudChoice){
            case 1: chosenEntityMenu.Show();
            case 2: chosenEntityMenu.Add();
            case 3: chosenEntityMenu.Delete();
            case 4: chosenEntityMenu.Update();
        }


    }
}
