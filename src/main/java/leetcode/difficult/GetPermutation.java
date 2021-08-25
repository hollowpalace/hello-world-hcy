package leetcode.difficult;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/19
 * @description ：
 * @version: 1.0
 */
public class GetPermutation {
    public static void main(String[] args) {
        String permutation = getPermutation(4, 9);
        System.out.println(permutation);
        System.out.println(1);
        print();

    }
    public static void print(){
        System.out.println("test");
    }

    public static String getPermutation(int n, int k) {
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i+1;
        }
        int[] res = method(ints, 1, k);
        StringBuilder stringBuilder = new StringBuilder();
        for (int re : res) {
            stringBuilder.append(re);
        }
        return stringBuilder.toString();


    }

    public static int[] method(int[] nums, int count, int k) {
        if (count == k) {
            return nums;
        }
        int[] ints = nextPermutation(nums);
        count++;
        int[] method = method(ints, count, k);
        return method;
    }

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


}
