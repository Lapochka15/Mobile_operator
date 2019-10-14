package DataPresentation.EntityMenu;

import BusinessLayer.Services.ClientService;

import java.util.Scanner;

public class ClientMenu extends BaseMenu {
    private ClientService _clientService = new ClientService();
    @Override
    public void Show() {
        int choice;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("----------Menu----------");
            System.out.println("1. Show Client sorted by Surname");
            System.out.println("2. Show Client sorted by Bank Account");
            System.out.println("3. Show Client sorted by Company");
            System.out.println("4. Show Client sorted by Id");
            System.out.println("Enter you choice");
            choice = in.nextInt();
        } while (choice > 4 || choice < 0 );
        switch (choice){
            case 1:
                _clientService.ShowClientsSortedBySurname();
                break;
            case 2:
                _clientService.ShowClientsSortedByBankAccount();
                break;
            case 3:
                _clientService.ShowClientsSortedByCompany();
                break;
            case 4:
                _clientService.ShowClientsSortedById();
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
