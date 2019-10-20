package DataPresentation.EntityMenu;

import BusinessLayer.Services.CallService;
import DataAccess.Models.Call;

import java.io.IOException;
import java.sql.Time;
import java.util.Scanner;

public class CallMenu extends BaseMenu{


    private CallService _callService = new CallService();
    @Override
    public void Show()  {
        int choice;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("----------Menu----------");
            System.out.println("1. Show Call sorted by Id");
            System.out.println("2. Show Call sorted by Date");
            System.out.println("3. Show Call sorted by Source");
            System.out.println("4. Show Call sorted by Duration");
            System.out.println("Enter you choice");
            choice = in.nextInt();
        } while (choice > 4 || choice < 0 );
        switch (choice){
            case 1:
                _callService.ShowCallSortedById();
                break;
            case 2:
                _callService.ShowCallSortedByDate();
                break;
            case 3:
                _callService.ShowCallSortedBySource();
                break;
            case 4:
                _callService.ShowCallSortedByDuration();
                break;
        }
        return;
    }

    @Override
    public void Update() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        Call resultEntity = _callService.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return;
        }

        System.out.println("Enter source Id :");
        int source = in.nextInt();
        System.out.println("Enter destination Id :");
        int destination = in.nextInt();
        System.out.println("Enter duration :");
        Time duration = new Time( in.nextLong());

        resultEntity.duration =duration;
        resultEntity.sourceClientId = source;
        resultEntity.destinationClientId = destination;

    }

    @Override
    public boolean Delete() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        Call resultEntity = _callService.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return false;
        }
        _callService.RemoveEntity(resultEntity);
        return true;
    }

    @Override
    public void Add() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter source Id :");
        int source = in.nextInt();
        System.out.println("Enter destination Id :");
        int destination = in.nextInt();
        System.out.println("Enter duration :");
        Time duration = new Time( in.nextLong());

        int lengthOfCollection = _callService.GetAmountOfEntities();
        Call lastCall = _callService.GetEntityByPosition(lengthOfCollection - 1 );


        Call call= new Call(source,destination, duration, lastCall.serviceId + 1);

        _callService.AddEntity(call);


    }

    @Override
    public void SaveChanges() {
        _callService.SaveEntities();
    }
}
