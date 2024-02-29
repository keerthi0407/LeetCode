/*A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.


Above are given conditions we are implementing code to solve if any violation with the given conditions.

Example 1:


Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
Output: true
Explanation: The node values on each level are:
Level 0: [1]
Level 1: [10,4]
Level 2: [3,7,9]
Level 3: [12,8,6,2]
Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all even and decreasing, the tree is Even-Odd.
 */

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
/* Time Cpmplexity: 
    1.for BFS it takes queue for traversing and its worst case time complexity is : O(n)
    2.for constructing the tree we use queue and it takes of time complexity :O(n) 
Space Complexity:
    1.Used Queue to store values and it takes complexity of O(n);
    2.ArrayList to store and compare the values of nodes , it takes complexity of O(n);
Over all TC:O(n); SC:O(n);

*/

