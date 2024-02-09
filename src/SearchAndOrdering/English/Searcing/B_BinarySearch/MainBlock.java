package SearchAndOrdering.English.Searcing.B_BinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static SearchAndOrdering.AuxArray.auxArray;
import static SearchAndOrdering.English.Searcing.B_BinarySearch.BinarySearch.binarySearch;

public class MainBlock {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int value;
        char option;

        Item[] sortedArray = createItemsArray(sortArray(auxArray));

        do {
            option = menu(input);

            switch (option) {
                case '1':
                    System.out.println("Sorted Array: " +  printItemsArray(sortedArray));
                    break;
                case '2':
                    System.out.println("In a sorted array with 5000 elements:\n" +
                            "value 1 is in the first position in the array (position 0)\n" +
                            "value 5000 is in the last position in the array (position 49999)\n" +
                            "value 2500 is in the middle position in the array (position 2499)");
                    System.out.println("Let's use a Binary Search to find the first, middle and last element!");

                    System.out.println("- Sorted Array - searching the first element (number 1):");
                    timeToSequentialSearch(sortedArray, 1);

                    System.out.println("- Sorted Array - searching the last element (number 5000):");
                    timeToSequentialSearch(sortedArray, 5000);

                    System.out.println("- Sorted Array - searching the middle element (number 2500) - the fastest:");
                    timeToSequentialSearch(sortedArray, 2500);

                    break;
                case '3':
                    System.out.println("Find a value in the sorted array using binary search.\nType the value:");
                    value = input.nextInt();

                    System.out.println("- Sorted Array:");
                    timeToSequentialSearch(sortedArray, value);

                    break;
                case '4':
                    System.out.println("The end!");
                    break;
                default:
                    System.out.println("Invalid option. Try again!");
            }
        } while (option != '4');
        System.exit(0);
    }


    /*
     * Auxiliary Methods
     */

    public static Character menu(Scanner input) {
        String msg = "\n\nChoose an option:\n" +
                "1. Show sorted array\n" +
                "2. Exemplify binary search performance\n" +
                "3. Search item in the sorted array\n" +
                "4. Exit";

        System.out.println(msg);

        var chosenOption = input.next().toCharArray();
        return chosenOption[0];
    }

    public static int[] sortArray(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static Item[] createItemsArray(int[] numbers) {
        Item[] vector = new Item[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            vector[i] = new Item(numbers[i]);
        }

        return vector;
    }

    public static String printItemsArray(Item[] vector) {
        String msg = "";
        int i;
        for (i = 0; i < vector.length; i++) {
            msg += "[" + vector[i].getKey() + "] ";
        }
        return msg;
    }

    public static void timeToSequentialSearch(Item[] vector, int value) {
        doWarmUp(vector, value);

        long startTime = System.nanoTime();;
        int positionFound = binarySearch(vector, value);
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime);
        if(positionFound == -1) {
            System.out.println("   It took " + totalTime + " nano seconds to search the array, and the element " + value + " was not found.");
        } else{
            System.out.println("   Element " + value + " found at position " + positionFound + " in the array.");
            System.out.println("   It took " + totalTime + " nano seconds to find.");
        }
    }

    public static void doWarmUp(Item[] vector, int value) {
        binarySearch(vector, value);
    }
}
