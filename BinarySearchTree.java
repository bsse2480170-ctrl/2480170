public class BinarySearchTree {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    static Node root;
    public static void main(String[] args) {
        int[] values={50,30,70,20,40,60,80};
        for(int val:values){
            root=insert(root,val);
        }
        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println();
        System.out.println("Postorder Traversal:");
        postorder(root);
        System.out.println();

        System.out.println("Preorder Traversal:");
        preorder(root);
        System.out.println();

        int searchKey=60;
        System.out.println("Search 60:"+search(root,searchKey));

        root=delete(root,80);
        System.out.println("Inorder after deleting 80: ");
        inorder(root);
        System.out.println();

        System.out.println("Minimum value:"+findMin(root));
        System.out.println("Maximum value:"+findMax(root));
        System.out.println("Total nodes:"+countNodes(root));
        System.out.println("Leaf nodes:"+countleafNodes(root));

        System.out.println("height of BST:"+height(root));
    }
    static Node insert(Node root, int data) {
        if(root==null)
            return new Node(data);
        if (data<root.data)
            root.left=insert(root.left,data);
        else
            root.right=insert(root.right,data);
        return root;
    }
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    static boolean search(Node root, int key) {
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
    static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key> root.data) {
            root.right = delete(root.right, key);
        }else {
            if(root.left ==null){
                return root.right;
            } else if (root.right==null) {
                return root.left;
            }
            root.data=minValue(root.right);
            root.right=delete(root.right, root.data);
        }
        return root;
    }
    static int minValue(Node root) {
        int min= root.data;
        while(root.left!=null){
            min= root.left.data;
            root=root.left;
        }
        return min;
    }
    static int findMin(Node root) {
        while(root.left!=null){
            root=root.left;
        }
        return root.data;
    }
    static int findMax(Node root) {
        while(root.right!=null){
            root=root.right;
        }
        return root.data;
    }
    static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    static int countleafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countleafNodes(root.left) + countleafNodes(root.right);
    }
    static int height(Node root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
