package SearchAndOrdering.Portuguese.Searcing.A_SequentialSearch.A_Vector;

public class SequentialSearch {

    public static int sequentialSearch(Item[] vector, int key) {
        int pos = vector.length - 1;
        while ((pos >= 0) && (vector[pos].getKey() != key)) {
            pos--;
        }
        return pos;
    }

}
