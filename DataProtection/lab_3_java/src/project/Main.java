package project;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        ReaderBMP readerBMP = new ReaderBMP(new File("src\\resources\\LAB_3_ENCODE_BMP\\6.bmp"));
        readerBMP.decodeTextInBMP();
        readerBMP.setFileBMP(new File("src\\resources\\LAB_3_ENCODE_BMP\\9.bmp"));
        readerBMP.encodeTextInBMP("Slim shady тест русского языка");
        readerBMP.decodeTextInBMP();
    }
}
