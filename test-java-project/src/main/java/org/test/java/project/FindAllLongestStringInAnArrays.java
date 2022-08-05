package org.test.java.project;

import java.util.*;

public class FindAllLongestStringInAnArrays {
    public static void main(String[] args) {

        Map.Entry<Integer, List<String>> lastEntry = null;

        String[] words = new String[]{
                "cat",
                "dog",
                "red",
                "is",
                "am"
        };


        System.out.println("Original String[] Arrays :- \n"
                + Arrays.toString(words) + "\n");

        Map<Integer, List<String>> treeMap = new TreeMap<>();


        for (String word : words) {
            if (treeMap.containsKey(word.length())) {
                treeMap.get(word.length()).add(word);
            } else {

                List<String> list = new ArrayList<>();
                list.add(word);

                treeMap.put(word.length(), list);
            }
        }


        System.out.println("Length and its List of Strings :-");
        for (Map.Entry<Integer, List<String>> entry : treeMap.entrySet()) {
            System.out.println(entry);
        }


        for (Map.Entry<Integer, List<String>> entry : treeMap.entrySet()) {
            lastEntry = entry;
        }


        System.out.println("\nLongest Strings and its length in List :- \n" + lastEntry);
    }
}
