package com.enigma.gosling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVPerson {
    private final String FILE_NAME = "person.csv";

    public void writePerson(Person person) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME, true);
            fileWriter.write(person.toString());
            fileWriter.write("\n");

            fileWriter.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public List<Person> getAllPerson() {
        List<Person> people = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (true) {
                String readPerson = bufferedReader.readLine();

                // cek apakah sudah diujung line
                if (readPerson == null) break;

                String[] persons = readPerson.split(",");

                Person person = new Person(
                        Integer.parseInt(persons[0]),
                        persons[1],
                        Integer.parseInt(persons[2])
                );

                people.add(person);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return people;
    }

    public void deleteById(Integer id){
        List<Person> people = getAllPerson();

        for (Person person : people){
            if (person.getId().equals(id)){
                people.remove(person);
                break;
            }
        }

        // Try-with-resource, akan menutup koneksi dari sebuah IO
        // atau yang implementeasi interface closeable

        try(FileWriter fileWriter = new FileWriter(FILE_NAME)){
            for (Person person : people){
                fileWriter.write(person.toString());
                fileWriter.write("\n");
            }
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
