package com.customlambda.problems;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/**
 * Created by kushagrathapar on 5/4/16 at 9:16 AM.
 */
public class Problem4 {

    public static void main(String[] args) {
        File[] inputFileObjects = new File[5];
        inputFileObjects[0] = new File("sa.properties");
        inputFileObjects[1] = new File("/src/com/customlambda/Problem2.java");
        inputFileObjects[2] = new File("/src/com/customlambda");
        inputFileObjects[3] = new File("../../Android-Experiments");
        inputFileObjects[4] = new File("../Java-8-Features.iml");
        for (File file : inputFileObjects) {
            System.out.println(file.getName() + " -> " + file.isDirectory());
        }
        Arrays.sort(inputFileObjects, (o1, o2) -> {
            if (o1.isDirectory() && o2.isDirectory()) {
                return o1.compareTo(o2);
            }

            if (o1.isDirectory()) {
                return 1;
            }

            if (o2.isDirectory()) {
                return -1;
            }

            return o1.compareTo(o2);
        });

        System.out.println("\n****** Sorted Array ******\n");
        for (File file : inputFileObjects) {
            System.out.println(file.getName());
        }
    }
}
