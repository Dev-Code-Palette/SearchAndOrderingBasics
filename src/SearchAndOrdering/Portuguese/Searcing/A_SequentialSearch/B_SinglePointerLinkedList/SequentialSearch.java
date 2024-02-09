package SearchAndOrdering.Portuguese.Searcing.A_SequentialSearch.B_SinglePointerLinkedList;

public class SequentialSearch {

    public static Node sequentialSearch(SinglePointerLinkedList list, int key) {
        Node currentNode = list.getFirstNode();
        while ((currentNode != null) && (currentNode.getInfo().getKey() != key))
            currentNode = currentNode.getNextNode();
        return currentNode;
    }

}
