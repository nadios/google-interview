package com.nadia.crackcode.ch1_arrays_and_strings;

/**
 * Write a method to replace all spaces in a string with ‘%20’
 */
public class Task1_5 {

    public static void main(String[] args) {
        System.out.println("%20%20%20aa%20aaa%20aa%20asada%20adasd%20adsda%20addas%20%20"
                .equals(replace_spaces("   aa aaa aa asada adasd adsda addas  ")));
    }

    private static String replace_spaces(String s) {
        char[] chars = s.toCharArray();
        int space_count = 0;
        for (char ch : chars) {
            if (ch == ' ') {
                space_count++;
            }
        }
        char[] newChars = new char[chars.length + 2 * space_count];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                newChars[j++] = '%';
                newChars[j++] = '2';
                newChars[j++] = '0';
//                j += 3;
            } else {
                newChars[j++] = chars[i];
//                j++;
            }
        }
        String result = new String(newChars);
        System.out.println(result);
        return result;
    }

}
