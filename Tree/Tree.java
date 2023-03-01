package Practice.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public static void main(String[] args) {

        Node node1 = new Node("a");
        Node node2 = new Node("b");
        Node node3 = new Node("c");
        Node node4 = new Node("d");

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        BinaryTree tree = new BinaryTree(node1); 
        PreOrderTraversal(tree);
        PostOrderTraversal(tree);
        InOrderTraversal(tree);
        BreadthFirstTraversal(tree);

        System.out.print("\n");
    }

    private static void PreOrderTraversal(BinaryTree tree) {
        System.out.print("\nPreOrderTraversal Root[" + tree.root.value + "] -> ");
        PreOrderTraversal(tree.root);
    }

    private static void PostOrderTraversal(BinaryTree tree) {
        System.out.print("\nPostOrderTraversal Root[" + tree.root.value + "] -> ");
        PostOrderTraversal(tree.root);
    }

    private static void InOrderTraversal(BinaryTree tree) {
        System.out.print("\nInOrderTraversal Root[" + tree.root.value + "] -> ");
        InOrderTraversal(tree.root);
    }

    private static void BreadthFirstTraversal(BinaryTree tree) {
        System.out.print("\nBreadthFirstTraversal Root[" + tree.root.value + "] -> ");
        BreadthFirstTraversal(tree.root);
    }

    /*
     * BFS
     * 
     * Queue root - uses a queue to keep track of nodes to visit. After visiting a node, 
     * its children are put in the queue. To get a new node to traverse, we take out elements 
     * from the queue.
     * 
     * Pop node
     *      print node
     *      queue left node
     *      queue right node
     * 
     */
    private static void BreadthFirstTraversal(Node node) {
        if (node != null) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node tempNode = queue.poll();
                System.out.print(tempNode.value + " ");
     
                /*add left child to the queue */
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
     
                /*add right right child to the queue */
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }

        }
    }


    /*
     * Pre-order - NLR - DFS 
     * 
     * In depth-first search (DFS), the search tree is deepened as much as 
     * possible before going to the next sibling.
     * 
     * Visit the current node (in the figure: position red).
     * Recursively traverse the current node's left subtree.
     * Recursively traverse the current node's right subtree.
     * 
     * Parent node is processed before any of its child nodes is done.
     */
    private static void PreOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            PreOrderTraversal(node.left);
            PreOrderTraversal(node.right);
        }
    }

    /*
     * Post-order, LRN
     * 
     * Recursively traverse the current node's left subtree.
     * Recursively traverse the current node's right subtree.
     * Visit the current node (in the figure: position blue).
     */
    private static void PostOrderTraversal(Node node) {
        if (node != null) {
            PostOrderTraversal(node.left);
            PostOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }

    /*
     * In-order, LNR - in-order traversal to a Binary Search Tree
     * 
     * Recursively traverse the current node's left subtree.
     * Visit the current node (in the figure: position green).
     * Recursively traverse the current node's right subtree.
     * 
     * If we perform an inorder traversal to a Binary Search Tree, 
     * we will get a sorted list (in non-descending order). 
     * 
     */
    private static void InOrderTraversal(Node node) {
        if (node != null) {
            InOrderTraversal(node.left);
            System.out.print(node.value + " ");
            InOrderTraversal(node.right);
        }
    }

}
