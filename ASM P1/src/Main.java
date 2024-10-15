import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList and add objects
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Orange");
        myList.add("Pineapple");
        myList.add("Mango");
        myList.add("Orange");
        myList.add("Grapes");

        // Print all objects using a for loop
        System.out.println("Print All the Objects:");
        for (String fruit : myList) {
            System.out.println(fruit);
        }

        // Get element at index 3
        System.out.println("Object at index 3 element from list: " + myList.get(3));

        // Check if the list contains a specific element
        System.out.println("Is Chicku in list: " + myList.contains("Chicku"));

        // Print the size of the list
        System.out.println("Size of ArrayList: " + myList.size());

        // Check size again (no change)
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}
