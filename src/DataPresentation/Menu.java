package DataPresentation;

import java.util.Scanner;

public class Menu {

    public static int StartMenu(){
        int choice;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("----------Menu----------");
            System.out.println("1. Show Entities");
            System.out.println("2. Delete Entity");
            System.out.println("3. Update Entity");
            System.out.println("4. Exit");
            System.out.println("Enter you choice");
            choice = in.nextInt();
        } while (choice > 4 || choice < 0 );
        return choice;
    }

    public static int ChooseEntity(){
        int choice;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("----------Menu----------");
            System.out.println("Please, choose entity");
            System.out.println("1. Client");
            System.out.println("2. Company");
            System.out.println("3. Tariff Plan");
            System.out.println("4. Sms");
            System.out.println("5. Call");
            System.out.println("6. Return to start menu");
            System.out.println("Enter you choice");
            choice = in.nextInt();
        } while (choice > 6 || choice < 0 );
        return choice;
    }
}
