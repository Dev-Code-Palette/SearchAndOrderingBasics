package SearchAndOrdering.Portuguese.Sorting.C_ShakeSort;

public class ShakeSort {

    public static void shakersort(Item[] vector) {
        int esq, dir, i, j;
        Item temp;
        esq = 1;
        dir = vector.length - 1;
        j = dir;
        do { //leva as menores chaves para o início
            for (i = dir; i >= esq; i--)
                if (vector[i - 1].getKey() > vector[i].getKey()) {
                    temp = vector[i];
                    vector[i] = vector[i - 1];
                    vector[i - 1] = temp;
                    j = i;
                }
            esq = j + 1;
            //leva as maiores chaves para o final
            for (i = esq; i <= dir; i++)
                if (vector[i - 1].getKey() > vector[i].getKey()){
                temp = vector[i];
                vector[i] = vector[i - 1];
                vector[i - 1] =temp;
                j = i;
            }
            dir = j - 1;
        } while (esq <= dir);
    }
}
