package RSA;

import java.security.KeyPair;

public class Main {
    public static void main(String[] args) {
        int bitlenght = 4096;
        KeyPair publicKey = KeysFile.readKey("publicKey");
        KeyPair privatKey = KeysFile.readKey("privatKey");
        String enCryption = Cryption.encryption("message ", publicKey);
        String deCryption = Cryption.deCryption(enCryption , privatKey);
        System.out.println(" >> "+ deCryption);

    }
}
