package DataPresentation.EntityMenu;

import BusinessLayer.Models.Comparator.SMSComparator.SmsByTextSizeComparator;
import BusinessLayer.Services.SMSService;
import DataAccess.Models.SMS;
import sun.util.resources.cldr.sah.CalendarData_sah_RU;

import java.util.Scanner;

public class SMSMenu extends BaseMenu{

    private SMSService _smsService = new SMSService();

    @Override
    public void Show() {
        int choice;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("----------Menu----------");
            System.out.println("1. Show Client sorted by Date");
            System.out.println("2. Show Client sorted by Id");
            System.out.println("3. Show Client sorted by Source");
            System.out.println("4. Show Client sorted by Text Size");
            System.out.println("Enter you choice");
            choice = in.nextInt();
        } while (choice > 4 || choice < 0 );
        switch (choice){
            case 1:
                _smsService.ShowSmsSortedByDate();
                break;
            case 2:
                _smsService.ShowSmsSortedById();
                break;
            case 3:
                _smsService.ShowSmsSortedBySource();
                break;
            case 4:
                _smsService.ShowSmsSortedByTextSize();
                break;
        }
        return;
    }

    @Override
    public void Update() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        SMS resultEntity = _smsService.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return;
        }

        System.out.println("Enter Source :");
        int source = in.nextInt();
        System.out.println("Enter Destination :");
        int destination = in.nextInt();
        System.out.println("Enter Size of sms :");
        int size = in.nextInt();

        resultEntity.textSize =size;
        resultEntity.destinationClientId = destination;
        resultEntity.sourceClientId = source;

    }

    @Override
    public boolean Delete() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        SMS resultEntity = _smsService.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return false;
        }
        _smsService.RemoveEntity(resultEntity);
        return true;
    }

    @Override
    public void Add() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Source :");
        int source = in.nextInt();
        System.out.println("Enter Destination :");
        int destination = in.nextInt();
        System.out.println("Enter Size of sms :");
        int size = in.nextInt();

        int lengthOfCollection = _smsService.GetAmountOfEntities();
        SMS lastClient = _smsService.GetEntityByPosition(lengthOfCollection - 1 );

        SMS client= new SMS(lastClient.serviceId, source,destination, size );

        _smsService.AddEntity(client);
    }

    @Override
    public void SaveChanges() {
        _smsService.SaveEntities();
    }
}
