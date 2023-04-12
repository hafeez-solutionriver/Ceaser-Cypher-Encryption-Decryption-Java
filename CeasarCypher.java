import java.util.Scanner;

public class CeasarCipher {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("1. Encrypt a Text");
            System.out.println("2. Decrypt a Cipher");
            System.out.println("3. Decrypt a Text ( Using XOR ) ");
            System.out.println("4. Exit");
            System.out.print("Enter Your Option (1-4): ");
            choice = Integer.parseInt(scan.nextLine());

            if (choice == 1) {
                System.out.print("Enter the plaintext to encrypt: ");
                String plaintext = scan.nextLine();
                System.out.print("Enter the number of positions to shift: ");
                int shift = Integer.parseInt(scan.nextLine());
                String ciphertext = encrypt(plaintext, shift);
                System.out.println("Encrypted Text: " + ciphertext);
            } else if (choice == 2) {
                System.out.print("Enter the ciphertext to decrypt: ");
                String ciphertext = scan.nextLine();
                System.out.println("All possible plaintexts:");
                for (int shift = 0; shift < 26; shift++) {
                    String plaintext = decrypt(ciphertext, shift);
                    System.out.println("Shift " + shift + ": " + plaintext);
                }
            }

            else if (choice == 3) {
                System.out.print("Enter the plaintext to encrypt: ");
                String plaintext = scan.nextLine();
                System.out.print("Enter a key:  ");
                String shift = scan.nextLine();
                String ciphertext = xorEncrypt(plaintext, shift);
                System.out.println("Encrypted Text using OR: " + ciphertext);
            }
            

            System.out.println("\n");
        } while (choice != 4);
    }


    public static String encrypt(String plaintext, int shift) {
        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                int ascii = (int) c;
                int shiftedAscii = ascii + shift;
                if (Character.isUpperCase(c)) {
                    shiftedAscii = (shiftedAscii - 65) % 26 + 65;
                } else {
                    shiftedAscii = (shiftedAscii - 97) % 26 + 97;
                }
                c = (char) shiftedAscii;
            }
            ciphertext += c;
        }
        return ciphertext;
    }


    public static String decrypt(String ciphertext, int shift) {
        return encrypt(ciphertext, 26 - shift);
    }


    public static String xorEncrypt(String input, String key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int inputChar = (int) input.charAt(i);
            int keyChar = (int) key.charAt(i % key.length());
            int encryptedChar = inputChar ^ keyChar;
            output.append((char) encryptedChar);
        }

        return output.toString();
    }


}
