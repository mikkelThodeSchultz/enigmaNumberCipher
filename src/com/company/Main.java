package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Enigma!");
        System.out.println("Choose (e)ncrypt or (d)ecrypt ");
        int mode = sc.nextLine().charAt(0);

        System.out.println("Press 1 for Number cipher or 2 for Caesar cipher ");
        int type = sc.nextInt();

        if (type == 1 && mode == 'e'){
            numberCipherEncryptMenu();
        }
        if (type == 1 && mode == 'd'){
            numberCipherDecryptMenu();
        }
        if (type == 2 && mode == 'e'){
            encryptCaesarMenu();
        }
        if (type == 2 && mode == 'd'){
            decryptCaesarMenu();
        }


    }

    private static void numberCipherEncryptMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.print("You have chosen encrypt, please enter a text: ");
        String text = sc.nextLine();
        text = text.toLowerCase();
        int[] cipherText = textToListOfNumbers(text);
        System.out.println("\nencrypted text is " );
        System.out.println(Arrays.toString(cipherText));

    }

    private static void numberCipherDecryptMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("You have chosen decrypt, please enter a set of numbers: ");
        String numbers = sc.nextLine();
        int[] cipher = userInputToIntArray(numbers);
        String plaintext = listOfNumbersToText(cipher);
        System.out.print("decrypted text is: ");
        System.out.print(plaintext);

    }

    public static void decryptCaesarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("You have chosen decrypt, please enter your ciphertext ");
        String cipherText = sc.nextLine();
        System.out.println("Choose your shift-value ");
        int shiftValue = sc.nextInt();
        String plainText = caesarDecrypt(cipherText, shiftValue);
        System.out.println("your decrypted message is: ");
        System.out.println(plainText);
        // beder brugeren om ciphertext
        // beder brugeren om shift-værdi
        // kalder caesarDecrypt med ciphertext og shift-værdi
        // udskriver plaintext modtaget fra ovenstående
    }

    public static void encryptCaesarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("You have chosen encrypt, please enter your text ");
        String plainText = sc.nextLine();
        System.out.println("Choose your shift-value ");
        int shiftValue = sc.nextInt();
        String cipherText = caesarEncrypt(plainText, shiftValue);
        System.out.println("Your text in cipher is: "+ cipherText);
        // beder brugeren om plaintext
        // beder brugeren om shift-værdi
        // kalder caesarEncrypt med ciphertext og shift-værdi
        // udskriver ciphertext modtaget fra ovenstående
    }

    public static String caesarEncrypt( String plaintext, int shiftValue) {
        int [] listOfNumbers = textToListOfNumbers(plaintext);
        int [] shiftedListOfNumbers = shiftListOfNumbers(listOfNumbers, shiftValue);
        return listOfNumbersToText(shiftedListOfNumbers);
    }

    public static String caesarDecrypt( String cipherText, int shiftValue ) {

        int [] listOfNumbers = textToListOfNumbers(cipherText);
        int [] shiftedListOfNumbers = shiftListOfNumbers(listOfNumbers, -shiftValue);
        return listOfNumbersToText(shiftedListOfNumbers);

    }

    public static int[] shiftListOfNumbers( int[] numbers, int shiftValue) {
        int[] shiftedListOfNumbers = new int[0];
        for (int i = 0; i < numbers.length; i++){
            System.out.println(shiftNumber(numbers[i], shiftValue));
            shiftedListOfNumbers = new int[(shiftNumber(numbers[i], shiftValue))];
        }
        return shiftedListOfNumbers;
    }

    public static int shiftNumber( int number, int shiftValue ) {

        int shiftedInt = number + shiftValue;
        if (number == 0){
            shiftedInt = 0;
        }
        else if (shiftedInt > 29) {
            shiftedInt = number + shiftValue - 29;
        }
        else if (shiftedInt < 0) {
            shiftedInt = number + shiftValue + 29;
        }
        return shiftedInt;

    }

    public static int [] userInputToIntArray ( String numbers){
        // https://stackoverflow.com/questions/35764996/how-to-convert-
        // the-numeric-comma-separated-string-into-int-array

        String[] tokens = numbers.split(", |,| ");
        int[] numbers2 = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers2[i] = Integer.parseInt(tokens[i]);
        }
        return numbers2;
    }

    public static int letterToNumber(char letter) {
        char[] alphabet = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'æ', 'ø', 'å'};

        int number = 0;
        for (int i = 0; i < alphabet.length; i++) {
            char letterWeAreChecking = (alphabet[i]);
            if (letter == letterWeAreChecking) {
                number = i;

            }
        }
        return number;
    }

    public static int[] textToListOfNumbers ( String text ){

        int[] numbers = new int[text.length()];
        char[] letters = text.toCharArray();

        for (int i = 0; i < text.length(); i++){
            numbers[i] = letterToNumber(letters[i]);
        }

        return numbers;

    }

    public static char numberToLetter( int number ) {
        String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        char letter2 = alphabet.charAt(number);

        return letter2;
    }

    public static String listOfNumbersToText ( int[] numbers){
        String text = "";
        for (int i = 0; i < numbers.length; i++){
            int number = numbers[i];
            char letter = numberToLetter(number);

            text = text + letter;
        }
        return text;
    }



}

