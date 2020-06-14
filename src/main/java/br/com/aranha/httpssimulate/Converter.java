package br.com.aranha.httpssimulate;

import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;

public class Converter {
    public static BigInteger convertHexToNumber(String hex){
        return new BigInteger(hex, 16);
    }

    public static byte[] convertBinary(String text) {
        return DatatypeConverter.parseHexBinary(text);
    }

    public static String printHexBinary(byte[] bytes){
        return DatatypeConverter.printHexBinary(bytes);
    }
}
