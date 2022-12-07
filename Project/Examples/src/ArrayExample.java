public class ArrayExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int a[] = new int[] { 2, 3, 4, 5, 6 };
        int max = 0;
        int smax = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }

        for (int j = 0; j < a.length; j++) {
            if (max < a[j]) {
                max = a[j];
            }
        }
        for (int j = 0; j < a.length; j++) {
            if (a[j] != max) {
                if (smax < a[j]) {
                    smax = a[j];
                }
            }
        }
        System.out.println(smax);
    }
}
