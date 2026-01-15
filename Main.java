import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    Node root;

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insertRec(root.left, data);
        else if (data > root.data) root.right = insertRec(root.right, data);
        return root;
    }

    Node delete(Node root, int key) {
        if (root == null) return null;
        if (key < root.data) root.left = delete(root.left, key);
        else if (key > root.data) root.right = delete(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    int countNodes() {
        return countNodesRec(root);
    }

    int countNodesRec(Node root) {
        if (root == null) return 0;
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }

    int countLeaves() {
        return countLeavesRec(root);
    }

    int countLeavesRec(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeavesRec(root.left) + countLeavesRec(root.right);
    }

    boolean isValidBST() {
        return isValidBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValidBSTRec(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return isValidBSTRec(root.left, min, root.data) && isValidBSTRec(root.right, root.data, max);
    }

    void levelOrder() {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
        System.out.println();
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] arr = {5, 1, 3, 4, 2, 6, 7};
        for (int i : arr) tree.insert(i);

        tree.inorder();
        tree.levelOrder();
        System.out.println(tree.countNodes());
        System.out.println(tree.countLeaves());
        System.out.println(tree.isValidBST());

        tree.root = tree.delete(tree.root, 2);
        tree.root = tree.delete(tree.root, 3);
        tree.root = tree.delete(tree.root, 5);

        tree.inorder();
        tree.levelOrder();
        System.out.println(tree.countNodes());
        System.out.println(tree.countLeaves());
        System.out.println(tree.isValidBST());
    }
}

