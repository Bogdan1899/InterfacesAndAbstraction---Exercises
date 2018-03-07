package collectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        AddCollection<String> addCollection = new AddCollection<>(String.class);
        AddRemoveCollection<String> addRemoveCollection = new AddRemoveCollection<>(String.class);
        MyList<String> myList = new MyList<>(String.class);

        List<String> addCollectionAddOutput = new ArrayList<>();
        List<String> addRemoveCollectionAddOutput = new ArrayList<>();
        List<String> myListAddOutput = new ArrayList<>();
        List<String> addRemoveCollectionRemoveOutput = new ArrayList<>();
        List<String> myListRemoveOutput = new ArrayList<>();

        String[] input = bfr.readLine().split(" ");
        int removeOperations = Integer.parseInt(bfr.readLine());

        for (String string : input) {
            addCollectionAddOutput.add(Integer.toString(addCollection.add(string)));
            addRemoveCollectionAddOutput.add(Integer.toString(addRemoveCollection.add(string)));
            myListAddOutput.add(Integer.toString(myList.add(string)));
        }

        System.out.println(String.join(" ", addCollectionAddOutput));
        System.out.println(String.join(" ", addRemoveCollectionAddOutput));
        System.out.println(String.join(" ", myListAddOutput));

        for (int i = 0; i < removeOperations; i++) {
            addRemoveCollectionRemoveOutput.add(addRemoveCollection.remove());
            myListRemoveOutput.add(myList.remove());
        }

        System.out.println(String.join(" ", addRemoveCollectionRemoveOutput));
        System.out.println(String.join(" ", myListRemoveOutput));
    }
}
