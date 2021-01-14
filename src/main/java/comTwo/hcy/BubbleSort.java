package comTwo.hcy;

import java.util.Arrays;

/**
 * @author ：hcy
 * @date ：Created in 2020/8/20
 * @description ：
 * @version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,3,5,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }

            }
            if (!flag){
                break;
            }else {
                flag=false;
            }
        }
    }

}
