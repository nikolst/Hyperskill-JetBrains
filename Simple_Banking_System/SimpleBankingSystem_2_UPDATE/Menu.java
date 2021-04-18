package bank;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    Account account = new Account();

    public void accountMenu() {
        System.out.println("1. Create an account\n2. Log into account\n0. Exit\n");
    }

    public void loggedInMenu() {
        System.out.println("1. Balance\n2. Log out\n0. Exit\n");
    }

    public void accountMenuSwitch() {
        int option1;

        do {
            accountMenu();
            option1 = input.nextInt();
            switch (option1) {
                case 1:
                    account.createAccount();
                    break;
                case 2:
                    account.logInto();
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
            }
        } while(option1 != 0);
    }

    public void loggedInMenuSwitch() {
        int option2;
        do {
            loggedInMenu();
            option2 = input.nextInt();
            switch (option2) {
                case 1:
                    System.out.printf("Balance: %d\n", account.getBalance());
                    break;
                case 2:
                    System.out.println("You have successfully logged out!\n");
                    accountMenuSwitch();
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
            }
        } while(option2 != 0);
    }
}
