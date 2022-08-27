package Tests.Encryption;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Assert;
import org.junit.Test;

import HomeVisualizer.Encryption.RsaEncryption;

public class RsaEncryptionTest {
    
    @Test
    public void encryptSamePasswordMultipleTimesNotTheSame() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] msg1 = RsaEncryption.encrypt("Hello");
        byte[] msg2 = RsaEncryption.encrypt("Hello");
        Assert.assertFalse(msg1 == msg2);

        byte[] msg3 = RsaEncryption.encrypt("adadadasdaw");
        byte[] msg4 = RsaEncryption.encrypt("adadadasdaw");
        Assert.assertFalse(msg3 == msg4);

        byte[] msg5 = RsaEncryption.encrypt("Wahasdnn");
        byte[] msg6 = RsaEncryption.encrypt("Wahasdnn");
        Assert.assertFalse(msg5 == msg6);

        byte[] msg7 = RsaEncryption.encrypt("13989651390uj");
        byte[] msg8 = RsaEncryption.encrypt("13989651390uj");
        Assert.assertFalse(msg7 == msg8);
    }

    @Test
    public void encryptDifferentPasswordMultipleTimesNotTheSame() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] msg1 = RsaEncryption.encrypt("Hello");
        byte[] msg2 = RsaEncryption.encrypt("awfagae");
        Assert.assertFalse(msg1 == msg2);

        byte[] msg3 = RsaEncryption.encrypt("adadadasdaw");
        byte[] msg4 = RsaEncryption.encrypt("w31");
        Assert.assertFalse(msg3 == msg4);

        byte[] msg5 = RsaEncryption.encrypt("Wahasdnn");
        byte[] msg6 = RsaEncryption.encrypt("ß9451 4");
        Assert.assertFalse(msg5 == msg6);

        byte[] msg7 = RsaEncryption.encrypt("ß856 13ugjka");
        byte[] msg8 = RsaEncryption.encrypt("13989651390uj");
        Assert.assertFalse(msg7 == msg8);
    }

    @Test
    public void decryptSamePasswordMultipleTimesAreTheSame() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, IOException {
        String msg1 = "Hello"; 
        byte[] encryptMsg1 = RsaEncryption.encrypt(msg1);
        String decryptMsg1 = RsaEncryption.decrypt(encryptMsg1);
        Assert.assertEquals(msg1, decryptMsg1);

        String msg2 = "988164016ß2654ß17"; 
        byte[] encryptMsg2 = RsaEncryption.encrypt(msg2);
        String decryptMsg2 = RsaEncryption.decrypt(encryptMsg2);
        Assert.assertEquals(msg2, decryptMsg2);

        String msg3 = "02976z zisldkh452    ß987"; 
        byte[] encryptMsg3 = RsaEncryption.encrypt(msg3);
        String decryptMsg3 = RsaEncryption.decrypt(encryptMsg3);
        Assert.assertEquals(msg3, decryptMsg3);
    }

    @Test
    public void decryptDifferentPasswordMultipleTimesNotTheSame() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, IOException {
        String msg1 = "e2hrewsgdsh"; 
        byte[] encryptMsg1 = RsaEncryption.encrypt("Hello");
        String decryptMsg1 = RsaEncryption.decrypt(encryptMsg1);
        Assert.assertNotEquals(msg1, decryptMsg1);

        String msg2 = "988164016ß2654ß17"; 
        byte[] encryptMsg2 = RsaEncryption.encrypt("öigs03e87");
        String decryptMsg2 = RsaEncryption.decrypt(encryptMsg2);
        Assert.assertNotEquals(msg2, decryptMsg2);

        String msg3 = "02976z zisldkh452    ß987"; 
        byte[] encryptMsg3 = RsaEncryption.encrypt("foier6298pkjshdf");
        String decryptMsg3 = RsaEncryption.decrypt(encryptMsg3);
        Assert.assertNotEquals(msg3, decryptMsg3);
    }
}