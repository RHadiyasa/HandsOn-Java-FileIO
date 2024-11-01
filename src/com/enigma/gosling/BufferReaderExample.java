package com.enigma.gosling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferReaderExample {
    public static File file = new File("Example.txt");
    public static void main(String[] args) {
        read();
    }

    /**
     * BufferReader
     * Digunakan untuk membaca text dari suatu reader (FileReader) secara lebih efisien
     * BufferReader menggunakan method readLine() -> membaca perbaris
     * */

    public static void read(){

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<String> readName = new ArrayList<>();

            while(true){
                String name = bufferedReader.readLine();

                if (name == null) break; // tidak ada line

                readName.add(name);
            }

            System.out.println(readName);

            bufferedReader.close();
            fileReader.close();
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
