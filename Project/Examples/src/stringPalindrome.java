
public class stringPalindrome {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String reverse = "";
        String s = "Blah blah blah level";
        String[] splitString = s.split(" ");

        for (int i = 0; i < splitString.length; i++) {

            String originalString = splitString[i];

            System.out.println(originalString);

            for (int j = splitString[i].length() - 1; j >= 0; j--) {
                // for (int j = 0; j < splitString[i].length(); j++) {
                System.out.println(splitString[i].charAt(j));
                // System.out.print(splitString[j]);

                reverse += splitString[i].charAt(j);

            }

            System.out.print(reverse);

            System.out.println();

            if (reverse.equals(originalString)) {
                System.out.println("String is Palindrome" + originalString);
            }
            reverse = "";

            /*
             * for (char c : splitString[i].toCharArray()) {
             *
             * System.out.println(c); }
             */

            // for (int j = splitString[i].length() - 1; j >= 0; j--) {
            //
            // System.out.print(splitString[j]);
            //
            // }

        }

    }

}
