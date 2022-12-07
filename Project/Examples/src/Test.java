@FunctionalInterface
interface Calculator {
    int add(int x, int y);
}

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 2, y = 3;
        Calculator c = (a, b) -> a + b;
        int sum = c.add(x, y);
        System.out.println("sum" + sum);
    }

}
