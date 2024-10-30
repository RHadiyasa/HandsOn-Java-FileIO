package com.enigma.gosling;

import java.io.*;
import java.util.Scanner;

public class FileWriterReaderExample {
    public static File file = new File("Example.txt");

    public static void main(String[] args) {
//        write();
        read();
        searchName();
    }

    public static void searchName() {
        /**
         * 03
         * menggunakan yang namanya bufferReader
         * */
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(System.in);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.print("Enter the name to search: ");
            String searchName = scanner.nextLine();
            String line;
            boolean found = false;

            while( (line = bufferedReader.readLine())  != null){
                if (line.equalsIgnoreCase(searchName)) {
                    System.out.println("Name found " + line);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Name not found!");
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void write() {
        /** 01 */
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Input name: ");
                String name = scanner.nextLine();
                fileWriter.write(name);
                fileWriter.write("\n");

                System.out.print("Input again? (Y/N): ");
                char input = scanner.nextLine().charAt(0);
                if (input == 'N' || input == 'n') break;
            }
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void read() {
        /** 02 */
        try {
            FileReader fileReader = new FileReader(file);
            while (true) {
                int read = fileReader.read();
                if (read == -1) {
                    break;
                }
                System.out.print((char) read);
            }
            fileReader.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
