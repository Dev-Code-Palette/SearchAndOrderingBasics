package SearchAndOrdering.Portuguese.Sorting.F_MergeSort;

public class MergeSort {

    public static void mergeSort(Item[] vector) {
        mergeSort(vector, 0, vector.length - 1);
    }

    public static void mergeSort(Item[] vector, int left, int right) {

        if (left >= right)
            return;
        else {
            int middle = (left + right) / 2;
            mergeSort(vector, left, middle);
            mergeSort(vector, middle + 1, right);

            merge(vector, left, middle, right);
        }

    }

    public static void merge(Item[] v, int left, int middle, int right) {

        // transfere os elementos entre left e right para um array auxiliar.
        Item[] helper = new Item[v.length];
        for (int i = left; i <= right; i++) {
            helper[i] = v[i];
        }


        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (helper[i].getKey() <= helper[j].getKey()) {
                v[k] = helper[i];
                i++;
            } else {
                v[k] = helper[j];
                j++;
            }
            k++;
        }

        // se a metade inicial não foi toda consumida, faz o append.
        while (i <= middle) {
            v[k] = helper[i];
            i++;
            k++;
        }

        // se a metade final não foi toda consumida, faz o append.
        while (j <= right) {
            v[k] = helper[j];
            j++;
            k++;
        }

    }

}
