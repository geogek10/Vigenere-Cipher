import java.util.Scanner;

/**
 * VigenereCipher
 */
public class VigenereCipher {

    // Initialize a 26x26 array
    public static String[][] abcArray = new String[26][26];
              
    // The alphabet string
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void Board() {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    abcArray[i][j] = String.valueOf(alphabet.charAt(j));
                }
                char firstLetter = alphabet.charAt(0);
                String restOfString = alphabet.substring(1);
            alphabet = restOfString + firstLetter;
            }
    }

    public static String Encryption(String key, String decryptedWord) {
        int keyAdd = 0;
        // the encrypted word
        String encryptedWord = "";
    
        Board();

        for (int k = 0; k < decryptedWord.length(); k++) {
            if (k >= key.length()) {
                if (k == key.length()) 
                    keyAdd = 0;
                String letterOfKey = String.valueOf(key.charAt(keyAdd));
                int indexOfLetterOfKey = alphabet.indexOf(letterOfKey);
                String letterOfDW = String.valueOf(decryptedWord.charAt(k));
                int indexOfLetterOfDW = alphabet.indexOf(letterOfDW);
                String letter = abcArray[indexOfLetterOfKey][indexOfLetterOfDW];

                encryptedWord += letter;
                
                keyAdd++;
            } else {
                String letterOfKey = String.valueOf(key.charAt(k));
                int indexOfLetterOfKey = alphabet.indexOf(letterOfKey);
                String letterOfDW = String.valueOf(decryptedWord.charAt(k));
                int indexOfLetterOfDW = alphabet.indexOf(letterOfDW);
                String letter = abcArray[indexOfLetterOfKey][indexOfLetterOfDW];

                encryptedWord += letter;
            }
        }

        return encryptedWord;
    }

    public static String Decryption(String key, String encryptedWord) {
        int keyLength = key.length() - 1;
        int indexLetter = 0;
        int keyAdd = 0;

        // the encrypted word
        String decryptedWord = "";
        
        Board();
        
        for (int k = 0; k < encryptedWord.length(); k++) {
            if (k >= keyLength) {
                if (k == keyLength || keyAdd == keyLength) 
                    keyAdd = 0;
                String keyLetter = String.valueOf(key.charAt(keyAdd));
                int keyLetterIndex = alphabet.indexOf(keyLetter);
    
                for (int l = 0; l < 26; l++) {
                    String letter = String.valueOf(encryptedWord.charAt(k));
    
                    if (abcArray[keyLetterIndex][l].equals(letter)) {
                        indexLetter = l;
                        break;
                    }
                }
    
                decryptedWord += abcArray[0][indexLetter];
        
                keyAdd++;
            } else {
                String keyLetter = String.valueOf(key.charAt(k));
                int keyLetterIndex = alphabet.indexOf(keyLetter);

                for (int l = 0; l < 26; l++) {
                    String letter = String.valueOf(encryptedWord.charAt(k));

                    if (abcArray[keyLetterIndex][l].equals(letter)) {
                        indexLetter = l;
                        break;
                    }
                }

                decryptedWord += abcArray[0][indexLetter];
            }
        }

        return decryptedWord;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to encrypt or decrypt message (encrypt, decrypt): ");
        String statement = scanner.nextLine().toLowerCase();

        if (statement.equals("encrypt")) {
            // key
            System.out.print("Input key: ");
            String key = scanner.nextLine().toUpperCase();

            // word we want to encrypt
            System.out.print("Input decrypted word: ");
            String decryptedWord = scanner.nextLine().toUpperCase();
            
            System.out.println(Encryption(key, decryptedWord));
        } else {
            // key
            System.out.print("Input key: ");
            String key = scanner.nextLine().toUpperCase();

            // word we want to decrypt
            System.out.print("Input encrypted word: ");
            String encryptedWord = scanner.nextLine().toUpperCase();
            
            System.out.println(Decryption(key, encryptedWord));
        }
        
    }
}
