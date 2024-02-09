package SearchAndOrdering.Portuguese.Sorting.H_HeapSort;

public class HeapSort {

    public static void heapSort(Item[] vector) {
        int right = vector.length - 1;
        int left = (right - 1) / 2;
        Item temp;

        while (left >= 0) {
            redoHeap(vector, left, vector.length - 1);
            left--;
        }
        while (right > 0) {
            temp = vector[0];
            vector[0] = vector[right];
            vector[right] = temp;
            right--;
            redoHeap(vector, 0, right);
        }
    }

    private static void redoHeap(Item[] vector, int left, int right) {
        int i = left;
        int biggestValue = 2 * i + 1;
        Item root = vector[i];
        boolean heap = false;

        while ((biggestValue <= right) && (!heap)) {
            if (biggestValue < right)
                if (vector[biggestValue].getKey() <
                        vector[biggestValue + 1].getKey())
                    biggestValue++;
            if (root.getKey() < vector[biggestValue].getKey()) {
                vector[i] = vector[biggestValue];
                i = biggestValue;
                biggestValue = 2 * i + 1;
            } else
                heap = true;
        }
        vector[i] = root;
    }

}
