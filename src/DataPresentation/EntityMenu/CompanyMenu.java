package DataPresentation.EntityMenu;

import BusinessLayer.Services.ClientService;
import BusinessLayer.Services.CompanyService;

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
        _companyService.SaveEntities();
    }
}
