/*
 * Class: CMSC203 
 * Instructor:Proffesor Tarek
 * Description: Project 3
 * Due: 10/17/2024
 * Platform/compiler:Ecllipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Sunpairre Tamene
*/
public class CryptoManager {
    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    public static boolean isStringInBounds(String plainText) {
        for (char ch : plainText.toCharArray()) {
            if (ch < LOWER_RANGE || ch > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }
    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }
        StringBuilder encryptedText = new StringBuilder();

        for (char ch : plainText.toCharArray()) {
            if (ch >= LOWER_RANGE && ch <= UPPER_RANGE) {
                int offset = ch + key;
                
                // Ensure the resulting character stays within the bounds of LOWER_RANGE and UPPER_RANGE
                while (offset > UPPER_RANGE) {
                    offset -= RANGE;  // Bring it back within the range
                }
                while (offset < LOWER_RANGE) {
                    offset += RANGE;  // Adjust for negative values
                }

                encryptedText.append((char) offset);
            } else {
                encryptedText.append(ch); // Append unchanged if out of bounds
            }
        }
        return encryptedText.toString();
    }


    public static String caesarDecryption(String encryptedText, int key) {
        if (!isStringInBounds(encryptedText)) {
            return "The selected string is not in bounds, Try again.";
        }
        StringBuilder decryptedText = new StringBuilder();
        for (char ch : encryptedText.toCharArray()) {
            if (ch >= LOWER_RANGE && ch <= UPPER_RANGE) {
                int offset = (ch - LOWER_RANGE - key + RANGE) % RANGE;
                if (offset < 0) {
                    offset += RANGE;
                }
                decryptedText.append((char) (LOWER_RANGE + offset));
            } else {
                decryptedText.append(ch);
            }
        }
        return decryptedText.toString();
    }

    public static String bellasoEncryption(String plainText, String bellasoStr) {
        StringBuilder encryptedText = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder();
        int keyLength = bellasoStr.length();
        
        for (int i = 0; i < plainText.length(); i++) {
            extendedKey.append(bellasoStr.charAt(i % keyLength));
        }

        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            char keyChar = extendedKey.charAt(i);
            int offset = (plainChar + keyChar - LOWER_RANGE) % RANGE;
            if (offset < 0) {
                offset += RANGE;
            }
            encryptedText.append((char) (LOWER_RANGE + offset));
        }
        return encryptedText.toString();
    }

    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder();
        int keyLength = bellasoStr.length();

        for (int i = 0; i < encryptedText.length(); i++) {
            extendedKey.append(bellasoStr.charAt(i % keyLength));
        }

        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char keyChar = extendedKey.charAt(i);
            int offset = (encryptedChar - keyChar - LOWER_RANGE) % RANGE;
            if (offset < 0) {
                offset += RANGE;
            }
            decryptedText.append((char) (LOWER_RANGE + offset));
        }
        return decryptedText.toString();
    }
}
