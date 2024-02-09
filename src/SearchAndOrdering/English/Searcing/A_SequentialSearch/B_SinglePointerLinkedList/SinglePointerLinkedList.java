package SearchAndOrdering.English.Searcing.A_SequentialSearch.B_SinglePointerLinkedList;

public class SinglePointerLinkedList {
    private Node firstNode;
    private Node lastNode;
    private int nodesQtd;

    /**
     * Class constructor. Everytime a new SinglePointerLinkedList is instanced, it will begin
     * with no Nodes, and with nodesQtd == 0.
     * To add or remove a Node, it will be used one of the following methods on this class
     */
    public SinglePointerLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
        this.nodesQtd = 0;
    }

    public int getNodesQtd() {
        return this.nodesQtd;
    }

    public Node getFirstNode() {
        return this.firstNode;
    }

    public Node getLastNode() {
        return this.lastNode;
    }

    public boolean isEmpty() {
        return (this.firstNode == null);
    }

    //Insert Node on the last position of this SinglePointerLinkedList
    public void insertLastNode(Item elem) {
        Node newLastNode = new Node(elem);

        if (this.isEmpty()) {
            this.firstNode = newLastNode; //if the SinglePointerLinkedList is empty, this newNode that is being inserted is both the last and the first node on this SinglePointerLinkedList
        } else {
            this.lastNode.setNextNode(newLastNode); //if the SinglePointerLinkedList is not empty, the previous last node, now points on nextNode to the newLastNode
        }
        this.lastNode = newLastNode; //the lastNode is now the newLastNode
        this.nodesQtd++; //there is 1 more new Node on this SinglePointerLinkedList
    }

    //Used to print the list items on the screen
    public String toString() {
        String msg = "";
        Node currentNode = this.firstNode;
        while (currentNode != null) {
            msg += "[" + currentNode.getInfo().getKey() + "] ";
            currentNode = currentNode.getNextNode();
        }
        return msg;
    }
}
