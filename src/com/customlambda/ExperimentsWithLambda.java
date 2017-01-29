package com.customlambda;

import com.customlambda.problems.ComparatorClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by kushagrathapar on 9/17/16 at 2:05 PM.
 */
public class ExperimentsWithLambda {

    public ExperimentsWithLambda(ExperimentsWithLambda experimentsWithLambda) {

    }

    public static void main(String[] args) {
        List<String> demoList = new ArrayList<>();
        ComparatorClass obj = new ComparatorClass();
        Collections.sort(demoList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        for (String demo : demoList) {
            System.out.println(demo);
        }

        List<String> doshiList = new ArrayList<>();

        demoList.forEach(System.out::println);

        demoList.forEach(doshiList::add);


        ExperimentsWithLambda lambda = new ExperimentsWithLambda(null);

        //  demoList.forEach(lambda::manipulate);

        demoList.forEach(ExperimentsWithLambda::manipulateStatic);

        Collections.sort(demoList, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        Collections.sort(demoList, String::compareTo);

        Collections.sort(demoList, (o1, o2) -> o1.compareTo(o2));

        List<ExperimentsWithLambda> tempList = new ArrayList<>();

        //  Collections.sort(tempList, ExperimentsWithLambda::manipulate);

        //  Collections.sort(tempList, (o1, o2) -> o1.manipulate(o2));

        Button button = new Button();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This is an event");
            }
        });

        lambda.manipulate(ExperimentsWithLambda::new);

        button.setOnAction((event) -> System.out.println("This is an event"));

        button.setOnAction(System.out::println);
    }

    public int manipulate(Consumer<ExperimentsWithLambda> obj) {
//        element += "1";
//        element += "2";
//        element += "3";
        System.out.println(obj);
        return 0;
    }

    public static void manipulateStatic(String element) {
        element += "1";
        element += "2";
        element += "3";
        System.out.println(element);
    }
}
