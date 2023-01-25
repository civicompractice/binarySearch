
//finding out largest min distance
//Time Complexity O(N*log(n))

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