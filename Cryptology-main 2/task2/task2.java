package task2;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class task2 {
    public static void main(String[] args) throws Exception {
        String test1 = "The quick brown fox jumps over the lazy dog";
        String test2 = "sha";
        String test3 = "Sha";
        String test4 = "";

        System.out.println("Input Message: " + test1);
        System.out.println("SHA-1 Hash: " + sha1(test1));
        System.out.println("Input Message: " + test2);
        System.out.println("SHA-1 Hash: " + sha1(test2));
        System.out.println("Input Message: " + test3);
        System.out.println("SHA-1 Hash: " + sha1(test3));
        System.out.println("Input Message: " + test4);
        System.out.println("SHA-1 Hash: " + sha1(test4));
    }

    public static String sha1(String message) throws Exception {
        MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");

        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        byte[] digestBytes = sha1Digest.digest(messageBytes);

        StringBuilder hexString = new StringBuilder();
        for (byte b : digestBytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
