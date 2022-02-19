package project;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RSA rsa = new RSA(100);
        ArrayList<Long> encodeContent = rsa.encodeRSA("КАФСИ");
        System.out.println(encodeContent);
        System.out.println(rsa.decodeRSA(encodeContent));
    }
}
