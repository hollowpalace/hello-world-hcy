package leetcode.low;

import java.util.HashMap;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/13
 * @description ：[1,3,5,6]
 * 5
 * @version: 1.0
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target = 5;
        System.out.println(searchInsert2(nums,target));
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
        }
        if (nums.length >= 1) {
            return nums.length - 1;
        } else {
            return 0;
        }


    }

    public static int searchInsert2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = (l + r) / 2;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (nums[mid]>target){
            return mid;
        }else if(nums[mid]<target){
            return mid+1;
        }

        if (nums.length >= 1) {
            return nums.length - 1;
        } else {
            return 0;
        }
    }
}
