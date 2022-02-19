package project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderBMP {
    private File fileBMP;
    private int byteOffset;

    public ReaderBMP(File fileBMP){
        this.fileBMP = fileBMP;
        try {
            getByteOffset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFileBMP(File fileBMP) {
        this.fileBMP = fileBMP;
    }

    private void getByteOffset() throws IOException {
        try (RandomAccessFile randomAccessFileBMP = new RandomAccessFile(fileBMP, "r")) {
            randomAccessFileBMP.seek(10);
            byteOffset=0;
            for(int i = 0; i<4;i++){
                int buff = randomAccessFileBMP.readByte();
                byteOffset += buff<<(i*8);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void decodeTextInBMP() {
        RandomAccessFile randomAccessFileBMP = null;
        FileOutputStream fout = null;
        try{
            File contentFile = new File("src\\resources\\decode" + fileBMP.getName().replaceFirst("[.][^.]+$", ""));
            fout = new FileOutputStream(contentFile);
            randomAccessFileBMP = new RandomAccessFile(fileBMP, "r");
            randomAccessFileBMP.seek(byteOffset);
            int textBuffer;
            do{
                textBuffer = 0;
                for(int i=0;i<4;i++){
                    int buffer = randomAccessFileBMP.readByte();
                    textBuffer += (buffer&3)<<(3-i)*2;
                }
                if(textBuffer!=255) {
                    fout.write(textBuffer);
                }
                else
                    break;
            }while(true);
            System.out.println("File was decoding");
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (randomAccessFileBMP != null) {
                    randomAccessFileBMP.close();
                }
                if (fout != null) {
                    fout.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void encodeTextInBMP(String content) {
        RandomAccessFile randomAccessFileBMP = null;
        try{
            byte[] bytesContent = content.getBytes(StandardCharsets.UTF_8);
            randomAccessFileBMP = new RandomAccessFile(fileBMP, "rw");
            randomAccessFileBMP.seek(byteOffset);
            for (byte byteContent : bytesContent) {
                for (int j = 0; j < 4; j++) {
                    int buffer = randomAccessFileBMP.readByte();
                    buffer = (buffer & 252) + ((byteContent >> (3 - j) * 2) & 3);
                    randomAccessFileBMP.seek(randomAccessFileBMP.getFilePointer() - 1);
                    randomAccessFileBMP.writeByte(buffer);
                }
            }
            for(int j=0; j<4;j++) {
                int buffer = randomAccessFileBMP.readByte();
                buffer = (buffer & 252) + ((255>>(3-j)*2)&3);
                randomAccessFileBMP.seek(randomAccessFileBMP.getFilePointer()-1);
                randomAccessFileBMP.writeByte(buffer);
            }
            System.out.println("File was encoding");
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (randomAccessFileBMP != null) {
                    randomAccessFileBMP.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
