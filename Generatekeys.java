package RSA;


import java.io.File;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.SecureRandom;

public class Generatekeys {
    public static void generateKey (File fileName , int bitlenght ){
        SecureRandom random = new SecureRandom();

        BigInteger p = new BigInteger(bitlenght/2,100 ,random);
        BigInteger q = new BigInteger(bitlenght/2 , 100, random);
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = new BigInteger("3");
        while (phiN.gcd(e).intValue()>1){
            e = e.add(new BigInteger("2"));
        }
        BigInteger d = e.modInverse(phiN);
        KeyPair publicKey = new KeyPair(e,n);
        KeyPair privetKey = new KeyPair(d,n);
        KeysFile.saveKey( fileName + "pulicKey" , publicKey );
        KeysFile.saveKey( fileName +"privatKey", privetKey);

    }

}
