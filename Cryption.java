package RSA;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;

public class Cryption {
    public static String encryption(String message , KeyPair key ){
        return (new BigInteger(message.getBytes(StandardCharsets.UTF_8))).modPow(key.getkey(),key.getN()).toString();

    }

    public static String deCryption(String message , KeyPair key) {
        String msg = new String(message.getBytes(StandardCharsets.UTF_8));
        return new String((new BigInteger(msg)).modPow(key.getKey(), key.getN()).toByteArray());
    }
}
