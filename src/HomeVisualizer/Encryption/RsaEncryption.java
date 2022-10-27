package HomeVisualizer.Encryption;

import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RsaEncryption {

    public static byte[] encrypt(String message) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeySpecException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        PublicKey publicKey = getPublicKey();

        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] secretMessageBytes = message.getBytes(StandardCharsets.UTF_8);

        return encryptCipher.doFinal(secretMessageBytes);
    }

    private static PublicKey getPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        File publicKeyFile = new File("/home/marius/Documents/abgabe_info/abgabe/public.key");
        byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);

        return keyFactory.generatePublic(publicKeySpec);
    }

    public static String decrypt(byte[] message) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        PrivateKey privateKey = getPrivateKey();

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedMessageBytes = decryptCipher.doFinal(message);

        return new String(decryptedMessageBytes, StandardCharsets.UTF_8);
    }

    private static PrivateKey getPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        File privateKeyFile = new File("/home/marius/Documents/abgabe_info/abgabe/private.key");
        byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);

        return keyFactory.generatePrivate(privateKeySpec);
    }
}