package SearchAndOrdering.English.Sorting.D_InsertionSort;

public class InsertionSort {

    public static void insertionSort(Item[] vector) {
        int i, j;
        Item temp;

        for (i = 1; i < vector.length; i++) {
            temp = vector[i];
            j = i - 1;
            while ((j >= 0) &&
                    (vector[j].getKey() > temp.getKey())) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = temp;
        }
    }

}
