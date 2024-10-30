package com.enigma.gosling;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVExample {
    public static void main(String[] args) {
        CSVPerson csvPerson = new CSVPerson();
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID: ");
        int personId = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        csvPerson.writePerson(new Person(personId, name, age));
//        csvPerson.writePerson(new Person(3,"Rani", 26));
        List<Person> people = csvPerson.getAllPerson();

        print(people);
        System.out.print("Wanna delete? (Y/N): ");
        char input = scanner.nextLine().charAt(0);
        if (input == 'Y' || input == 'y'){
            System.out.print("Input ID: ");
            int id = scanner.nextInt();
            csvPerson.deleteById(id);

            // ambil data lagi
            people = csvPerson.getAllPerson();
            print(people);
        }
    }

    static void print(List<Person> people){
        System.out.printf("%-5s | %-10s | %-5s\n", "ID", "NAME", "AGE");
        System.out.println("-".repeat(30));
        for (Person person : people){
            System.out.printf("%-5d | %-10s | %-5d\n", person.getId(), person.getName(), person.getAge());
        }
    }
}
