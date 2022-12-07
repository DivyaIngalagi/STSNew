import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleTest {

    public static void main(String[] args) {

        Integer a[] = { 2, 4, 5, 6, 7 };

        List<Integer> inta = Arrays.asList(a);
        List<Integer> newList = inta.stream().filter(i -> i > 5).map(j -> j * 6).collect(Collectors.toList());

        System.out.println(newList);

    }

}
