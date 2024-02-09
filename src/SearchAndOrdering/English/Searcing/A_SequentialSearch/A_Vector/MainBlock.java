package SearchAndOrdering.English.Searcing.A_SequentialSearch.A_Vector;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static SearchAndOrdering.English.Searcing.A_SequentialSearch.A_Vector.SequentialSearch.sequentialSearch;
import static SearchAndOrdering.AuxArray.auxArray;

public class MainBlock {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int value;
        char option;
        Boolean isReversed = true;

        Item[] randomArray = createItemsArray(auxArray);
        Item[] sortedArray = createItemsArray(sortArray(auxArray, !isReversed));
        Item[] reverseSortedArray = createItemsArray(sortArray(auxArray, isReversed));

        do {
            option = menu(input);

            switch (option) {
                case '1':
                    System.out.println("Showing arrays:");
                    System.out.println("Random Array: " +  printItemsArray(randomArray));
                    System.out.println("Sorted Array: " +  printItemsArray(sortedArray));
                    System.out.println("Reverse Sorted Array: " +  printItemsArray(reverseSortedArray));
                    break;
                case '2':
                    System.out.println("In the following arrays with 5000 elements, the element with value 1 is in the following positions for each array:\n" +
                            "Sorted Array -> value 1 is in the first position in the array (position 0)\n" +
                            "Reverse Sorted Array -> value 1 is in the last position in the array (position 4999)\n" +
                            "Random Array -> value 1 is in the middle position in the array (position 2500)\n");
                    System.out.println("Let's use a Sequential Search that searches from the last element to the the first to find the value 1!");

                    System.out.println("- Sorted Array (the slowest to find number 1):");
                    timeToSequentialSearch(sortedArray, 1);

                    System.out.println("- Reverse Sorted Array (the fastest to find number 1):");
                    timeToSequentialSearch(reverseSortedArray, 1);

                    System.out.println("- Random Array:");
                    timeToSequentialSearch(randomArray, 1);

                    break;
                case '3':
                    System.out.println("Find a value in the arrays using sequential search that searches from the last element to the the first.\nType the value:");
                    value = input.nextInt();

                    System.out.println("- Sorted Array:");
                    timeToSequentialSearch(sortedArray, value);

                    System.out.println("- Reverse Sorted Array:");
                    timeToSequentialSearch(reverseSortedArray, value);

                    System.out.println("- Random Array:");
                    timeToSequentialSearch(randomArray, value);

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
                "1. Show arrays (random, sorted and reversed sorted)\n" +
                "2. Exemplify sequential search performance\n" +
                "3. Search item in the random, sorted and reversed sorted arrays\n" +
                "4. Exit";

        System.out.println(msg);

        var chosenOption = input.next().toCharArray();
        return chosenOption[0];
    }

    public static int[] sortArray(int[] array, Boolean isReversed) {
        return Arrays.stream(array)
                .boxed()
                .sorted(isReversed ? Comparator.reverseOrder() : Comparator.naturalOrder())
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
        int positionFound = sequentialSearch(vector, value);
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
        sequentialSearch(vector, value);
    }
}
