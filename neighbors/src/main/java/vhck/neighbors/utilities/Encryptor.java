package vhck.neighbors.utilities;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

	public static String encryptForMD5(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            BigInteger bi = new BigInteger(1, digest.digest());
            return bi.toString(16);
        } catch (NoSuchAlgorithmException ns) {
            ns.printStackTrace();
            return password;
        }
    }
}
