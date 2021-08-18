package souschef.app.base;

import antlr.Token;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

public class TokenGenerator {

    private static SecureRandom random = new SecureRandom();
    private static byte bytes[] = new byte[128];

    public static String genToken(){
        random.nextBytes(bytes);
        Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return encoder.encodeToString(bytes);
    }

}