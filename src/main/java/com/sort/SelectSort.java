package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author ：hcy
 * @date ：Created in 2020/8/13
 * @description ：
 * @version: 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        System.out.println("排序前的时间=" + s);

        selectSort(arr);

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间=" + s2);
//        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i <arr.length-1 ; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = 1+i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i!=minIndex){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第"+(i+1)+"轮后");
//            System.out.println(Arrays.toString(arr));

        }


    }
}
