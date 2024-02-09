package SearchAndOrdering.English.Searcing.D_SelfBalancingTree;


import java.util.Scanner;

import static SearchAndOrdering.AuxArray.auxArray;

/* Class SelfBalancingBinarySearchTreeTest */
public class MainBlock
{
    public static void main(String[] args) {
        Item[] vector;
        Scanner input = new Scanner(System.in);
        int value;
        char option;
        SelfBalancingBinarySearchTree tree = createTree(auxArray);

        do {
            option = menu(input);
            switch (option) {
                case '1':
                    if (tree.isEmpty()) {
                        System.out.println("Tree is empty!");
                    } else {
                        tree.inOrderSearch();
                    }
                    break;
                case '2':
                    System.out.println("In the following tree with 5000 elements, the element with value 1 is in the following positions for each list:\n" +
                            "Sorted List -> value 1 is in the first position in the list (position 0)\n" +
                            "Reverse Sorted List -> value 1 is in the last position in the list (position 4999)\n" +
                            "Random List -> value 1 is in the middle position in the list (position 2500)\n");
                    System.out.println("Let's use a Sequential Search that searches from the first element to the last to find the value 1!");

                    System.out.println("- Sorted List (the fastest to find number 1):");
                    timeToSearch(tree, 1);

                    System.out.println("- Reverse Sorted List (the slowest to find number 1):");
                    timeToSearch(tree, 2499);

                    System.out.println("- Random List:");
                    timeToSearch(tree, 5000);

                    break;
                case '3':
                    System.out.println("Find a value in the tree using sequential search that searches from the first element to the the last one.\nType the value:");
                    value = input.nextInt();

                    System.out.println("- Tree:");
                    timeToSearch(tree, value);

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

    public static Character menu(Scanner input) {
        String msg = "\n\nChoose an option:\n" +
                "1. Show tree\n" +
                "2. Exemplify search performance\n" +
                "3. Search item in the tree\n" +
                "4. Exit";

        System.out.println(msg);

        var chosenOption = input.next().toCharArray();
        return chosenOption[0];
    }


    public static SelfBalancingBinarySearchTree createTree(int[] numbers) {
        SelfBalancingBinarySearchTree tree = new SelfBalancingBinarySearchTree();

        for (int number : numbers) {
            tree.insertItem(number);
        }

        return tree;
    }

    public static void timeToSearch(SelfBalancingBinarySearchTree tree, int value) {
        doWarmUp(tree, value);
        long startTime = System.nanoTime();;
        boolean found = tree.searchItem(value);
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime);
        if(found) {
            System.out.println("   Element " + value + " found in the list.");
            System.out.println("   It took " + totalTime + " nano seconds to find.");
        } else {
            System.out.println("   It took " + totalTime + " nano seconds to search the list, and the element " + value + " was not found.");
        }
    }

    public static void doWarmUp(SelfBalancingBinarySearchTree tree, int value) {
        tree.searchItem(value);
    }
}