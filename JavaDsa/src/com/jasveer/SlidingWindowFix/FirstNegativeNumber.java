package com.jasveer.SlidingWindowFix;
import java.util.*;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        int nums[] = {12, -1, -7, -8, -15, 30, 16, 28};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while (j < nums.length) {
            if ((j - i + 1) < k) {
                j++;
            }
            else if ((j - i + 1) == k) {
                boolean found = false;
                for (int s = i; s <= j; s++) {
                    if (nums[s] < 0) {
                        list.add(nums[s]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    list.add(0);  // No negative number in this window
                }
                i++;
                j++;
            }
        }

        // Convert list to array
        int[] arr = new int[list.size()];
        for (int l = 0; l < list.size(); l++) {
            arr[l] = list.get(l);
        }
        return arr;
    }
}
