package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

//        for (int k = 0; k < 10; k++) {
//            if ((sum + k) % 10 == 0) {
//                checkSum = k;
//            }
//        }

        checkSum = (10 - (sum % 10)) % 10;

        last = String.valueOf(checkSum);
        cardNum = _cardNum.concat(last);

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

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:card.s3db");
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO card (number, PIN) VALUES (" + cardNum + ", " + pinCode + ")");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
