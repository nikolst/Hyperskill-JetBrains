package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int num = input.nextInt();

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                int code = ch[i];
                char transform = (char) (code + num);
                if (transform > 'z') {
                    int rest = transform - 122;
                    transform = (char) (rest + 96);
                }
                System.out.print(transform);
            } else  if (ch[i] >= 'A' && ch[i] <= 'Z') {
                int code = ch[i];
                char transform = (char) (code + num);
                if (transform > 'Z') {
                    int rest = transform - 90;
                    transform = (char) (rest + 64);
                }
                System.out.print(transform);
            } else {
                System.out.print(ch[i]);
            }
        }
    }
}
