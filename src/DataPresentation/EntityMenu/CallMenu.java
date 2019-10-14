package DataPresentation.EntityMenu;

import BusinessLayer.Services.CallService;

import java.io.IOException;
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

    }

    @Override
    public void Delete() {

    }

    @Override
    public void Add() {

    }
}
