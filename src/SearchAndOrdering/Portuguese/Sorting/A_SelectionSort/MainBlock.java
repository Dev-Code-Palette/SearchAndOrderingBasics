package SearchAndOrdering.Portuguese.Sorting.A_SelectionSort;


import static SearchAndOrdering.Portuguese.Sorting.A_SelectionSort.SelectionSort.selectionSort;

public class MainBlock {
    public static void main(String[] args) {

        int[] numbers = {5, 2, 7, 3, 4};
        Item[] itemsArray = createItemsArray(numbers);

        System.out.println("Array original -> " + printItemsArray(itemsArray));
        selectionSort(itemsArray);
        System.out.println("Após SelectionSort -> " + printItemsArray(itemsArray));
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
