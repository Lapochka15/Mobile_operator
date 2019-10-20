package DataPresentation.EntityMenu;

import BusinessLayer.Services.ClientService;
import DataAccess.Models.Client;

import java.sql.Time;
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
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        Client resultEntity = _clientService.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return;
        }

        System.out.println("Enter Client Name :");
        String name = in.next();
        System.out.println("Enter Client Surname :");
        String surname = in.next();

        System.out.println("Enter bankAccount:");
        double bankAccount = in.nextDouble();

        System.out.println("Enter tariff Id:");
        int tariff = in.nextInt();

        System.out.println("Enter company Id:");
        int company = in.nextInt();

        resultEntity.companyId = company;
        resultEntity.name = name;
        resultEntity.bankAccount = bankAccount;
        resultEntity.surname = surname;
        resultEntity.tariffPlanId = tariff;


    }

    @Override
    public boolean Delete() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        Client resultEntity = _clientService.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return false;
        }
        _clientService.RemoveEntity(resultEntity);
        return true;
    }

    @Override
    public void Add() {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter Client Name :");
        String name = in.next();
        System.out.println("Enter Client Surname :");
        String surname = in.next();

        System.out.println("Enter bankAccount:");
        double bankAccount = in.nextDouble();

        System.out.println("Enter tariff Id:");
        int tariff = in.nextInt();

        System.out.println("Enter company Id:");
        int company = in.nextInt();

        int lengthOfCollection = _clientService.GetAmountOfEntities();
        Client lastClient = _clientService.GetEntityByPosition(lengthOfCollection - 1 );

        Client client= new Client(lastClient.clientId + 1, name, surname, bankAccount, tariff, company, true );

        _clientService.AddEntity(client);
    }

    @Override
    public void SaveChanges() {
        _clientService.SaveEntities();
    }
}
