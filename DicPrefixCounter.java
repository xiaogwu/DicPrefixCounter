/**
 * @author Xiao G. Wu
 * CS111A - Assignment 11 
 * @version 1.0 11/23/2011
 */ 

import java.util.*;
import java.io.*;

/**
 * This class parses an English dictionary of words counting the number of words based on the digraph prefix of the words.
 */

class DicPrefixCounter {
    // Path to English Dictionary
    final static String filePath = "/users/abrick/english";

    /**
     * Main method
     */

    public static void main (String [] args) {
        try {
            String currentWord; 
            BufferedReader br = new BufferedReader(new FileReader(filePath)); 
            // Decided to use TreeMaps instead of HashMaps for sorted capabilities of TreeMaps
            TreeMap<String, Integer> prefixCount = new TreeMap<String, Integer>();
            TreeMap<String, String> prefixWord = new TreeMap<String, String>();

            while ((currentWord = br.readLine()) != null) {
                // Digraph prefix
                String prefix = currentWord.substring(0,2);
                // If the digraph prefix doesn't exist in the count hashmap add it
                // Also add it to the word hashmap
                if (!prefixCount.containsKey(prefix)) {
                    prefixCount.put(prefix, 1);
                    prefixWord.put(prefix, currentWord);
                }
                // If the digraph prefix already exists in the count hashmap increment the count
                // If the count is greater than one, it's not unique and should be removed from 
                // word hashmap
                else {
                    prefixCount.put(prefix, prefixCount.get(prefix) + 1);
                    prefixWord.remove(prefix);
                }
            }
            // Didn't use Iterator because HashMap inherites AbstractMap's toString() method
            System.out.println("Digraph prefix count:");
            System.out.println(prefixCount);
            System.out.println("Unique digraph prefix words:");
            System.out.println(prefixWord);
        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(1);
        }
    }
}
