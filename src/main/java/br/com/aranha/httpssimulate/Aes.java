package br.com.aranha.httpssimulate;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static br.com.aranha.httpssimulate.Converter.convertBinary;
import static br.com.aranha.httpssimulate.Converter.printHexBinary;
public class Aes {
    public static String decryptMessage(String messageHexEncrypted, String passwordHex) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(convertBinary(passwordHex), "AES");
        byte[] textEncryptedBinary = convertBinary(messageHexEncrypted);
        byte[] iv = new byte[16];
        System.arraycopy(convertBinary(messageHexEncrypted), 0, iv, 0, 16);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] decipheredBytes = cipher.doFinal(textEncryptedBinary, 16, textEncryptedBinary.length-16);
        String hexBinary = printHexBinary(decipheredBytes);
        return new String(convertBinary(hexBinary));
    }

    public static String encryptMessage(String messageHexDecryptedInverse, String passwordHex) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Random random = new Random();
        SecretKey secretKey = new SecretKeySpec(convertBinary(passwordHex), "AES");
        byte[] iv = new byte[16];
        random.nextBytes(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] bytesEncryptedText = cipher.doFinal(convertBinary(messageHexDecryptedInverse));
        return printHexBinary(ByteBuffer.allocate(iv.length + bytesEncryptedText.length)
                .put(iv).put(bytesEncryptedText).array());
    }
}
