package com.nadia.crackcode.ch8_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method that returns all subsets of a set.
 */
public class Task8_3 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        System.out.println("LIST: " + list.toString());
        ArrayList<ArrayList<Integer>> subsets = getSubsets(list,0);//powerSet(list);
        for (ArrayList subSet: subsets) {
            System.out.println(subSet.toString());
        }
    }
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) { // Base case - add empty set
            System.out.println("Base case - add empty set : " + set.size() + " == " + index);
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }
}
