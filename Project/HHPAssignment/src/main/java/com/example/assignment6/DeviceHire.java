package com.example.assignment6;

import java.util.ArrayList;
import java.util.Scanner;

public class DeviceHire extends Thread {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new DeviceHire().start();
    }

    private static void Visitor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of groups wants to take device: ");
        int count = sc.nextInt();
        ArrayList<Museum> groups = new ArrayList<>(count);
        new Museum();
        for (int i = 0; i < count; i++) {
            groups.add(new Museum());
        }
        for (Museum c : groups) {
            c.start();
        }
    }

    @Override
    public void run() {
        Visitor();
    }
}
