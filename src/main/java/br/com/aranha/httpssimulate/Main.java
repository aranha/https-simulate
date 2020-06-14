package br.com.aranha.httpssimulate;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static br.com.aranha.httpssimulate.Converter.printHexBinary;
import static br.com.aranha.httpssimulate.GenerateValues.generateAValueHexadecimal;
import static br.com.aranha.httpssimulate.GenerateValues.generateBigVNumber;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        BigInteger bigVNumber = generateBigVNumber();
        String password = Sha256Password.generatePassword(bigVNumber);
        System.out.println("parte 1");
        System.out.println("  * valor a gerado de forma aleatória em hexadecimal: " + generateAValueHexadecimal());
        System.out.println("  * password: " + password);
        // iv + encryptedString - enviada pelo professor
        String messageEncrypted = "360235768BBEE00F1BE8E60DD55C2D6EA9A8AD1CE0BD546F7C8BB32942625C89888E5A54B432A1C15427FFF0B6E2473639DBEA7A6B9A240FB80591F108AA7F5F915BF229CE27E99A839126488BA403BBEBAB302478027647A84EBCBCE2FA9876";
        String messageDecrypted = Aes.decryptMessage(messageEncrypted, password);

        System.out.println("parte 2");
        System.out.println("  * mensagem clara: " + messageDecrypted);
        String messageDecryptedReversed = new StringBuilder(messageDecrypted).reverse().toString();
        System.out.println("  * mensagem clara inversa antes da cifragem " + messageDecryptedReversed);
        String messageDecryptedReversedHex = printHexBinary(messageDecryptedReversed.getBytes());
        String messageEncryptedReversed = Aes.encryptMessage(messageDecryptedReversedHex, password);
        System.out.println("  * mensagem invertida e cifrada: " + messageEncryptedReversed);
        String messageDecryptedReversedDecrypted =  Aes.decryptMessage(messageEncryptedReversed, password);
        System.out.println("  * mensagem clara decriptada inversa: " + messageDecryptedReversedDecrypted);
    }
}
