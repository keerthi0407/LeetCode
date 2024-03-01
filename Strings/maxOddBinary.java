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
