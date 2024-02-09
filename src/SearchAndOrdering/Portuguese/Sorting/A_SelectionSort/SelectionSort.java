package SearchAndOrdering.Portuguese.Sorting.A_SelectionSort;

public class SelectionSort {

    public static void selectionSort(Item[] vector) {
        int i, j, minimum;
        Item temp;
        for (i = 0; i < vector.length - 1; i++) {
            minimum = i;
            for (j = i + 1; j < vector.length; j++)
                if (vector[j].getKey() < vector[minimum].getKey())
                    minimum = j;
            temp = vector[minimum];
            vector[minimum] = vector[i];
            vector[i] = temp;
        }
    }

}
