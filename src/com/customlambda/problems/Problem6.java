package com.customlambda.problems;

/**
 * Created by kushagrathapar on 5/6/16 at 1:51 AM.
 */

public class Problem6 {
    public static void main(String[] args) {
        SupportingClass supportingClass = new SupportingClass();
        new Thread(supportingClass).start();
    }
}

class SupportingClass implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Run method called of supporting class");
            System.out.println("Now sleeping...");
            Thread.sleep(1000);
            System.out.println("Now awake...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NewSupportingClass implements RunnableExtension {

    @Override
    public void run() {
        RunnableExtension.uncheck(() -> {
            System.out.println("Hello...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello Again...");
        });
    }
}

interface RunnableExtension extends Runnable {

    static Runnable uncheck(RunnableExtension runner) {
        new Thread(() -> {
            try {
                System.out.println("new thread created in RunnableExtension interface");
                System.out.println("Now sleeping...");
                Thread.sleep(1000);
                System.out.println("Now awake...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return Thread.currentThread();
    }
}
