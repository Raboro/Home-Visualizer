package HomeVisualizer.Logic;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import HomeVisualizer.Encryption.Hash;
import HomeVisualizer.Encryption.RsaEncryption;

public class LoginLogic {
    private String username;
    private String password;
    private int hashedUsername;
    private byte[] encrytPassword;

    public LoginLogic(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void encryptUsername() {
        this.hashedUsername = Hash.hashUsername(username);
        System.out.println(hashedUsername);
    }

    public void encryptPassword() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, IOException {
        this.encrytPassword = RsaEncryption.encrypt(password);
    }

    public void decryptPassword() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
        String pw = RsaEncryption.decrypt(encrytPassword);
        System.out.println(pw);
    }
}
