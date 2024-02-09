package SearchAndOrdering.English.Searcing.A_SequentialSearch.B_SinglePointerLinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static SearchAndOrdering.English.Searcing.A_SequentialSearch.B_SinglePointerLinkedList.SequentialSearch.sequentialSearch;
import static SearchAndOrdering.AuxArray.auxArray;

public class MainBlock {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int value;
        char option;
        Boolean isReversed = true;

        SinglePointerLinkedList randomList = createItemsList(auxArray);
        SinglePointerLinkedList sortedList = createItemsList(sortArray(auxArray, !isReversed));
        SinglePointerLinkedList reverseSortedList = createItemsList(sortArray(auxArray, isReversed));

        do {
            option = menu(input);

            switch (option) {
                case '1':
                    System.out.println("Showing lists:");
                    System.out.println("Random List: " +  printItemsList(randomList));
                    System.out.println("Sorted List: " +  printItemsList(sortedList));
                    System.out.println("Reverse Sorted List: " +  printItemsList(reverseSortedList));

                    break;
                case '2':
                    System.out.println("In the following lists with 5000 elements, the element with value 1 is in the following positions for each list:\n" +
                            "Sorted List -> value 1 is in the first position in the list (position 0)\n" +
                            "Reverse Sorted List -> value 1 is in the last position in the list (position 4999)\n" +
                            "Random List -> value 1 is in the middle position in the list (position 2500)\n");
                    System.out.println("Let's use a Sequential Search that searches from the first element to the last to find the value 1!");

                    System.out.println("- Sorted List (the fastest to find number 1):");
                    timeToSequentialSearch(sortedList, 1);

                    System.out.println("- Reverse Sorted List (the slowest to find number 1):");
                    timeToSequentialSearch(reverseSortedList, 1);

                    System.out.println("- Random List:");
                    timeToSequentialSearch(randomList, 1);

                    break;
                case '3':
                    System.out.println("Find a value in the lists using sequential search that searches from the first element to the the last one.\nType the value:");
                    value = input.nextInt();

                    System.out.println("- Sorted List:");
                    timeToSequentialSearch(sortedList, value);

                    System.out.println("- Reverse Sorted List:");
                    timeToSequentialSearch(reverseSortedList, value);

                    System.out.println("- Random List:");
                    timeToSequentialSearch(randomList, value);

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
                "1. Show lists (random, sorted and reversed sorted)\n" +
                "2. Exemplify sequential search performance\n" +
                "3. Search item in the random, sorted and reversed sorted lists\n" +
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

    public static SinglePointerLinkedList createItemsList(int[] numbers) {
        SinglePointerLinkedList list = new SinglePointerLinkedList();

        for (int number : numbers) {
            list.insertLastNode(new Item(number));
        }

        return list;
    }

    public static String printItemsList(SinglePointerLinkedList list) {
        String msg = "";
        Node currentNode = list.getFirstNode();
        while (currentNode != null) {
            msg += "[" + currentNode.getInfo().getKey() + "] ";
            currentNode = currentNode.getNextNode();
        }
        return msg;
    }

    public static void timeToSequentialSearch(SinglePointerLinkedList list, int value) {
        doWarmUp(list, value);
        long startTime = System.nanoTime();;
        Node nodeFound = sequentialSearch(list, value);
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime);
        if(nodeFound == null) {
            System.out.println("   It took " + totalTime + " nano seconds to search the list, and the element " + value + " was not found.");
        } else{
            System.out.println("   Element " + value + " found in the list.");
            System.out.println("   It took " + totalTime + " nano seconds to find.");
        }
    }

    public static void doWarmUp(SinglePointerLinkedList list, int value) {
        sequentialSearch(list, value);
    }
}
