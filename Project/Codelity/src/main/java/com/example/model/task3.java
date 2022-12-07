// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String input) {
       
        // write your code in Java SE 8

  char []chInput = input.toCharArray();
    Set setDuplicated = new HashSet<>();
    Set distinctChars = new HashSet<>();

    for(char ch: chInput) {
        if(distinctChars.add(ch) == false)

            setDuplicated.add(ch);
    }    


    String first = setDuplicated.stream().findFirst().get().toString();

    return  setDuplicated.stream().findFirst().get().toString();


    }
}
