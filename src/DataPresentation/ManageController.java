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


    public void EntryPoint() {
        while (true) {
            BaseMenu chosenEntityMenu = Menu.ChooseEntity();

            if (chosenEntityMenu == null)
                return;


            Menu.ExecuteChosenAction(chosenEntityMenu);

        }
    }

}
