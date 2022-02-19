package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadKeyFile {
    private File keyFile;

    ReadKeyFile(File keyFle) {
        this.keyFile = keyFle;
    }

    public void setKeyFile(File keyFile) {
        this.keyFile = keyFile;
    }

    public void readFile(int[] key) {
        try (FileInputStream fin = new FileInputStream(keyFile)) {
            int buffer, counter = 0;
            while ((buffer = fin.read()) != -1) {
                key[buffer - 49] = counter;
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
