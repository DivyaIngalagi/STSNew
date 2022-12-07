import java.util.Scanner;

public class Array1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = new int[] { 5, 3, 4, 8, 6 };// {3.4.5};
        int temp;
        new Scanner(System.in);
        // for (int i = 0; i < a.length; i++) {
        // a[i] = scan.nextInt();
        // }
        // for (int i = 0; i < a.length; i++) {
        // System.out.println(a[i]);
        // }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for (int k = 0; k < a.length; k++) {
            System.out.println(a[k]);
        }

    }

}
