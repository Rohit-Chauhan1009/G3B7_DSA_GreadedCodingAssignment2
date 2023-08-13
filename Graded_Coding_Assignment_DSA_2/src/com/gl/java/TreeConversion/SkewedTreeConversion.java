package com.gl.java.TreeConversion;

class SkewedTreeConversion
{
    public static TreeNode node;
    static TreeNode prevNode = null;
    static TreeNode headNode = null;
   
    // Function to flatten the binary
    // search tree into a skewed tree in
    // increasing / decreasing order
    static void flattenBTToSkewed(TreeNode root,
                                  int order)
    {
       
        // Base Case
        if(root == null)
        {
            return;
        }
       
        // Condition to check the order
        // in which the skewed tree to
        // maintained
        if(order > 0)
        {
            flattenBTToSkewed(root.right, order);
        }
        else
        {
            flattenBTToSkewed(root.left, order);
        }
        TreeNode rightNode = root.right;
        TreeNode leftNode = root.left;
       
        // Condition to check if the root Node
        // of the skewed tree is not defined
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
        // Similarly recurse for the left / right
        // subtree on the basis of the order required
        if (order > 0)
        {
            flattenBTToSkewed(leftNode, order);
        }
        else
        {
            flattenBTToSkewed(rightNode, order);
        }
    }
   
    // Function to traverse the right
    // skewed tree using recursion
    static void traverseRightSkewed(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);       
    }
   
    // Driver Code
    public static void main (String[] args)
    {
       //    5
       //     / \
       //  3   6
    	SkewedTreeConversion tree = new SkewedTreeConversion();
        
        tree.node = new TreeNode(50);
        tree.node.left = new TreeNode(30);
        tree.node.right = new TreeNode(60);
        tree.node.left.left = new TreeNode(10);
        tree.node.right.left= new TreeNode(55);


        // Order of the Skewed tree can
        // be defined as follows -
        // For Increasing order - 0
        // For Decreasing order - 1
        int order = 0;
        flattenBTToSkewed(node, order);
        traverseRightSkewed(headNode);
    }
}
