package project;

import java.io.*;
import java.util.HashMap;

public class FileWorker {
    private File file;

    FileWorker(File file){
        this.file = file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getFileSize() {
        return file.length();
    }

    public void frequencyBytes(HashMap<Integer, Integer> frequencyByte){
        try (FileInputStream fin = new FileInputStream(file)) {
            Integer buffer;
            while ((buffer = fin.read()) != -1) {
                frequencyByte.put(buffer, frequencyByte.getOrDefault(buffer, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encodeFile(int[] key){
        File encodeFile = new File("src\\resources\\encode_" + file.getName().replaceFirst("[.][^.]+$", ""));
        try(FileOutputStream outEncodeFile = new FileOutputStream(encodeFile);
            RandomAccessFile randomAccessFile  = new RandomAccessFile(file, "r")) {
            for (int numberKey : key) {
                randomAccessFile.seek(numberKey);
                int counter = 0;
                int buffer;
                while ((buffer = randomAccessFile.read()) != -1) {
                    outEncodeFile.write(buffer);
                    randomAccessFile.seek(randomAccessFile.getFilePointer() + key.length - 1);
                    counter++;
                }
                if (file.length() % key.length != 0 && counter < file.length() / key.length + 1) {
                    outEncodeFile.write('z');
                }
            }
            System.out.println("File was encoding");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void decodeFile(int[] key) {
        File encodeFile = new File("src\\resources\\encode_" + file.getName().replaceFirst("[.][^.]+$", ""));
        File decodeFile = new File("src\\resources\\decode_" + file.getName().replaceFirst("[.][^.]+$", ""));
        try (RandomAccessFile randomAccessFileEncode = new RandomAccessFile(encodeFile, "r");
             FileOutputStream foutDecode = new FileOutputStream(decodeFile)){
            long NumberOfLines = encodeFile.length()/key.length;
            byte[] buffer = new byte[key.length];

            for(int i = 0; i < NumberOfLines-1;i++){
                for(int j = 0; j < key.length; j++){
                    randomAccessFileEncode.seek(i + (long) j * NumberOfLines);
                    buffer[key[j]]=randomAccessFileEncode.readByte();
                }
                foutDecode.write(buffer);
            }
            for(int j = 0; j < key.length; j++){
                randomAccessFileEncode.seek(NumberOfLines-1 + (long) j * NumberOfLines);
                buffer[key[j]]=randomAccessFileEncode.readByte();
            }
            foutDecode.write(contentNoZ(buffer));
            System.out.println("File was decoding");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] contentNoZ(byte[] content){
        int count = 5;
        for(int i = content.length-1; i > 0; i--){
            if(content[i]=='z'){
                count--;
            }
        }
        byte[] contentNoZ = new byte[count];
        System.arraycopy(content, 0, contentNoZ, 0, count);
        return contentNoZ;
    }
}
