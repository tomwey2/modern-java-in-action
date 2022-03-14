package part3.ch8_collection_api_enhancements;

import java.util.*;

public class CollectionFactories {
    public static void main(String[] args) {
        // List factory

        // fixed-size List, indexed access, not more used?
        List<String> friends1 = Arrays.asList("Raphael", "Olivia");
        friends1.set(0, "Richard");
        //friends1.add("Thibaut"); // <-- UnsupportedOperationException
        System.out.println("immutable list whose elements can be replaces: " + friends1);

        // fixed-size List, immutable list, indexed access via get()
        List<String> friends2 = List.of("Raphael", "Olivia", "Thibaut");
        //friends2.set(0, "Richard"); // <-- UnsupportedOperationException
        //friends2.add("Chih-Chun"); // <-- UnsupportedOperationException
        System.out.println(friends2.get(1));

        // ArrayList, mutable list, with indexed access via get()
        ArrayList<String> friends3 = new ArrayList<>(friends2);
        friends3.set(0, "Richard");
        friends3.add("Chih-Chun");
        System.out.println("mutable array list: " + friends3);

        // Set factory
        // immutable set of elements
        Set<String> friends4 = Set.of("Raphael", "Olivia", "Thibaut");
        //Set<String> friends5 = Set.of("Raphael", "Olivia", "Olivia"); // <-- IllegalArgumentException: dublicate element: Olivia

        // Map factory
        // immutable map of elements
        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 43);
        System.out.println(ageOfFriends);

    }
}
