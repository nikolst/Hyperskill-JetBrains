package banking;

import java.util.Random;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    String cardNum;
    String pinCode;
    String inputCardNum;
    String inputPinCode;

    public void createCardNum() {
        long arr[] = new long[16];
        for (int i = 0; i < 16; i++) {
            if (i == 0) {
                arr[i] = 4;
            } else if (i > 0 && i < 6) {
                arr[i] = 0;
            } else if (i > 5) {
                arr[i] = rand.nextInt(10);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (long i : arr) {
            sb.append(i);
        }
        String _cardNUm = sb.toString();
        cardNum = _cardNUm;
        System.out.println(cardNum);
    }

    public void createPin() {
        int array[] = new int[4];
        for (int i = 0; i < 4; i++) {
            array[i] = rand.nextInt(10);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i);
        }
        String _pinCode = sb.toString();
        pinCode = _pinCode;
        System.out.println(pinCode);
    }

    public void inputCardNum() {
        String _inputNum = input.nextLine();
        inputCardNum = _inputNum;
    }

    public void inputPinCode() {
        String _inputPin = input.nextLine();
        inputPinCode = _inputPin;
    }

    public void createAccount() {
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        createCardNum();
        System.out.println("Your card PIN:");
        createPin();
    }

    public void logInto() {
        Menu m = new Menu();
        System.out.println("Enter your card number:");
        inputCardNum();
        System.out.println("Enter your PIN:");
        inputPinCode();
        if (cardNum.equals(inputCardNum) && pinCode.equals(inputPinCode)) {
            System.out.println("\nYou have successfully logged in!\n");
            m.loggedInMenuSwitch();
        } else {
            System.out.println("\nWrong card number or PIN!\n");
            m.accountMenuSwitch();
        }
    }

}
