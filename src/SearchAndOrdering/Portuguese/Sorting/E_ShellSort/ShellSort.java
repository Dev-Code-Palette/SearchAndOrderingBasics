package SearchAndOrdering.Portuguese.Sorting.E_ShellSort;

public class ShellSort {

    public static void shellSort(Item[] vector) {
        int i, j, h;
        Item temp;
        h = 1;
        do {
            h = 3 * h + 1;
        } while (h < vector.length);
        do {
            h = h / 3;
            for (i = h; i < vector.length; i++) {
                temp = vector[i];
                j = i;
                while (vector[j - h].getKey() > temp.getKey()) {
                    vector[j] = vector[j - h];
                    j -= h;
                    if (j < h) break;
                }
                vector[j] = temp;
            }
        } while (h != 1);
    }

}
