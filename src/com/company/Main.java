package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Enigma!");
        System.out.println("Choose (e)ncrypt or (d)ecrypt ");
        char mode = sc.nextLine().charAt(0);
        if (mode == 'e') {
            numberCipherEncryptMenu();
        } else if (mode == 'd') {
            numberCipherDecryptMenu();
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
        int[] cipher = userInputToIntArray(numbers);  // LAV METODE DER KAN OMDANNE SCANNER TIL INT ARRAY
        String plaintext = listOfNumbersToText(cipher);
        System.out.print("decrypted text is: ");
        System.out.print(plaintext);

    }


    public static int [] userInputToIntArray ( String numbers){
        // https://stackoverflow.com/questions/35764996/how-to-convert-
        // the-numeric-comma-separated-string-into-int-array
        String[] tokens = numbers.split(", ");
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

    public static char numberToLetter( int number2 ) {
        String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        char letter2 = alphabet.charAt(number2);

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

