import java.util.LinkedList;
import java.util.Scanner;
public class mergeSortDll {
    static Node head;
    static class Node{
        int data;
        Node next,prev;
        Node (int data){
            this.data=data;
            next=prev=null;
        }
    }
    static Node split(Node head){
        Node fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node secondhalf=slow.next;
        slow.next=null;
        return secondhalf;
    }
    static Node merge(Node fir,Node sec){
        if(fir==null) return sec;
        if(sec==null) return fir;
        if(fir.data<=sec.data){
            fir.next=merge(fir.next,sec);
            fir.next.prev=fir;
            fir.prev=null;
            return fir;
        }
        else{
            sec.next=merge(fir,sec.next);
            sec.next.prev=sec;
            sec.prev=null;
            return sec;
        }
    }
    //Function to sort the given doubly linked list using Merge Sort.
    Node sortDoubly(Node head)
    {
        // add your code here
        if(head==null || head.next==null){
            return head;
        }
        Node second=split(head);
        //recurrensively sorting left and right half
        head=sortDoubly(head);
        second=sortDoubly(second);
        
        return merge(head,second);
        
    }
    void print(Node node) {
        Node temp = node;
        System.out.println("Forward Traversal using next pointer");
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println("\nBackward Traversal using prev pointer");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }
    public static void main(String args[]){
        Scanner scanner=new Scanner (System.in);
        mergeSortDll  list = new mergeSortDll ();
        head = null;

        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }
        }

        Node node = list.sortDoubly(head);
        System.out.println("Linked list after sorting:");
        list.print(node);
        
        scanner.close();

    }
    
}
