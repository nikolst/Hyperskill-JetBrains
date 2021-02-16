package encryptdecrypt;

public class Main {

    String mode;
    int key;
    String data;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        if ("".equals(mode)) {
            this.mode = "enc";
        } else {
            this.mode = mode;
        }
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if ("".equals(String.valueOf(key))) {
            this.key = 0;
        } else {
            this.key = key;
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if ("".equals(data)) {
            this.data = "";
        } else {
            this.data = data;
        }
    }

    public static void encryption(String str, int num) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int code = ch[i];
            char transform = (char) ((code + num));
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
        boolean decrypter = false;
        Main m = new Main();

        for (int i = 1; i < args.length; i+=2) {
            if (args[i].equals("dec") && args[i - 1].equals("-mode"))
                decrypter = true;
            else if (args[i].matches("\\d+") && args[i - 1].equals("-key"))
                m.key = Integer.parseInt(args[i]);
            else if (args[i].matches("^.*$") && args[i - 1].equals("-data"))
                m.data = args[i];
        }
        if (!decrypter) {
            encryption(m.getData(), m.getKey());
        } else {
           decryption(m.getData(), m.getKey());
        }
    }
}
