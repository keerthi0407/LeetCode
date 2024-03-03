import java.util.Scanner;

public class removeKthfromLast {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int totalNodes(ListNode head){
        if(head==null ) return 0;
        if(head.next==null) return 1;
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //find how many nodes
        if(head.next==null) {
            head=null;
            return head;
        }
        int nodes=totalNodes(head);
        int remove=nodes-n-1;
        if(remove==-1) return head.next;
        ListNode temp=head;
        int c=0;
        while(c!=remove && temp!=null){
            temp=temp.next;
            c++;
        }
        temp.next=temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the list: ");
        int n = scanner.nextInt();
        System.out.println("Enter the values of the nodes in the list: ");
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }
        System.out.println("Enter the index of the node to be removed: ");
        int index = scanner.nextInt();
        ListNode newHead = removeNthFromEnd(head, index);
        System.out.println("Updated list: ");
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        scanner.close();
    }
}
