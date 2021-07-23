package leetcode.difficult;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/22
 * @description ：[4,9,4,5,3,2]
 * @version: 1.0
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = {4,9,4,5,3,2};
        System.out.println(trap(height));

    }

    public static int trap(int[] height) {
        if (height.length<=2){
            return 0;
        }

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[max]) {
                max = i;
            }
        }
        int sum = 0;
        int l = 0;
        int r = max;

        while (height[r] > 0) {
            for (int i = 0; i < r; i++) {
                if (height[i] > height[l]) {
                    l = i;
                }
            }
            if (height[l] == 0) {
                break;
            }
            for (int i = l + 1; i < r; i++) {
                sum = sum + height[l] - height[i];
            }
            if (l == 0) {
                break;
            }
            r = l;
            l=0;
        }

        int l1 = max;
        int r1 = height.length - 1;

        while (height[l1] > 0) {
            for (int i = l1 + 1; i < height.length - 1; i++) {
                if (height[i] > height[r1]) {
                    r1 = i;
                }
            }
            if (height[r1] == 0) {
                break;
            }

            for (int i = l1 + 1; i < r1; i++) {
                sum = sum + height[r1] - height[i];
            }
            if (r1 == height.length - 1) {
                break;
            }
            l1=r1;
            r1 = height.length - 1;
        }

        return sum;


    }
}
