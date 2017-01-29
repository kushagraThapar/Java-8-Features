package com.customlambda.problems;

import java.util.Comparator;

/**
 * Created by kushagrathapar on 9/17/16 at 3:23 PM.
 */
public class ComparatorClass implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
