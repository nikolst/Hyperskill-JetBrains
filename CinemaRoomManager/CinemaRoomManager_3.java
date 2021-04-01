package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = input.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numSeats = input.nextInt();
        String[][] seat = new String[rows + 1][numSeats + 1];
        cinemaSeats(rows, numSeats, seat);
        
        System.out.println("Cinema:");
        printSeats(rows, numSeats, seat);
        System.out.println();
        
        System.out.println("Enter a row number:");
        int rowNum = input.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNum = input.nextInt();
        
        calculations(rows, rowNum, numSeats);
        System.out.println();
        
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < numSeats + 1; j++) {
                if (i == rowNum && j == seatNum) {
                    seat[i][j] = "B";
                }
            }
        }
        
        System.out.println("Cinema:");
        printSeats(rows, numSeats, seat);   
    }
    
    public static void cinemaSeats(int rows, int numSeats, String[][] seat) {
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < numSeats + 1; j++) {
                if (i == 0 && j == 0) {
                    seat[i][j] = " ";
                } else if (i == 0 && j != 0) {
                    seat[i][j] = String.valueOf(j);
                } else if (i != 0 && j == 0) {
                    seat[i][j] = String.valueOf(i);
                } else {
                    seat[i][j] = "S";
                }
            }
        }
    }
    
    public static void printSeats(int rows, int numSeats, String[][] seat) {
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < numSeats + 1; j++) {
                System.out.print(seat[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
    public static void calculations(int rows, int rowNum, int numSeats) {
        int price;
        int allSeats = rows * numSeats;
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
        System.out.println("Ticket price: $" + price);
    }
}
