package project;


import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        String key = "test Key";
        String content = "test1234 test5678 9876test";
        BlowFish blowFish = new BlowFish(key);

        byte[] tmpEncode = blowFish.encode(content.getBytes(StandardCharsets.UTF_8));
        byte[] tmpDecode = blowFish.decode(tmpEncode);

        System.out.println(new String(tmpDecode).replaceFirst("^\0*", ""));
    }
}
