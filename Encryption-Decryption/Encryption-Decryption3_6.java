package encryptdecrypt;

import java.util.Scanner;

public class Main {

    public static void operation(String choice, String str, int num) {
        switch (choice) {
            case "enc":
                encryption(str, num);
                break;
            case "dec":
                decryption(str, num);
                break;
            default:
                System.out.println("You should choose between enc and dec!");
        }
    }

    public static void encryption(String str, int num) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int code = ch[i];
            char transform = (char) (code + num);
            System.out.print(transform);
        }
    }

    public static void decryption(String str, int num) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int code = ch[i];
            char transform = (char) (code - num);
            System.out.print(transform);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        String str = input.nextLine();
        int num = input.nextInt();

        operation(choice, str, num);
    }
}
