package br.com.patio.projeto.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public final class CryptoUtils {

    public static String md5(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(texto.getBytes()));
            String s2 = hash.toString(16);
            return s2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
