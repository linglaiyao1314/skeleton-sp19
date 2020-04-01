package map61b;

import java.util.*;

import static org.junit.Assert.*;

public class Test {
    @org.junit.Test
    public void testReverse(){
        Set<String> s = new HashSet<>();
        s.add("tokyo");
        s.add("lagos");
        System.out.println(s.contains("tokyo"));


        List<Integer> friends =
                new ArrayList<Integer>();
        friends.add(5);
        friends.add(23);
        friends.add(42);
        for (int x : friends) {
            System.out.println(x);
        }
    }

    private class ExtensionStack<Item> extends LinkedList<Item>{

    }
}
