package DataPresentation.EntityMenu;

import BusinessLayer.Services.TariffPlanService;
import DataAccess.Models.TariffPlan;

import java.util.Scanner;

public class TariffPlanMenu extends BaseMenu {

    private TariffPlanService _tariffPlan = new TariffPlanService();
    @Override
    public void Show() {
        int choice;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("----------Menu----------");
            System.out.println("1. Show Client sorted by Id");
            System.out.println("2. Show Client sorted by Subscription Free");
            System.out.println("Enter you choice");
            choice = in.nextInt();
        } while (choice > 2 || choice < 0 );
        switch (choice){
            case 1:
                _tariffPlan.ShowTariffPlanSortedById();
                break;
            case 2:
                _tariffPlan.ShowTariffPlanSortedBySubscriptionFree();
                break;
        }
        return;
    }

    @Override
    public void Update() {

    }

    @Override
    public boolean Delete() {
        return false;
    }

    @Override
    public void Add() {

    }

    @Override
    public void SaveChanges() {
        _tariffPlan.SaveEntities();
    }
}
