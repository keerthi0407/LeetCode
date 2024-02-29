import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class isEvenOdd {
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                
                if((level % 2 == 0 && (cur.val % 2 == 0 || (i > 0 && cur.val <= list.get(i - 1)))) ||
                   (level % 2 == 1 && (cur.val % 2 == 1 || (i > 0 && cur.val >= list.get(i - 1)))))
                    return false;
                
                list.add(cur.val); 
                
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right); 
            }
            
            // Increment level within the while loop
            level++;
        }
        
        return true;
    }
    
    // Function to construct a binary tree from user input
    public static TreeNode constructTree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of root node:");
        int val = scanner.nextInt();
        TreeNode root = new TreeNode(val);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println("Enter the left child value of " + current.val + " (or -1 if none):");
            int leftVal = scanner.nextInt();
            if (leftVal != -1) {
                current.left = new TreeNode(leftVal);
                queue.offer(current.left);
            }
            System.out.println("Enter the right child value of " + current.val + " (or -1 if none):");
            int rightVal = scanner.nextInt();
            if (rightVal != -1) {
                current.right = new TreeNode(rightVal);
                queue.offer(current.right);
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = constructTree();
        isEvenOdd solution = new isEvenOdd();
        boolean result = solution.isEvenOddTree(root);
        System.out.println("Is the tree an Even-Odd tree? " + result);
    }
}

