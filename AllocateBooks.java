// Time Complexity : O(N*log(n))
// Problem Statement: Given an array of integers A of size N and an integer B.

// The College library has N bags, the ith book has A[i] number of pages.

// You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

// Conditions given :

// A book will be allocated to exactly one student.

// Each student has to be allocated at least one book.

// Allotment should be in contiguous order, for example, A student cannot be allocated book 1 and book 3, skipping book 2.

// Calculate and return the minimum possible number. Return -1 if a valid assignment is not possible.

// Examples:

// Example 1:

// Input: A = [12, 34, 67, 90]
//        B = 2

// Output: 113

// Explaination: Let’s see all possible cases of how books can be allocated for each student.

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
