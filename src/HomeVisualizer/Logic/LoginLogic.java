package HomeVisualizer.Logic;

import java.io.IOException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import java.sql.SQLException;

import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import HomeVisualizer.Database.LoginDatabase;

import HomeVisualizer.Encryption.Hash;
import HomeVisualizer.Encryption.RsaEncryption;

public class LoginLogic {

    private final LoginDatabase loginDatabase = new LoginDatabase();
    private final String username;
    private final String password;
    private String encodedPassword;
    private int hashedUsername;

    public LoginLogic(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private void encryptUsername() {
        hashedUsername = Hash.hashUsername(username);
    }

    private void encryptPassword() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] encryptPassword = RsaEncryption.encrypt(password);
        encodedPassword = Base64.getEncoder().encodeToString(encryptPassword);
    }

    private String decryptPassword(byte[] encryptedPasswordOfDatabase)
            throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
        return RsaEncryption.decrypt(encryptedPasswordOfDatabase);
    }

    public void signUp() throws SQLException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, IOException {
        encryptUsername();
        encryptPassword();
        loginDatabase.add(hashedUsername, encodedPassword);
    }

    public boolean login() throws SQLException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
        encryptUsername();
        String passwordOfDatabase = loginDatabase.get(hashedUsername);

        if (passwordOfDatabase == null) {
            return false;
        }

        byte[] encryptedPasswordOfDatabase = Base64.getDecoder().decode(passwordOfDatabase);
        String decodedPasswordOfDatabase = decryptPassword(encryptedPasswordOfDatabase);
        return decodedPasswordOfDatabase.equals(password);
    }
}