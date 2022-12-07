package com.example;

public class Assignment2 {

    public static String removeCharacter(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int a = c;
            if (a >= 65 && a <= 90 || a >= 97 && a <= 122) {

                temp += c;

            }
        }

        return temp;
    }

    public static void main(String[] args) {
        String sameStr = "Liril";
        String rev = "";
        String str = removeCharacter(sameStr).toLowerCase();
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }

        if (str.equals(rev)) {
            System.out.println(str + " is palindrome");
        }
        else {
            System.out.println(str + " is not palindrome");
        }
    }

}
