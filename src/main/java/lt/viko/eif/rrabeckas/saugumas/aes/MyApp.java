package lt.viko.eif.rrabeckas.saugumas.aes;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyApp {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        final String secretKey = inputSecretKey();

        String originalString = inputMessage();
        String encryptedString = "";
        while (true) {
            String choice = getChoice();
            if (choice.equals("encrypt")) {
                encryptedString = AES.encrypt(originalString, secretKey);
                System.out.println(originalString);
                System.out.println(encryptedString);
                saveToFile(encryptedString);
            } else if (choice.equals("decrypt")) {
                encryptedString = AES.encrypt(originalString, secretKey);
                String decryptedString = AES.decrypt(encryptedString, secretKey);
                System.out.println(originalString);
                System.out.println(decryptedString);
            }
        }
    }

    private static void saveToFile(String encryptedString) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter("filename.txt")) {
            out.println(encryptedString);
        }
    }

    private static String getChoice() {
        boolean status = true;
        String choice = "";
        while (status) {
            System.out.println("Enter number to select mode: ");
            System.out.println("1.: encrypt ");
            System.out.println("2.: decrypt ");
            Scanner scanner = new Scanner(System.in);
            String choiceInput = scanner.nextLine();
            if (choiceInput.equals("1")) {
                choice = "encrypt";
                status = false;
            } else if (choiceInput.equals("2")) {
                choice = "decrypt";
                status = false;
            }
        }
        return choice;
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
