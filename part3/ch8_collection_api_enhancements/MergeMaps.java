package part3.ch8_collection_api_enhancements;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class MergeMaps {
    public static void main(String[] args) {
        Map<String, String> family = Map.ofEntries(
                entry("Theo", "Star Wars"),
                entry("Christina", "James Bond")
        );
        Map<String, String> friends = Map.ofEntries(
                entry("Raphael", "Star Wars")
        );
        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);
        System.out.println(everyone);
    }
}
