package lt.viko.eif.rrabeckas.saugumas.aes;

import java.util.Scanner;

public class MyApp {
    //    public static void main(String[] args) {
//        EncryptionApp app = new EncryptionApp();
//        app.run();
//        System.out.println("App stopped");
//
//    }
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String secretKey = inputSecretKey();

        String originalString = inputMessage();
        String encryptedString = AES.encrypt(originalString, secretKey);
        String decryptedString = AES.decrypt(encryptedString, secretKey);

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }

    private static String inputSecretKey() {
        System.out.println("Enter secret key: ");
        return scanner.nextLine();
    }

    private static String inputMessage() {
        System.out.println("Enter message: ");
        return scanner.nextLine();
    }
}
