package com.example.assignment6;

public class Museum extends Thread {
    static int counter = 0;

    static int id = -1;

    int groups;

    public Museum() {
        id++;
        this.groups = id;
    }

    public int getGroupNumber() {
        return this.groups;
    }

    public static void enter(Museum m) {
    counter++;
    System.out.println("Group: " + m.getGroupNumber() + " is entering the Museum" + " & number of groups in museum: " + counter);
    }

    public static void exit(Museum m) {
    counter--;
    System.out.println("Group: " + m.getGroupNumber() + " is leaving the Museum" + " & number of groups in museum: " + counter);
    }

    private void enterMuseum() {
        enter(this);
    }

    private void exitMuseum() {
        exit(this);
    }

    @Override
    public void run() {
        this.enterMuseum();
        this.exitMuseum();
    }
}
