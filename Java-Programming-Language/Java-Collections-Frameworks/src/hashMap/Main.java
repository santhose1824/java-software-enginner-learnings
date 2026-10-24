package hashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Creating a hashMap object.
        Map<String,Integer> map = new HashMap<>();

        // add the values to the hash map
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        map.put("E",5);

        // {A=1, B=2, C=3, D=4, E=5}
        System.out.println(map);

        // get(key) - particular value by key return the value.
        System.out.println(map.get("A") );

        // getOrDefault - get if exists else give default.
        System.out.println(map.getOrDefault("F",0));

        // containsKey - check if it exists only key.
        System.out.println(map.containsKey("A"));

        // containsValue - check if the value exists.
        System.out.println(map.containsValue(1));

        // Iterating the map - map is not collection so we convert map into collection;
        Set<Map.Entry<String,Integer>> entries = map.entrySet();

        for(Map.Entry<String,Integer> entry:entries){
            System.out.print(entry.getKey()+":"+entry.getValue()+" ");
        }
        System.out.println();

        // To get keys only
        Set<String> keys = map.keySet();
        for(String key:keys){
            System.out.print(key+":"+map.get(key)+" ");
        }
        System.out.println();

        // To get values only.
        for(Integer value:map.values()){
            System.out.print(value+" ");
        }
    }
}
