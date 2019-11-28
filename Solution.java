
// Java program to count frequencies of elements 
// using HashMap. 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void countFrequencies() {
        final ArrayList<String> list = new ArrayList<String>();

        // Reading the text file
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("lyrics.txt"));
            String line = reader.readLine();
            while (line != null) {
                line = line.toLowerCase();
                final String words[] = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    list.add(words[i]);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        // hashmap to store the frequency of element
        final Map<String, Integer> map = new HashMap<String, Integer>();

        for (final String i : list) {
            final Integer j = map.get(i);
            map.put(i, (j == null) ? 1 : j + 1);
        }

        // Sorting the hasmap
        final Object[] a = map.entrySet().toArray();
        Arrays.sort(a, (o1, o2) -> ((Map.Entry<String, Integer>) o2).getValue()
                .compareTo(((Map.Entry<String, Integer>) o1).getValue()));

        // printing the values
        for (final Object e : a) {
            System.out.println(
                    ((Map.Entry<String, Integer>) e).getValue() + " : " + ((Map.Entry<String, Integer>) e).getKey());
        }
    }

    public static void main(final String[] args) {
        countFrequencies();
    }
}