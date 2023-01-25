
//finding out largest min distance
//Time Complexity O(N*log(n))
// Problem Statement: There is a new barn with N stalls and C cows. 
// The stalls are located on a straight line at positions x1,….,xN (0 <= xi <= 1,000,000,000). 
//     We want to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. 
//     What is the largest minimum distance?

// Examples:

// Input: No of stalls = 5 
//        Array: {1,2,8,4,9}
//        And number of cows: 3

// Output: One integer, the largest minimum distance 3

class Cows {
    public static boolean isPossible(int[] location, int cows, int dist) {
        int co = location[0], cnt = 1;
        for(int i = 1; i < location.length; i++) {
            if(location[i]-co >= dist) {
                cnt++;
                co = location[i];
            }
            if(cnt == cows)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] location = {1,2,4,8,9};
        int cows = 3;

        int high = 0;
        for(int i = 0; i < location.length; i++)
            high = Math.max(high, location[i]);
        high -= 1;
        int low = 1;
        int ans = 0;
        while(low <= high) {
            int mid = (high+low)>>1;
            if(isPossible(location, cows, mid)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        System.out.println(ans);
    }
}
