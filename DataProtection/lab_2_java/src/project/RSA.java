package project;

import java.util.*;

public class RSA {
    private final Key key;
    private static final HashMap<Character,Integer> tableEquivalenceEncode;
    private static final HashMap<Integer,Character> tableEquivalenceDecode;
    static {
        tableEquivalenceEncode = new HashMap<>(44);
        tableEquivalenceEncode.put('ё', 7);
        tableEquivalenceEncode.put(' ', 34);
        for(int i = 1; i <= 6; i++){
            tableEquivalenceEncode.put((char)(i+'а' - 1), i);
        }
        for(int i = 8; i <= 33; i++){
            tableEquivalenceEncode.put((char)(i+'а' - 2), i);
        }
        for(int i = 35; i <= 44; i++){
            tableEquivalenceEncode.put((char)(i-35+'0'), i);
        }
    }
    static {
        tableEquivalenceDecode = new HashMap<>(44);
        for (Map.Entry<Character,Integer> e : tableEquivalenceEncode.entrySet()) {
            tableEquivalenceDecode.put(e.getValue(), e.getKey());
        }
    }

    public RSA(int primeNumberMax){
        this.key = new Key(primeNumberMax);
    }

    public ArrayList<Long> encodeRSA(String content){
        ArrayList<Long> encodeContent = new ArrayList<>();
        for(char symbol : content.toCharArray()){
            encodeContent.add(binPow(tableEquivalenceEncode.get(Character.toLowerCase(symbol)), key.openKey, key.keyPart2));
        }
        encodeContent.trimToSize();
        return encodeContent;
    }

    public String decodeRSA(ArrayList<Long> encodeContent){
        StringBuilder decodeContent = new StringBuilder();
        for(long number : encodeContent){
            decodeContent.append(tableEquivalenceDecode.get((int)binPow(number, key.closeKey, key.keyPart2)));
        }
        return decodeContent.toString();
    }

    private static long binPow(long a, long b, int m) {
        a %= m;
        if (b == 0) return 1;
        else if (b % 2 == 0) {
            return binPow((a * a) % m, b / 2, m);
        }
        else return (a * binPow(a, b - 1, m)) % m;
    }

    public void printKey()
    {
        key.printKey();
    }

    private static class Key {
        private int openKey;
        private int closeKey;
        private int keyPart2;

        public Key(int primeNumberMax){
            primeNumberMax = Math.max(primeNumberMax, 12);
            int primeNumber1;
            int primeNumber2;
            while((primeNumber2=randomPrimeNumber(primeNumberMax))==(primeNumber1 = randomPrimeNumber(primeNumberMax)) || primeNumber1*primeNumber2<44);
            OpenKeyCalculation(primeNumber1, primeNumber2);
            CloseKeyCalculation(primeNumber1, primeNumber2);
        }
        private void printKey()
        {
            System.out.println("Open: "+ openKey+" " + keyPart2);
            System.out.println("Close: "+closeKey + " "+ keyPart2);
        }

        private void OpenKeyCalculation(int number1, int number2){
            keyPart2 = number1*number2;
            openKey = randomCoPrimeNumber(eulerFunction(number1,number2));
        }

        private void CloseKeyCalculation(int primeNumber1, int primeNumber2){
            int resultEulerFunc = eulerFunction(primeNumber1,primeNumber2);
            double result;
            int count = 1;
            do {
                result = (count*resultEulerFunc+1)/ ((double) openKey);
                count++;
            }while(result != (int) result);
            closeKey = (int) result;
        }

        private int eulerFunction(int number1, int number2){
            return (number1-1)*(number2-1);
        }

        private int randomCoPrimeNumber(int number){
            int randomNumber;
            do {
                randomNumber = (int) (Math.random() * number);
            }while(!isCoPrime(randomNumber, number));
            return randomNumber;
        }

        private boolean isCoPrime(int number1, int number2){
            while(number1!=number2){
                if(number1>number2){
                    number1-=number2;
                }
                else{
                    number2-=number1;
                }
            }
            return number1==1;
        }

        private int randomPrimeNumber(int primeNumberMax){
            int randomNumber;
            boolean[] isPrimeNumbers = sieveEratosthenes(primeNumberMax+1);
            while(!isPrimeNumbers[randomNumber = (int) (Math.random() * primeNumberMax)]);
            return randomNumber;
        }

        private boolean[] sieveEratosthenes(int N){
            boolean[] isPrimeNumbers = new boolean[N];
            Arrays.fill(isPrimeNumbers, true);
            isPrimeNumbers[0] = false;
            isPrimeNumbers[1] = false;
            for (int i=2; i*i < N; i++) {
                if (isPrimeNumbers[i]) {
                    for (int j = i * i; j < N; j += i) {
                        isPrimeNumbers[j] = false;
                    }
                }
            }
            return isPrimeNumbers;
        }
    }
}
