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

        int rowNum;
        int seatNum;

        int option, purchTickets = 0, cincome = 0;

        do {
            menu();
            option = input.nextInt();
            switch (option) {
                case 1:
                    printSeats(rows, seats, seatsArr);
                    break;
                case 2:
                    rowNum = inputRowNum();
                    seatNum = inputSeatNum();
                    buy(rows, seats, rowNum, seatNum, seatsArr);
                    purchTickets++;
                    cincome += priceT(rows, seats, rowNum);
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: " + purchTickets);
                    System.out.printf("Percentage: %.2f%%\n", (double)(purchTickets * 100) / (rows * seats));
                    System.out.println("Current income: $" + cincome);
                    System.out.println("Total income: $" + total(rows, seats));
                    break;
                case 0:
                    break;
            }
        } while(option != 0);
    }

    public static void menu() {
        System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
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

    public static void buyTicket(int rows, int seats, String[][] seatsArr, int rowNum, int seatNum) {
        buisySeat(rows, seats, rowNum, seatNum, seatsArr);
        System.out.println("Ticket price: $" + priceT(rows, seats, rowNum));
    }

    public static int priceT(int rows, int seats, int rowNum) {
        int price;
        int allSeats = rows * seats;
        if (allSeats <= 60) {
            price = 10;
        } else {
            if (rows % 2 == 0 && rowNum <= rows / 2) {
                price = 10;
            } else if (rows % 2 == 0 && rowNum > rows / 2) {
                price = 8;
            } else if (rows % 2 != 0 && rowNum <= rows / 2) {
                price = 10;
            } else {
                price = 8;
            }
        }
        return price;
    }

    public static void buisySeat(int rows, int seats, int rowNum, int seatNum, String[][] seatsArr) {
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (i == rowNum && j == seatNum) {
                    seatsArr[i][j] = "B";
                }
            }
        }
    }

    public static int total(int rows, int seats) {
        int allSeats = rows * seats;
        if (allSeats <= 60) {
            return 10 * allSeats;
        } else if (rows % 2 == 0) {
            return (10 * (seats * (rows / 2)) + 8 * (seats * (rows / 2)));
        } else {
            return (10 * (seats * (rows / 2)) + 8 * (seats * ((rows / 2) + 1)));
        }
    }

    public static int inputRowNum() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNum = input.nextInt();
        return rowNum;
    }

    public static int inputSeatNum() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a seat number in that row:");
        int seatNum = input.nextInt();
        return seatNum;
    }

    public static void buy(int rows, int seats, int rowNum, int seatNum, String[][] seatsArr) {
        if (rowNum <= rows && seatNum <= seats) {
            if (seatsArr[rowNum][seatNum] != "B") {
                buyTicket(rows, seats, seatsArr, rowNum, seatNum);
            } else {
                System.out.println("That ticket has already been purchased!");
                rowNum = inputRowNum();
                seatNum = inputSeatNum();
                buy(rows, seats, rowNum, seatNum, seatsArr);
            }
        } else {
            System.out.println("Wrong input!");
            rowNum = inputRowNum();
            seatNum = inputSeatNum();
            buy(rows, seats, rowNum, seatNum, seatsArr);
        }
    }
}
