package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = input.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = input.nextInt();

        String[][] seatsArr = new String[rows + 1][seats + 1];
        cinemaSeats(rows, seats, seatsArr);


        int option;
        do {
            menu();
            option = input.nextInt();
            switch (option) {
                case 1:
                    printSeats(rows, seats, seatsArr);
                    break;
                case 2:
                    calculations(rows, seats, seatsArr);
                case 0:
                    break;
            }
        } while(option != 0);
    }

    public static void menu() {
        System.out.println("1. Show the seats\n2. Buy a ticket\n0. Exit");
    }

    public static void cinemaSeats(int rows, int seats, String[][] seatsArr) {
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (i == 0 && j == 0) {
                    seatsArr[i][j] = " ";
                } else if (i == 0 && j != 0) {
                    seatsArr[i][j] = String.valueOf(j);
                } else if (i != 0 && j == 0) {
                    seatsArr[i][j] = String.valueOf(i);
                } else {
                    seatsArr[i][j] = "S";
                }
            }
        }
    }

    public static void printSeats(int rows, int seats, String[][] seatsArr) {
        System.out.println("Cinema:");
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                System.out.print(seatsArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void calculations(int rows, int seats, String[][] seatsArr) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNum = input.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNum = input.nextInt();

        int price;
        int allSeats = rows * seats;
        if (allSeats <= 60) {
            price = 10;
        } else {
            if (rows % 2 == 0 && rowNum <= rows / 2) {
                price = 10;
            } else if (rows % 2 == 0 && rowNum > rows / 2) {
                price = 8;
            } else if (rows % 2 != 0 && rowNum > rows / 2) {
                price = 8;
            } else {
                price = 10;
            }
        }

        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (i == rowNum && j == seatNum) {
                    seatsArr[i][j] = "B";
                }
            }
        }

        System.out.println("Ticket price: $" + price);
    }
}
