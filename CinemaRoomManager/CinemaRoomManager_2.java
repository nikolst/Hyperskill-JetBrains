package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        String[][] seat = new String[9][20];
        calculations(seat);
    }
    
    public static void calculations(String[][] seat) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = input.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numSeats = input.nextInt();
        int result = 0;
        int fHalf, sHalf;
        if (rows * numSeats <= 60) {
            result = rows * numSeats * 10;
        } else if (rows % 2 != 0) {
            fHalf = ((rows / 2) * numSeats) * 10;
            sHalf = (((rows / 2) + 1) * numSeats) * 8;
            result = fHalf + sHalf;
        } else {
            fHalf = (rows / 2) * numSeats * 10;
            sHalf = (rows / 2) * numSeats * 8;
            result = fHalf + sHalf;
        }
        System.out.println("Total income:\n$" + result);
    }
}
