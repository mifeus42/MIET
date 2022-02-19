package project;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final int keySize = 5;

    public static void main(String[] args) {
        File keyFile = new File("src\\resources\\key.txt");
        ReadKeyFile readKeyFile = new ReadKeyFile(keyFile);
        int[] key = new int[keySize];
        readKeyFile.readFile(key);

        File file = new File("src\\resources\\bee-on-daisy.jpg");
        FileWorker fileWorker = new FileWorker(file);

        System.out.println(fileWorker.getFileSize());

        HashMap<Integer, Integer> frequencyByte = new HashMap<>();
        fileWorker.frequencyBytes(frequencyByte);
        Set<Map.Entry<Integer, Integer>> entries = frequencyByte.entrySet();
        for (Map.Entry<Integer, Integer> s : entries) {
            System.out.println(s);
        }

        fileWorker.encodeFile(key);
        fileWorker.decodeFile(key);
    }
}
