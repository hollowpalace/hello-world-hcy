package com.search;

/**
 * @author ：hcy
 * @date ：Created in 2020/8/21
 * @description ：
 * @version: 1.0
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {3,5,1,2};
        int value = 1;
        int i = seqSearch(arr, value);
        System.out.println(i);
    }

    public static int seqSearch(int[] arr,int value){
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }

}
