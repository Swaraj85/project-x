package com.swaraj.projectx.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsistentHashing {

    private long getSha256HashForData(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(data.getBytes());

        // Truncate to 64 bits (8 bytes)
        byte[] truncatedHash = new byte[8];
        System.arraycopy(hashBytes, 0, truncatedHash, 0, 8);

        // Convert bytes to a long
        long result = new BigInteger(1, truncatedHash).longValue();
        return result;
    }
}
