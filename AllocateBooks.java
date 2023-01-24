// Time Complexity : O(N*log(n))

import java.util.*;

class AllocateBooks {

    public static boolean isPossible(int num, int[] arr, int std) {
        int allocated = 1, pages = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > num) return false;
            if(pages+arr[i] > num) {
                allocated += 1;
                pages += arr[i];
            } else {
                pages += arr[i];
            }
        }
        if(allocated > std)
            return false;
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {12,34,67,90};
        int std = 2;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++)
            min = Math.min(min, arr[i]);
        
        int max = 0;
        for(int i = 0; i < arr.length; i++)
            max += arr[i];
        
        int low = min;
        int high = max;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)>>1;
            if(isPossible(mid, arr, std)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        System.out.println(ans);
    }
}