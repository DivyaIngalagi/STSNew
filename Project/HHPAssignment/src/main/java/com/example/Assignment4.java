package com.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Assignment4 {
    static Queue<String> q = new LinkedList<>();

    static int totalSeat = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to CT Hospital");
        System.out.println("Enter 1: Patient register 2: Check-up");
        int profile = sc.nextInt();
        if (profile == 1) {
            if (q.size() < totalSeat) {
                register();
            }
            else {
                System.out.println("No seat available!!");
                System.out.println("=================================================");
                main(new String[1]);
            }
        }
        else if (profile == 2) {
            System.out.println("If u want to check up for  " + q.peek() + " enter yes... ");
            String check = sc.next();
            if (check.equalsIgnoreCase("yes")) {
                if (q.size() == 0) {
                    System.out.println("No appointment available!!");
                    System.out.println("=================================================");
                    main(new String[1]);
                }
                else {
                    patientVisit();
                }

            }
            else {
                System.out.println("=================================================");
                main(new String[0]);
            }
        }
        else {
            System.err.println("Please select correct option!!");
        }
    }

    public static void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Patient name for entry: ");
        String patient = sc.nextLine();
        q.add(patient);
        System.out.println("Patient name " + patient + " registered successfully.");
        System.out.print("Patient available for check-up: ");
        q.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println(totalSeat - q.size() + " seats left only.");

        System.out.println("=================================================");
        main(new String[1]);
    }

    public static void patientVisit() {
        System.out.println("Patient check up for " + q.poll() + " done.");
        System.out.print("Patient available for check-up: ");
        q.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println(totalSeat - q.size() + " seats left only.");

        System.out.println("=================================================");
        main(new String[1]);

    }

}
