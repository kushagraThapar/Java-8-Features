package com.customlambda.problems;

import java.io.File;

/**
 * Created by kushagrathapar on 5/4/16 at 8:59 AM.
 */
public class Problem3 {

    public static void main(String[] args) {
        String inputDirectory = "./";
        String inputExtension = ".iml";
        File f = new File(inputDirectory);
        if (!f.isDirectory()) {
            System.out.println("The given input is not a directory");
            System.out.println("Program will exit now");
            System.exit(1);
        }
        String[] subDirectories = f.list((dir, name) -> name.endsWith(inputExtension));
        for (String temp : subDirectories) {
            System.out.println(temp);
        }
    }
}
