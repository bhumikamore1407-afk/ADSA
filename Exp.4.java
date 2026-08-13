class BST {

static class Node{
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    // Search function
    boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public static void main(String[] args) {

        BST tree = new BST();

        // Creating BST
        tree.root = new Node(25);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(15);
        tree.root.left.right = new Node(21);
        tree.root.right.left = new Node(26);
        tree.root.right.right = new Node(31);

        int key = 26;

        if (tree.search(tree.root, key)) {
            System.out.println(key + " found");
        } else {
            System.out.println(key + " not found");
        }
    }
}