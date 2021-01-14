package com.search;

/**
 * @author ：hcy
 * @date ：Created in 2020/8/21
 * @description ：
 * @version: 1.0
 */
public class MidFenSearch {
    public static void main(String[] args) {
        int[] arr = {0, 12, 35, 49, 128, 139};
        int value = 139;
        int method = method(arr, value);
        System.out.println(method);
    }

    public static int method(int[] arr, int value) {


        int left = 0;
        int right = arr.length;


        while (right >= left) {
            int mid = (left + right) / 2;
            if (value > arr[mid]) {
                left = mid + 1;

            } else if (value < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
