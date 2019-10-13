package DataPresentation;

import BusinessLayer.Services.*;

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
        int startChoice = Menu.StartMenu();
        int entityChoice;
        switch (startChoice){
            case 1-3: {
                entityChoice = Menu.ChooseEntity();
            }
            case 4:
                return;
        }

        
    }
}
