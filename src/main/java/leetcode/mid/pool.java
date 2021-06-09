package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/7
 * @description ：[1,3,2,5,25,24,5]
[1,8,6,2,5,4,8,3,7]
 *
 * @version: 1.0
 */
public class pool {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));

    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = (right - left) * Math.min(height[left], height[right]);
        while (right > left) {

            if (height[left ] < height[right]) {
                left++;
            } else if (height[right ] < height[left]) {
                right--;
            } else {
                left++;
            }

            if ((right - left) * Math.min(height[left], height[right]) > result) {
                result = (right - left) * Math.min(height[left], height[right]);
            }
        }
        return result;

    }
}
