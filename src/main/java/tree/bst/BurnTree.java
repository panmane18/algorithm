package tree.bst;
import java.util.*;

class BurnTree {
    // Method to burn the tree starting from a given node
    public int timeToBurnTree(TreeNode root, int start) {
        // Create a map to store the parent nodes
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        // Get the target node (starting node for burning)
        TreeNode target = bfsToMapParents(root, mpp, start);
        // Find the maximum distance to burn the tree
        int maxi = findMaxDistance(mpp, target);
        return maxi;
    }

    // Method to map parents of all nodes using BFS
    private TreeNode bfsToMapParents(TreeNode root, HashMap<TreeNode, TreeNode> mpp, int start) {
        // Queue for BFS
        Queue<TreeNode> q = new LinkedList<>();
        // Push the root node to the queue
        q.offer(root);
        TreeNode res = new TreeNode(-1);

        while (!q.isEmpty()) {
            // Get the front node from the queue
            TreeNode node = q.poll();
            // Check if this is the start node
            if (node.data == start) res = node;
            // Map the left child to its parent
            if (node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            // Map the right child to its parent
            if (node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }

    // Method to find the maximum distance to burn the tree
    private int findMaxDistance(HashMap<TreeNode, TreeNode> mpp, TreeNode target) {
        // Queue for BFS to find max distance
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        // Map to check visited nodes
        HashMap<TreeNode, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int fl = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Check left child
                if (node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }

                // Check right child
                if (node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                // Check parent node
                if (mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            // Increment max distance if any node was burned
            if (fl == 1) maxi++;
        }
        return maxi;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        BurnTree burnTree = new BurnTree();

        // Create the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int start = 4;

        // Get the time to burn the tree
        int result = burnTree.timeToBurnTree(root, start);
        System.out.println("Time to burn the tree: " + result);
    }
}

