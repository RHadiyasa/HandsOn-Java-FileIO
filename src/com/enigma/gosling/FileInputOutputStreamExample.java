package com.enigma.gosling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileInputOutputStreamExample {
    /**
     * 01
     * path : relative, absolute
     * relative -> menunjukan lokasi dimana file disimpan (tergantung working directory)
     * absolute -> menunjukan lokasi dimana file disimpan dengan path yang lengkap
     */

    private static File file = new File("Example.txt");

    public static void main(String[] args) {
//        createNewFile();
//        writeFile();
//        read();
        removeCharFromFile();
    }

    public static void removeCharFromFile() {
        try {
            // read dulu
            FileInputStream fis = new FileInputStream(file);
            String temp = "";

            while (true) {
                int ascii = fis.read();
                if (ascii == -1) break;
                temp += (char) ascii;
            }
            System.out.println(temp);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Delete char: ");
            char deletedChar = scanner.next().charAt(0);

            String tempNewString = "";
            int counter = 0;

            for (char c : temp.toCharArray()) {
                if (c == deletedChar) {
                    counter++;
                } else {
                    tempNewString += c;
                }
//                System.out.println(c);
            }

            System.out.println(tempNewString);

            // write tempNewString ke dalam file
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(tempNewString.getBytes(StandardCharsets.UTF_8));

            fis.close();
            fos.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void createNewFile() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            // FileOutputStream wajib ditutup agar tidak terjadi data corrupt di dalam memory
            fos.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void writeFile() {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            /*
            fos.write(65);
            fos.write(66);
            */

            String name = "Rafi";
            fos.write(name.getBytes());
            fos.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void read() {
        try {
            FileInputStream fis = new FileInputStream(file);

//            int k = fis.read();
//            int o = fis.read();
//            System.out.println((char) k);
//            System.out.println((char) o);
//            System.out.println(fis.read()); // kalau kosong akan -1

            while (true) {
                int asciiByte = fis.read();
                if (asciiByte == -1) break;
                System.out.print((char) asciiByte);
            }

            fis.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
