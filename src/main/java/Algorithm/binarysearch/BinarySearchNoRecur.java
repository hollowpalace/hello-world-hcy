package Algorithm.binarysearch;

/**
 * @author ：hcy
 * @date ：Created in 2020/12/8
 * @description ：
 * @version: 1.0
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,11,67,100};
        int index = binarySearch(arr,28);
        System.out.println(index);

    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
