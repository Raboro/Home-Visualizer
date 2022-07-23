package HomeVisualizer.Encryption;

import java.util.Objects;

public class Hash {

    public static int hashUsername(String username) {
        return Objects.hashCode(username);
    }
}
