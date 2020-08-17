package com.ankit.leetcode.worddictionary;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {

    private List<String> dict;

    /** Initialize your data structure here. */
    public WordDictionary() {
        dict = new ArrayList<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        dict.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        for (String elem : dict) {
            StringBuilder wordCopy = new StringBuilder(word);
            if (word.length() != elem.length())
                continue;

            for (int j = 0; j < word.length(); ++j) {
                if (wordCopy.charAt(j) == '.') {
                    wordCopy.setCharAt(j, elem.charAt(j));
                }
            }

            if (wordCopy.toString().equals(elem)) {
                return true;
            }
        }

        return false;
    }
}
