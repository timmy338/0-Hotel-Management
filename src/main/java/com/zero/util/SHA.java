package com.zero.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA {
    private static final String KEY_SHA = "SHA";
    public static final String THE_SALT="ihb142798h9ufaiuhjdaqs09812";

    public static String getResult(String inputStr) {
        BigInteger sha;
        String outputData=null;
        String inputAndSalt=inputStr.concat(THE_SALT);
        byte[] inputData = inputAndSalt.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            outputData=sha.toString(32);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputData;
    }

    public static boolean equals(String text,String digest)
    {
        return getResult(text).equals(digest);
    }
}
