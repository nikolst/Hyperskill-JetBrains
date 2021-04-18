package bank;

import java.util.Scanner;
import  java.util.Random;

public class Account {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    private String cardNum;
    private String pinCode;
    private int balance;

    public Account() {
        this.cardNum = createCardNum();
        this.pinCode = createPin();
        this.balance = 0;
    }

    public String getCardNum() {
        return  cardNum;
    }

    public String getPinCode() {
        return pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public String createCardNum() {
        int arr[] = new int[16];
        int sum = 0, checkSum = 0;
        String last = null;

        for (int i = 1; i <= 15; i++) {
            if (i == 1) {
                arr[i] = 4;
            } else if (i > 1 && i < 7) {
                arr[i] = 0;
            } else {
                arr[i] = rand.nextInt(10);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 15; i++) {
            sb.append(arr[i]);
        }

        String _cardNum = sb.toString();

        for (int j = 1; j <= 15; j++) {
            if (j % 2 != 0) {
                arr[j] = arr[j] * 2;
                if (arr[j] > 9) {
                    arr[j] = arr[j] - 9;
                }
            }
            sum = sum + arr[j];
        }

        checkSum = (10 - (sum % 10)) % 10;

        last = String.valueOf(checkSum);
        cardNum = _cardNum.concat(last);
        return cardNum;
    }

    public String createPin() {
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
        return pinCode;
    }

    public void createAccount() {
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(createCardNum());
        System.out.println("Your card PIN:");
        System.out.println(createPin());
    }

    public void logInto() {
        Menu m = new Menu();
        System.out.println("Enter your card number:");
        String inputCardNum = input.nextLine();
        System.out.println("Enter your PIN:");
        String inputPinCode = input.nextLine();
        if (getCardNum().equals(inputCardNum) && getPinCode().equals(inputPinCode)) {
            System.out.println("\nYou have successfully logged in!\n");
            m.loggedInMenuSwitch();
        } else {
            System.out.println("\nWrong card number or PIN!\n");
            m.accountMenuSwitch();
        }
    }

}
