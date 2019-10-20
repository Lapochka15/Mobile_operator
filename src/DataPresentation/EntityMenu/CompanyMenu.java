package DataPresentation.EntityMenu;

import BusinessLayer.Services.ClientService;
import BusinessLayer.Services.CompanyService;
import DataAccess.Models.Company;

import java.util.Scanner;

public class CompanyMenu extends BaseMenu{

    private CompanyService _companyService = new CompanyService();
    @Override
    public void Show() {
        int choice;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("----------Menu----------");
            System.out.println("1. Show Call sorted by Id");
            System.out.println("2. Show Call sorted by Name");
            System.out.println("Enter you choice");
            choice = in.nextInt();
        } while (choice > 2 || choice < 0 );
        switch (choice){
            case 1:
                _companyService.ShowCompaniesSortedById();
                break;
            case 2:
                _companyService.ShowCompaniesSortedByName();
                break;
        }
        return;
    }

    @Override
    public void Update() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        Company resultEntity = _companyService.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return;
        }
        System.out.println("Enter Company Name :");
        String name = in.next();
        System.out.println("Enter discount:");
        double discount = in.nextDouble();

        resultEntity.name = name;
        resultEntity.discount = discount;
    }

    @Override
    public boolean Delete() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of Entity");
        int entityId = in.nextInt();
        Company resultEntity = _companyService.GetEntityByID(entityId);
        System.out.println(resultEntity);
        if (resultEntity == null) {
            System.out.println("Not found entity with "+ entityId + " Id");
            return false;
        }
        _companyService.RemoveEntity(resultEntity);
        return true;
    }

    @Override
    public void Add() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Company Name :");
        String name = in.next();
        System.out.println("Enter discount:");
        double discount = in.nextDouble();

        int lengthOfCollection = _companyService.GetAmountOfEntities();
        Company lastClient = _companyService.GetEntityByPosition(lengthOfCollection - 1 );

        Company client= new Company(lastClient.companyId, name, discount);

        _companyService.AddEntity(client);
    }

    @Override
    public void SaveChanges() {
        _companyService.SaveEntities();
    }
}
