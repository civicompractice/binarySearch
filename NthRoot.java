
//Time Complexity : O(N*log2(M*10))
// Problem Statement: Given two numbers N and M, find the Nth root of M.

// The nth root of a number M is defined as a number X when raised to the power N equals M.

// Example 1:

// Input: N=3 M=27

// Output: 3

// Explanation: The cube root of 27 is 3.
// Example 2:

// Input: N=2 M=16

// Output: 4

// Explanation: The square root of 16 is 4
// Example 3:

// Input: N=5 M=243

// Output: 3

// Explaination: The 5th root of 243 is 3

import java.util.*;

class NthRoot {

    public static double multiply(double num, int n) {
        double ans = 1.0;
        for(int i = 1; i <= n; i++) 
            ans = ans*num;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        double low = 1;
        double high = m;

        while(high-low > 0.000001) {
            double mid = (low+high)/2.0;
            if(multiply(mid,n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println(low + " " + high);
        System.out.println(Math.pow(m,(double)(1.0/(double)m)));
    }
}
