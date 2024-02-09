package SearchAndOrdering.English.Searcing.D_SelfBalancingTree;

class SelfBalancingBinarySearchTree {
    private Node root;

    /**
     * Class constructor. When a SelfBalancingBinarySearchTree is instanced, it will begin
     * with no Nodes.
     * To add or remove an Item, it will be used one of the following methods on this class
     */
    public SelfBalancingBinarySearchTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    //Make the tree logically empty
    public void clear() {
        root = null;
    }

    //Function to get height of node
    private int height(Node t) {
        return t == null ? -1 : t.getHeight();
    }

    /* Function to max of left/right node */
    private int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    //Insert Item in this Tree
    public boolean insertItem(int key) {
        if(searchItem(key)) {
            return false;
        } else{
            root = doInsertItem(key, root);
            return true;
        }
    }

    // Function to insert recursively item
    private Node doInsertItem(int key, Node node) {
        if (node == null)
            node = new Node(new Item(key));
        else if (key < node.getInfo().getKey()) {
            node.setLeft(doInsertItem(key, node.getLeft()));
            if (height(node.getLeft()) - height(node.getRight()) == 2)
                if (key < node.getLeft().getInfo().getKey())
                    node = rotateWithLeftChild(node);
                else
                    node = doubleWithLeftChild(node);
        } else if (key > node.getInfo().getKey()) {
            node.setRight(doInsertItem(key, node.getRight()));
            if (height(node.getRight()) - height(node.getLeft()) == 2)
                if (key > node.getRight().getInfo().getKey())
                    node = rotateWithRightChild(node);
                else
                    node = doubleWithRightChild(node);
        }

        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        return node;
    }

    //Rotate binary tree node with left child
    private Node rotateWithLeftChild(Node k2) {
        Node k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(max(height(k1.getLeft()), k2.getHeight()) + 1);
        return k1;
    }

    //Rotate binary tree node with right child
    private Node rotateWithRightChild(Node k1) {
        Node k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setHeight(max(height(k1.getLeft()), height(k1.getRight())) + 1);
        k2.setHeight(max(height(k2.getRight()), k1.getHeight()) + 1);
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child
     */
    private Node doubleWithLeftChild(Node k3) {
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child
     */
    private Node doubleWithRightChild(Node k1) {
        k1.setRight(rotateWithLeftChild(k1.getRight()));
        return rotateWithRightChild(k1);
    }

    //Count number of nodes in this tree
    public int countNodes() {
        return doCountNodes(root);
    }

    private int doCountNodes(Node node) {
        if (node == null)
            return 0;
        else {
            int l = 1;
            l += doCountNodes(node.getLeft());
            l += doCountNodes(node.getRight());
            return l;
        }
    }

    //Search an Item in this Tree
    public boolean searchItem(int key) {
        return doSearchItem(root, key);
    }

    private boolean doSearchItem(Node node, int key) {
        boolean found = false;
        while ((node != null) && !found) {
            int rval = node.getInfo().getKey();
            if (key < rval)
                node = node.getLeft();
            else if (key > rval)
                node = node.getRight();
            else {
                found = true;
                break;
            }
            found = doSearchItem(node, key);
        }
        return found;
    }

    //Inorder search
    public void inOrderSearch() {
        doInorderSearch(root);
    }

    private void doInorderSearch(Node r) {
        if (r != null) {
            doInorderSearch(r.getLeft());
            System.out.print("[" + r.getInfo().getKey() + "] ");
            doInorderSearch(r.getRight());
        }
    }
}
