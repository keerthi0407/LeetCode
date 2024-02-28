import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

class bottomLeftValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values of the binary tree nodes (separated by spaces):");
        String[] values = scanner.nextLine().split(" ");
        TreeNode root = constructBinaryTree(values);
        bottomLeftValue solution = new bottomLeftValue();
        int bottomLeftValue = solution.findBottomLeftValue(root);
        System.out.println("The value of the bottom-left node is: " + bottomLeftValue);
        scanner.close();
    }
    
    public static TreeNode constructBinaryTree(String[] values) {
        if (values == null || values.length == 0 || values[0].equals("null")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (!values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public int findBottomLeftValue(TreeNode root) {
        left = 0;
        leftrow = -1;
        traversal(root, 0);
        return left;
    }

    static int left = 0;
    static int leftrow = -1;

    static void traversal(TreeNode root, int depth) {
        if (root == null) return;
        if (leftrow < depth) {
            left = root.val;
            leftrow = depth;
        }
        traversal(root.left, depth + 1);
        traversal(root.right, depth + 1);
    }
}
