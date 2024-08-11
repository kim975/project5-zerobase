package com.zerobase.project5.common.encrypt;

import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class EncryptComponent {

    private final String secretKey = "123456789012345678901234";
    private final Base64.Encoder encoder = Base64.getEncoder();
    private final Base64.Decoder decoder = Base64.getDecoder();

    public String decryptString(String decryptString) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {

        return new String(cipherPkc5(Cipher.DECRYPT_MODE, secretKey).doFinal(decoder.decode(decryptString.getBytes(StandardCharsets.UTF_8))));
    }

    public String encryptString(String encryptString) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        return new String(encoder.encode(cipherPkc5(Cipher.ENCRYPT_MODE, secretKey).doFinal(encryptString.getBytes(StandardCharsets.UTF_8))));
    }

    private Cipher cipherPkc5(int opMode, String secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec sk = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec iv = new IvParameterSpec(secretKey.substring(0, 16).getBytes(StandardCharsets.UTF_8));
        c.init(opMode, sk, iv);

        return c;
    }


}
