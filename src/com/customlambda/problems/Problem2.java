package com.customlambda.problems;

import java.io.File;

/**
 * Created by kushagrathapar on 5/4/16 at 8:09 AM.
 */
public class Problem2 {

    public static void main(String[] args) {
        String inputDirectory = "../";
        File f = new File(inputDirectory);
        if (!f.isDirectory()) {
            System.out.println("The given input is not a directory");
            System.out.println("Program will exit now");
            System.exit(1);
        }
        File[] subDirectories = f.listFiles(File::isDirectory);
        for (File temp : subDirectories)
            System.out.println(temp.getName());
    }
}
