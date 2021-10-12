import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

public class CreatingDigitalSignature {
  public static void main(String args[]) throws Exception {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter some text");

    String msg = scan.nextLine();
    scan.close();

    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

    keyPairGen.initialize(2048);
    KeyPair pair = keyPairGen.generateKeyPair();

    PrivateKey privKey = pair.getPrivate();

    Signature sign = Signature.getInstance("SHA256withDSA");
    sign.initSign(privKey);
    byte[] bytes = msg.getBytes();

    sign.update(bytes);

    byte[] signature = sign.sign();

    System.out.println("Digital signature for given text: " +
                       new String(signature, "UTF8"));
  }
}
