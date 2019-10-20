package DataPresentation.EntityMenu;

import BusinessLayer.Services.TariffPlanService;
import DataAccess.Models.Debit;
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


        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        TariffPlan resultEntity = _tariffPlan.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return;
        }
        System.out.println("Enter Name :");
        String name = in.next();

        System.out.println("Enter Subscription Fee :");
        double subscriptionFee = in.nextDouble();

        System.out.println("Enter SMS price :");
        double smsPrice = in.nextDouble();
        System.out.println("Enter Call price :");
        double callPrice = in.nextDouble();

        resultEntity.subscriptionFee = subscriptionFee;
        resultEntity.smsPrice = smsPrice;
        resultEntity.callPrice = callPrice;
        resultEntity.name = name;
    }

    @Override
    public boolean Delete() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        TariffPlan resultEntity = _tariffPlan.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return false;
        }
        _tariffPlan.RemoveEntity(resultEntity);
        return true;
    }

    @Override
    public void Add() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Name :");
        String name = in.next();

        System.out.println("Enter Subscription Fee :");
        double subscriptionFee = in.nextDouble();

        System.out.println("Enter SMS price :");
        double smsPrice = in.nextDouble();
        System.out.println("Enter Call price :");
        double callPrice = in.nextDouble();

        int lengthOfCollection = _tariffPlan.GetAmountOfEntities();
        TariffPlan lastClient = _tariffPlan.GetEntityByPosition(lengthOfCollection - 1 );
        TariffPlan client= new TariffPlan(lastClient.id, name, subscriptionFee,Debit.everyMonth , smsPrice, callPrice  );

        _tariffPlan.AddEntity(client);
    }

    @Override
    public void SaveChanges() {
        _tariffPlan.SaveEntities();
    }
}
