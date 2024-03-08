/*You are given an array nums consisting of positive integers.
Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
The frequency of an element is the number of occurrences of that element in the array.

We can solve above question in many ways but I am done with use of data Structure and n array
1.Using HashMap (in comments ) this maintain an efficient way but requires an size of array 
2.using Array -this takes the size of maxnum in an array it is efficient if number of elements is higher than maxnum
 
*/ 

import java.util.Scanner;
import java.util.HashMap;
class maxFrequencyElements {
    public static int maxFrequencyElement(int[] nums) {
        /*HashMap<Integer,Integer>  map=new HashMap<>();
        int max=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            //max=Math.max(max,map.get(num));
        }
        int count=0;
        for(int val:map.values()){
            max=Math.max(max,val);
        }
        for(int val:map.values()){
            if(val==max){
                count+=val;
            }

        }
        return count;*/
        //finding the max element to get the array size
        int maxnum=0,count=0;
        for(int num:nums){
            if(maxnum<num)
                maxnum=num;
        }
        //creating array with size maxnum
        int[] arr=new int[maxnum+1];
        //storing frequency in array
        for(int num:nums){
            arr[num]++;
        }
        //finding maxfreq from array of frequencies
        int maxfreq=0;
        for(int num:arr){
            if(maxfreq<num)
                maxfreq=num;
        }
        //checking the same frequency elements
        for(int num:arr){
            if(maxfreq==num) count++;
        }
        return count*maxfreq;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int len=sc.nextInt();
        int[] nums=new int[len];
        System.out.println("Enter the values:");
        for(int i=0;i<len;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Count of maximum frequency elements is:"+maxFrequencyElement(nums));
        sc.close();

    }
}
/* 1.HashMap: 
        Time Complexity :O(n) -->  n: size of an array 
        Space Complexity:O(n)
    2.Array: 
        Time Complexity:O(n+maxnum)
        SpaceComplexity:O(maxnum)
    
    Comparing the two approaches, the HashMap approach has better time complexity (O(n) vs O(n + maxnum)), 
    while the array approach may have better space complexity in some cases, especially 
    if the range of elements in nums is small compared to the number of elements. 
    However, the array approach requires iterating through the entire array to find the maximum element, 
    which may be inefficient in some cases.
 */