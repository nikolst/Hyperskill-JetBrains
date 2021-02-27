package cinema;

public class Cinema {

    public static void main(String[] args) {
        System.out.println("Cinema:");
        String[][] seat = new String[100][100];
        fillSeats(seat);
        printSeats(seat);
    }
    
    public static void fillSeats(String[][] seat) {
         seat[0][0] = " ";
         for (int i = 1; i < 8; i++) {
            seat[i][0] = Integer.toString(i);
         
            for (int j = 1; j < 9; j++) {
                seat[0][j] = Integer.toString(j);
                seat[i][j] = "S";
            }
        }
    }
    
    public static void printSeats(String[][] seat) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(seat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
