package br.com.aranha.httpssimulate;

import java.math.BigInteger;

import static br.com.aranha.httpssimulate.Converter.convertHexToNumber;

public class GenerateValues {
    public static BigInteger generateBigVNumber(){
        BigInteger aNumber = new BigInteger("83389976680892099750334060086758598137113243205030139027661584932554485310768393262534403474703989680369327449437353807660012807389984718814976013546186738445197344848527762972048664166478175328274519424596433304273808013829040856558136343188297534348828039159433641152527925925397520075165117974147403464922");
        BigInteger pNumber = convertHexToNumber(getPHexadecimal());
        BigInteger bigBNumber = convertHexToNumber(getBigBHexadecimal());
        return bigBNumber.modPow(aNumber, pNumber);
    }

    // sent to professor
    public static String generateAValueHexadecimal(){
//        BigInteger pNumber = convertHexToNumber(getPHexadecimal());
//        BigInteger gNumber = convertHexToNumber(getGHexadecimal());
//        Random random = new Random();
//        BigInteger aNumber = new BigInteger(pNumber.bitLength()-1, random);
//        // A = gNumber^aNumber mod pNumber
//        BigInteger bigADecimal = gNumber.modPow(aNumber, pNumber);
//        return bigADecimal.toString(16);
        return "253ecd94cdc665c2cbfaa20146bd5db4b620a1d16558004c07cd34826a8cf99c6843eeaafbf8d0ca29f0e8d42461e646d4960a4c237226b913db88fa29b75a99e90898b1caf6134d6d1a2d5dfff40fc9bee9eb3d892f53922ae195c85fad7e42c40bab76fad13f628c526c3b810989d937bf9c986adaa5de5b20bb5590b5cd95";
    }

    public static String getBigBHexadecimal(){
        return "62F9676A348BDE14BE53DD21FC54558415A9E19A3304C6CEFA6182C2E5E235D6BD12C56D5D18CDCB9A2C277608A7519CEE1E2FAF5908E191D0C93E39585D77384ED2F85366A94FB87C2DF9E0104E43D0CBC23F0AB9269DDD5F111EB9DB5A2AC5650C6A465AEAB1658C8F82F859F8E199B19F907E4F83BDE730F20D05130D1DF5";
    }

    private static String getPHexadecimal(){
        return "B10B8F96A080E01DDE92DE5EAE5D54EC52C99FBCFB06A3C69A6A9DCA52D23B616073E28675A23D189838EF1E2EE652C013ECB4AEA906112324975C3CD49B83BFACCBDD7D90C4BD7098488E9C219A73724EFFD6FAE5644738FAA31A4FF55BCCC0A151AF5F0DC8B4BD45BF37DF365C1A65E68CFDA76D4DA708DF1FB2BC2E4A4371";
    }

    private static String getGHexadecimal(){
        return "A4D1CBD5C3FD34126765A442EFB99905F8104DD258AC507FD6406CFF14266D31266FEA1E5C41564B777E690F5504F213160217B4B01B886A5E91547F9E2749F4D7FBD7D3B9A92EE1909D0D2263F80A76A6A24C087A091F531DBF0A0169B6A28AD662A4D18E73AFA32D779D5918D08BC8858F4DCEF97C2A24855E6EEB22B3B2E5";
    }
}