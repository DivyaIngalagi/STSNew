import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class StringExam {
    public static void main(String[] args) {
        String str = "Divya Gopal d";
        char[] ch = str.toCharArray();
        // int[] freq = new int[str.length()];
        // // for (int i = 0; i < str.length(); i++) {
        // // System.out.println(str.charAt(i));
        // // }
        // //
        // for (int j = str.length() - 1; j >= 0; j--) {
        // System.out.println(str.charAt(j));
        // }
        // char[] ch = str.toCharArray();
        // for (int i = 0; i < ch.length; i++) {
        // freq[i] = 1;
        // for (int j = i + 1; j < str.length(); j++) {
        // if (ch[i] == ch[j]) {
        // freq[i]++;
        // ch[j] = '0';
        // }
        // }
        // }
        //
        // for (int i = 0; i < freq.length; i++) {
        // if (ch[i] != ' ' && ch[i] != '0') {
        // System.out.println(ch[i] + " " + freq[i]);
        // }
        // }
        //
        // }

        HashMap<Character, Integer> hashmap = new HashMap();
        for (int i = 0; i < ch.length; i++) {
            if (hashmap.containsKey(ch[i])) {
                hashmap.put(ch[i], hashmap.get(ch[i]) + 1);
            }
            else {
                hashmap.put(ch[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> mapvalue : hashmap.entrySet()) {
            if (mapvalue.getValue() > 1) {
                System.out.println(mapvalue.getKey());
            }
        }

        char res = 0;
        int count = 0;
        for (Map.Entry<Character, Integer> mapvalue : hashmap.entrySet()) {
            if (count < mapvalue.getValue()) {
                res = mapvalue.getKey();
                count = mapvalue.getValue();
            }
        }
        System.out.println(res + "htrt " + count);

        LinkedHashSet<Character> linkedhashset = new LinkedHashSet<>();
        for (int i = 0; i < ch.length; i++) {
            linkedhashset.add(ch[i]);
        }
        for (Character c : linkedhashset) {
            String s = "";
            s = s + c;
            // System.out.println(c);
            System.out.println(s);
        }
    }
}
