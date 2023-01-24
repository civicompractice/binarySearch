
//Time Complexity : O(N*log2(M*10))



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