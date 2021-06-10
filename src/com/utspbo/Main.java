/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utspbo;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HP
 */
class Main {

    /**
     *
     * @param str
     */
    public Main(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();

        try {
            try (FileWriter TXTFile = new FileWriter("Hasil.txt", true); BufferedWriter Make = new BufferedWriter(TXTFile)) {
                for (int i = 0; i < charArray.length; i++) {
                    try {
                        char ch = charArray[i];
                        if (ch >= 'a' && ch <= 'z') {
                            char[] inString = str.toCharArray();
                            System.out.println("Abjad");

                            for (char c : inString) {
                                Make.append(c);
                            }
                            System.out.println();
                            break;
                        } else if (ch >= '0' && ch <= '9') {
                            char[] inNumber = str.toCharArray();
                            System.out.println("Angka");

                            for (char c : inNumber) {
                                Make.append(c);
                            }
                            System.out.println();
                            break;
                        } else {
                            throw new IOException("Simbol Terdeteksi!");
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                        System.exit(0);
                    }
                }

                Make.newLine();
                Make.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        System.out.println("===== NUMBER OR STRING JAVA PROGRAM =====");
        // Perulangan Tanpa Batas
        for (; true;) {
            System.out.print("\nMasukan String : ");
            String Input = scan.nextLine();
            try {
                if ("stop".equals(Input) || "STOP".equals(Input)) {
                    throw new ArithmeticException("Program Berakhir.");
                }

            } catch (ArithmeticException e) {
                System.out.println(e);
                System.exit(0);
            }

            System.out.print("String yang dimasukan adalah : ");

            Main kembali = new Main(Input);

            try {
                FileReader TXTFile = new FileReader("Hasil.txt");
                BufferedReader Baca = new BufferedReader(TXTFile);
                Scanner read = new Scanner(Baca);

                while (read.hasNext() != false) {
                    System.out.print(read.next());
                    System.out.print("\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }
    }
}