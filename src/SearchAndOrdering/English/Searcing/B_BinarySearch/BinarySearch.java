package SearchAndOrdering.English.Searcing.B_BinarySearch;

public class BinarySearch {

    public static int binarySearch(Item[] vector, int key) {
        int middle, left, right;
        left = 0;
        right = vector.length - 1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (key == vector[middle].getKey())
                return middle;
            else {
                if (key < vector[middle].getKey())
                    right = middle - 1;
                else
                    left = middle + 1;
            }
        }
        return -1;

    }

}
