import java.util.Scanner;
class Solution {
    public static int rangeBitwiseAnd(int left, int right) {
        int count=0;
        //1 & 1 =1 for and operator the result will give 1 if both are same 
        //by using left operator we can find how many bits are same in left,right
        //by right shift of same bits with number of different bits will give resultant solution
        while(left!=right){
            left>>=1;
            right>>=1;
            count++;
        }
        return left<<count;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int left=sc.nextInt();
        int right=sc.nextInt();
        int result=rangeBitwiseAnd(left,right);
        System.out.println(result);
        sc.close();
    }
}