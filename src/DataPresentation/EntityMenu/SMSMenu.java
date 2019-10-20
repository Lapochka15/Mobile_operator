package DataPresentation.EntityMenu;

import BusinessLayer.Services.SMSService;
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
        _smsService.SaveEntities();
    }
}
