package SearchAndOrdering.Portuguese.Sorting.G_QuickSort;

public class QuickSort {

    public static void quickSort(Item[] vector) {
        order(vector, 0, vector.length - 1);
    }

    private static void order(Item[] vector, int left, int right) {
        int pivot, i = left, j = right;
        Item temp;

        pivot = vector[(i + j) / 2].getKey();
        do {
            while (vector[i].getKey() < pivot) i++;
            while (vector[j].getKey() > pivot) j--;
            if (i <= j) {
                temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
                i++;
                j--;
            }
        } while (i <= j); if (left < j) order(vector, left, j);
        if (right > i) order(vector, i, right);
    }


}
