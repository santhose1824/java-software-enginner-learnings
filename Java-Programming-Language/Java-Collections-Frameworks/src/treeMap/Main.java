package treeMap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Creating a treeMap object.
        NavigableMap<String, Integer> map = new TreeMap<>();

        // add the values to the map
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);

        // {A=1, B=2, C=3, D=4, E=5}
        System.out.println(map);

        // get(key) - return the value for a particular key.
        System.out.println(map.get("A"));

        // getOrDefault - get if exists else give default.
        System.out.println(map.getOrDefault("F", 0));

        // containsKey - check if the key exists.
        System.out.println(map.containsKey("A"));

        // containsValue - check if the value exists.
        System.out.println(map.containsValue(1));

        // Iterating the map - map is not a collection, so we convert it into one.
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
        System.out.println();

        // To get keys only
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.print(key + ":" + map.get(key) + " ");
        }
        System.out.println();

        // To get values only.
        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
        System.out.println();

        // ---------------- floor, ceiling, lower, higher ----------------
        System.out.println("---- Existing key \"C\" ----");

        // floor: greatest key <= "C" (exact match allowed)
        System.out.println("floorKey(C)      : " + map.floorKey("C"));      // C
        System.out.println("floorEntry(C)    : " + map.floorEntry("C"));    // C=3

        // ceiling: smallest key >= "C" (exact match allowed)
        System.out.println("ceilingKey(C)    : " + map.ceilingKey("C"));    // C
        System.out.println("ceilingEntry(C)  : " + map.ceilingEntry("C"));  // C=3

        // lower: greatest key < "C" (exact match NOT allowed)
        System.out.println("lowerKey(C)      : " + map.lowerKey("C"));      // B
        System.out.println("lowerEntry(C)    : " + map.lowerEntry("C"));    // B=2

        // higher: smallest key > "C" (exact match NOT allowed)
        System.out.println("higherKey(C)     : " + map.higherKey("C"));     // D
        System.out.println("higherEntry(C)   : " + map.higherEntry("C"));   // D=4

        // Key that is not in the map: "CA" sorts between "C" and "D"
        System.out.println("---- Missing key \"CA\" ----");
        System.out.println("floorKey(CA)     : " + map.floorKey("CA"));     // C
        System.out.println("ceilingKey(CA)   : " + map.ceilingKey("CA"));   // D
        System.out.println("lowerKey(CA)     : " + map.lowerKey("CA"));     // C
        System.out.println("higherKey(CA)    : " + map.higherKey("CA"));    // D

        // When nothing qualifies, they return null (no exception).
        System.out.println("---- Nothing qualifies ----");
        System.out.println("lowerKey(A)      : " + map.lowerKey("A"));      // null
        System.out.println("higherKey(E)     : " + map.higherKey("E"));     // null

        // Always null-check before using an entry.
        Map.Entry<String, Integer> e = map.higherEntry("E");
        if (e != null) {
            System.out.println(e.getValue());
        } else {
            System.out.println("No entry higher than E");
        }

        // ---------------- Related navigation methods ----------------
        System.out.println("---- Related methods ----");
        System.out.println("firstKey         : " + map.firstKey());         // A
        System.out.println("lastKey          : " + map.lastKey());          // E
        System.out.println("firstEntry       : " + map.firstEntry());       // A=1
        System.out.println("lastEntry        : " + map.lastEntry());        // E=5
        System.out.println("headMap(C)       : " + map.headMap("C"));       // {A=1, B=2}
        System.out.println("tailMap(C)       : " + map.tailMap("C"));       // {C=3, D=4, E=5}
        System.out.println("subMap(B, D)     : " + map.subMap("B", "D"));   // {B=2, C=3}
        System.out.println("descendingMap    : " + map.descendingMap());    // {E=5, D=4, C=3, B=2, A=1}
    }
}