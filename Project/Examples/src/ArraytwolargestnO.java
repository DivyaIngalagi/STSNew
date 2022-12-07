
public class ArraytwolargestnO {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int temp, size;
        int array[] = { 10, 20, 25, 63, 96, 57 };
        size = array.length;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Third second largest number is:: " + array[size - 2]);
        // for (int i = array.length - 1; i >= array.length - 3; i--) {
        // System.out.println(array[i]);
        // }
        // for (int i = array.length - 1; i >= array.length - 2; i--) {
        // System.out.println(array[i]);
        // }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("==============");
        for (int i = array.length - 1; i >= array.length - 3; i--) {
            int a = array[array.length - 3];
            if (array[i] != a) {
                System.out.println("12222" + array[i]);
            }
            else {
                int count = 0;
                for (int i1 = array.length - 4; i1 >= 0; i1--) {
                    count++;
                }
                if (count >= 3) {
                    System.out.println("ewewew" + array[array.length - 3]);
                }
            }
        }
    }

}
