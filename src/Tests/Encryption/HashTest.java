package Tests.Encryption;

import org.junit.Assert;
import org.junit.Test;

import HomeVisualizer.Encryption.Hash;

public class HashTest  {
    
    @Test
    public void testHashWithDifferentInputs() {
        int hash1 = Hash.hashUsername("username");
        Assert.assertEquals(hash1, -265713450);

        int hash2 = Hash.hashUsername("TEst");
        Assert.assertEquals(hash2, 2572434);

        int hash3 = Hash.hashUsername("random");
        Assert.assertEquals(hash3, -938285885);

        int hash4 = Hash.hashUsername("1aghd7120");
        Assert.assertEquals(hash4, -1121975189);
    }

    @Test
    public void testHashWorksOnlyOnDirection() {
        int hash = Hash.hashUsername("check");
        int reverseHash = Hash.hashUsername(String.valueOf(hash));
        Assert.assertFalse(hash == reverseHash);
    }

    @Test
    public void testHashAreTheSame() {
        int hash1 = Hash.hashUsername("whats upü");
        int hash2 = Hash.hashUsername("whats upü");
        Assert.assertTrue(hash1 == hash2);

        int hash3 = Hash.hashUsername("adsasd");
        int hash4 = Hash.hashUsername("adsasd");
        Assert.assertTrue(hash3 == hash4);

        int hash5 = Hash.hashUsername("1286ßpoas7d10⁹");
        int hash6 = Hash.hashUsername("1286ßpoas7d10⁹");
        Assert.assertTrue(hash5 == hash6);
    }

    @Test
    public void testHashAreNotTheSame() {
        int hash1 = Hash.hashUsername("ad 1");
        int hash2 = Hash.hashUsername("whats 1231");
        Assert.assertFalse(hash1 == hash2);

        int hash3 = Hash.hashUsername("adasdadcad");
        int hash4 = Hash.hashUsername("12w13asf");
        Assert.assertFalse(hash3 == hash4);

        int hash5 = Hash.hashUsername("124asgf");
        int hash6 = Hash.hashUsername("1");
        Assert.assertFalse(hash5 == hash6);
    }

    @Test 
    public void testEmptyUsername() {
        int hash = Hash.hashUsername("");
        Assert.assertEquals(hash, 0);
    }

    @Test 
    public void testNull() {
        int hash = Hash.hashUsername(null);
        Assert.assertEquals(hash, 0);
    }
}