package br.com.aranha.httpssimulate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static br.com.aranha.httpssimulate.Converter.convertBinary;
import static br.com.aranha.httpssimulate.Converter.printHexBinary;

public class Sha256Password {
    //bigVNumber = B^a mod p
    public static String generatePassword(BigInteger bigVNumber) throws NoSuchAlgorithmException {
        String bigVNumberHexadecimal = printHexBinary(bigVNumber.toByteArray());
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(convertBinary(bigVNumberHexadecimal));
        byte[] bigSEncryptedBytes = messageDigest.digest();
        String bigSEncryptedString = printHexBinary(bigSEncryptedBytes);
        // 1 char of hexadecimal = 4 bits or 0.5 byte so 32 chars means 128 bits or 16 bytes
        return bigSEncryptedString.substring(0, 32);
    }
}
