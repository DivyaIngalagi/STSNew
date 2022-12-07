import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestFilter {

    public static void main(String[] args) {
        List<Integer> inlist = new ArrayList();

        inlist.add(2);
        inlist.add(10);
        inlist.add(3);
        inlist.add(5);
        inlist.add(11);

        List<Integer> newList = inlist.stream().filter(i -> i > 5).map(i -> i * 10)
                .collect(Collectors.toList());
        System.out.println(newList);

    }

}
