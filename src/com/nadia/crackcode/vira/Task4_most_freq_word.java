package com.nadia.crackcode.vira;

import java.util.HashMap;
import java.util.Map;

/**
 * написать алгоритм, чтоб определить слово, которое чаще всего встречается в массиве данных
 */
public class Task4_most_freq_word {

    public static void main(String args[]) {
        System.out.println(mostFreqWord(new String[]{"ac","ac","ab","ab","ab","ab","ad","ac",}));
    }

    private static String mostFreqWord(String[] wordArray) {
        Map<String, Integer> wordFreq = new HashMap<String, Integer>();
        for (String word : wordArray) {
            Integer freq = 0;
            if (wordFreq.containsKey(word)) freq = wordFreq.get(word);
            wordFreq.put(word, freq + 1);
        }
        int max = 0;
        String mostFreqWord = null;
        for (String word : wordFreq.keySet()) {
            Integer freq = wordFreq.get(word);
            if (freq > max) {
                max = freq;
                mostFreqWord = word;
            }
        }
        return mostFreqWord;
    }
}
