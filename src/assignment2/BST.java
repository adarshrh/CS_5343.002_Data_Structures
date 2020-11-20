/**
 * Name: Adarsh Raghupati Hegde
 * NetId: axh190002
 */


package assignment2;

public class BST {

    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    TreeNode root;
    BST(){
        root = null;
    }

    /**
     * Prints the values in inorder
     */
    public void traverseInorder(){
        System.out.println("=====================================");
        traverseInorder(root);
        System.out.println();
    }

    /**
     * Recursive helper function to print the values in inorder
     * @param root
     */
    public void traverseInorder(TreeNode root){
        if (root != null)
        {
            traverseInorder(root.left);
            System.out.print(root.val + " ");
            traverseInorder(root.right);
        }
    }

    /**
     * Insert a node with given value
     * @param value
     */
    public void insert(int value){
        root = insert(root,value);
    }

    /**
     * Recursive helper function to insert a node with given value
     * @param root
     * @param value
     * @return
     */
    public TreeNode insert(TreeNode root, int value){
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value <= root.val)
            root.left = insert(root.left, value);
        else if (value > root.val)
            root.right = insert(root.right, value);
        return root;
    }

    /**
     * Deletes the node having the given value
     * @param value
     */
    void delete(int value) {
        root = delete(root, value);
    }

    /**
     * Recursive helper function to delete a node with given value
     * @param root
     * @param value
     * @return
     */
    private TreeNode delete(TreeNode root, int value) {
        if (root == null)
            return root;
        if (value < root.val)
            root.left = delete(root.left, value);
        else if (value > root.val)
            root.right = delete(root.right, value);
        else {
            // if node has single child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // if node has two children find the inorder predecessor
            root.val = findPredecessor(root.left);
            // Delete the inorder predecessor
            root.left = delete(root.left, root.val);
        }
        return root;
    }

    /**
     * Finds the value of inorder predecessor
     * @param root
     * @return
     */
    int findPredecessor (TreeNode root)
    {
        int value = root.val;
        while (root.right != null) {
            value = root.right.val;
            root = root.right;
        }
        return value;
    }

    public static void main(String[] arg){
        BST bst = new BST();
        //Values are inserted in the order 50, 40, 80, 20, 45, 60, 100, 70, 65, 42, 44, 30, 25, 35, 33
        int[] elements = {50, 40, 80, 20, 45, 60, 100, 70, 65, 42, 44, 30, 25, 35, 33};
        for(int v : elements){
            bst.insert(v);
        }
        System.out.println("After inserting:");
        bst.traverseInorder();
        System.out.println("a) Delete 50:");
        bst.delete(50);
        bst.traverseInorder();
        System.out.println("b) Delete 40:");
        bst.delete(40);
        bst.traverseInorder();
        System.out.println("c) Delete 65:");
        bst.delete(65);
        bst.traverseInorder();
        System.out.println("d) Delete 35:");
        bst.delete(35);
        bst.traverseInorder();
    }
}
