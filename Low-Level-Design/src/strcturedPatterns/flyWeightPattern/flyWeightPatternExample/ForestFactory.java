package strcturedPatterns.flyWeightPattern.flyWeightPatternExample;

import java.util.HashMap;
import java.util.Map;

public class ForestFactory {
    static Map<String,TreeType> trees = new HashMap<>();

    public static TreeType getTree(String name,String color, String texture){
        String key = name+"_"+color+"_"+texture;

        if(!trees.containsKey(key)){
            trees.put(key,new TreeType(name, texture, color));
        }
        return trees.get(key);
    }
}
