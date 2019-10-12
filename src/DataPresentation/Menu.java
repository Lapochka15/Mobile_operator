package DataPresentation;

import java.util.Scanner;

public class Menu {

    public static void StartMenu(){
        int choice;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("----------Menu----------");
            System.out.println("1. Show Entities");
            System.out.println("2. Delete Entity");
            System.out.println("3. Update Entity");
            System.out.println("Enter you choice");
            choice = in.nextInt();
        } while (choice > 3 && choice < 0 );

    }
}
