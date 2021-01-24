package RSA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.KeyPair;

public class KeysFile {
    public static KeyPair readKey (String fileName) {
        KeyPair key = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            key = (KeyPair) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Read key : "+ fileName);

        }catch (IOException e ){
            e.printStackTrace();
        }catch (ClassNotFoundException ee){
            ee.printStackTrace();
        }
        return key;

    }
    public static void saveKey(String fileName, KeyPair key) {
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            objectInputStream.close();
            System.out.println("saved key : "+ fileName);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
