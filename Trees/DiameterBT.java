package Trees;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    static int diameter;

    public static int dfs(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int left = dfs(head.left);
        int right = dfs(head.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }
}

public class DiameterBT{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Construct the binary tree
        TreeNode root = constructBinaryTree(scanner);

        // Calculate the diameter of the binary tree
        Solution solution = new Solution();
        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter);

        scanner.close();
    }

    private static TreeNode constructBinaryTree(Scanner scanner) {
        System.out.println("Enter the value of the root node:");
        int rootValue = scanner.nextInt();
        TreeNode root = new TreeNode(rootValue);

        System.out.println("Enter the value of the left child of the root node (enter -1 if no left child):");
        int leftValue = scanner.nextInt();
        if (leftValue != -1) {
            root.left = constructBinaryTree(scanner);
        }

        System.out.println("Enter the value of the right child of the root node (enter -1 if no right child):");
        int rightValue = scanner.nextInt();
        if (rightValue != -1) {
            root.right = constructBinaryTree(scanner);
        }

        return root;
    }
}

