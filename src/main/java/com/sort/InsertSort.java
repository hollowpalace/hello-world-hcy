package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author ：hcy
 * @date ：Created in 2020/8/14
 * @description ：
 * @version: 1.0
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] arr = new int[120000];
        for (int i = 0; i < 120000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        System.out.println("排序前的时间=" + s);


        inserSort(arr);
        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间=" + s2);

//        int[] arr = {101, 34, 119, 62,985};
//        inserSort(arr);
//        System.out.println(Arrays.toString(arr));

    }

    public static void inserSort(int[] arr) {
        for (int i = 1; i <arr.length ; i++) {
            int insertVal = arr[i];
            int inserIndex = i-1;
            while (inserIndex >= 0 && insertVal < arr[inserIndex]) {
                arr[inserIndex+1]=arr[inserIndex];
                inserIndex--;
            }
            if (inserIndex+1!=i){
                arr[inserIndex+1]=insertVal;
            }

        }

    }
}
