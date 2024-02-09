package SearchAndOrdering.English.Sorting.B_BubbleSort;

public class BubbleSort {

    public static void bubblesort(Item[] vector) {
        int LSup, i, j;
        Item temp;

        LSup = vector.length - 1;
        do {
            j = 0;
            for (i = 0; i < LSup; i++) {
                if (vector[i].getKey() > vector[i + 1].getKey()) {
                    temp = vector[i];
                    vector[i] = vector[i + 1];
                    vector[i + 1] = temp;
                    j = i;
                }
            }
            LSup = j;
        } while (LSup >= 1);
    }
}
