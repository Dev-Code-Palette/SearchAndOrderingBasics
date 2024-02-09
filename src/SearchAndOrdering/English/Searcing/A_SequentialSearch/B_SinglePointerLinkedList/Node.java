package SearchAndOrdering.English.Searcing.A_SequentialSearch.B_SinglePointerLinkedList;

public class Node {
    private Item info; //What is stored in each Node
    private Node nextNode;

    /**
     * Class constructor, everytime a new Node is created,
     * it has to be informed what Item is to be stored in the Node
     */
    public Node(Item elem) {
        this.info = elem;
        this.nextNode = null; // Optional line, since the next element is automatically set as Null
    }

    //Getters and Setters for Item(info) and Node(nextNode)
    public Item getInfo() {
        return this.info;
    }

    public void setInfo(Item elem) {
        this.info = elem;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node _node) {
        this.nextNode = _node;
    }
}
