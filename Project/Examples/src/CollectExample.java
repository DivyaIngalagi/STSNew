import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CollectExample {
    public static void main(String[] args) {
        HashMap<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "Divya");
        hashmap.put(2, "Anandds");

        hashmap.keySet().stream().forEach(x -> System.out.println(x));

        Iterator<Map.Entry<Integer, String>> itr = hashmap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, String> entry = itr.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        for (Integer i : hashmap.keySet()) {
            System.out.println(i);
        }

        for (Map.Entry<Integer, String> map : hashmap.entrySet()) {
            System.out.println(map);
        }

        ArrayList<String> array = new ArrayList<>();
        array.add("Hello");
        array.add("Hii");

        for (String s : array) {
            System.out.println(s);
        }

        Iterator<String> itrarray = array.iterator();
        while (itrarray.hasNext()) {
            System.out.println(itrarray.next());
        }

        array.forEach(n -> System.out.println(n));
    }
}
