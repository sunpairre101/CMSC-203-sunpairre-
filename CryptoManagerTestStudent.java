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

import static org.junit.Assert.*;
import org.junit.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("CRYPTOGRAPHY"));
        assertTrue(CryptoManager.isStringInBounds("HELLO WORLD"));
        assertFalse(CryptoManager.isStringInBounds("cryptography")); // Lowercase letters out of bounds
        assertFalse(CryptoManager.isStringInBounds("{CRYPTOGRAPHY")); // Curly brace out of bounds
        assertFalse(CryptoManager.isStringInBounds("THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE")); // Curly brace out of bounds
    }

    @Test
    public void testEncryptCaesar() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("bye", 3));
        assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
        assertEquals("1.558", CryptoManager.caesarEncryption("HELLO", 105)); // Adjust as needed
        assertEquals("UFTUJOH", CryptoManager.caesarEncryption("TESTING", 1));
        assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("TESTING", CryptoManager.caesarDecryption("UFTUJOH", 1));
        assertEquals("TESTING ANOTHER STRING", CryptoManager.caesarDecryption(";,:;05.G(56;/,9G:;905.", 999)); // This should be a valid string based on the character range
        assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("4188;LC;>80", 300)); // This should be a valid string based on the character range
        assertEquals("THIS IS ANOTHER TEST", CryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
    }

    @Test
    public void testEncryptBellaso() {
        assertEquals("WN#\\N &", CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
        assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO"));
        assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203"));
    }

    @Test
    public void testDecryptBellaso() {
        assertEquals("TESTING", CryptoManager.bellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
        assertEquals("MERRY CHRISTMAS", CryptoManager.bellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
        assertEquals("THIS IS ANOTHER TEST", CryptoManager.bellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CMSC203"));
    }
}
