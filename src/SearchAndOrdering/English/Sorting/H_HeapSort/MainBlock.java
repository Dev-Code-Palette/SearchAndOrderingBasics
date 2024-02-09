package SearchAndOrdering.English.Sorting.H_HeapSort;

import static SearchAndOrdering.English.Sorting.H_HeapSort.HeapSort.heapSort;

public class MainBlock {
    public static void main(String[] args) {

        int[] numbers = {5, 2, 7, 3, 4};
        Item[] itemsArray = createItemsArray(numbers);

        System.out.println("Original array -> " + printItemsArray(itemsArray));
        heapSort(itemsArray);
        System.out.println("After HeapSort -> " + printItemsArray(itemsArray));
    }

    /*
    * Auxiliary Methods
    */

    public static Item[] createItemsArray(int[] numbers) {
        Item[] vector = new Item[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
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


}
