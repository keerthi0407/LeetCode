/*
    PROBLEM STATEMENT:
    You are given a binary string s that contains at least one '1'.
You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.
Return a string representing the maximum odd binary number that can be created from the given combination.

Note that the resulting string can have leading zeros.
Example 1:

Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".
*/
import java.util.Scanner;

public class maxOddBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String s = scanner.nextLine();
        scanner.close();

        System.out.println("Maximum odd binary number: " + maximumOddBinaryNumber(s));
    }

    public static String maximumOddBinaryNumber(String s) {
        int zero = 0, one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero++;
            else one++;
        }    
        StringBuilder res = new StringBuilder();
        res.append("1".repeat(one - 1));
        res.append("0".repeat(zero));
        res.append("1");
        return res.toString();
    }
}
/*n=length of the string
TC:
O(n)
SC:O(n) 
*/
TC:
