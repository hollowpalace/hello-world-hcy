package test;

import java.util.Arrays;

/**
 * @author ：hcy
 * @date ：Created in 2020/9/21
 * @description ：
 * @version: 1.0
 */
public class unicode {
    public static void main(String[] args)throws Exception{
//        byte[]  bytes = "你".getBytes("UTF-8");
//        byte[] bytes1 = "我".getBytes("UTF-8");
//        System.out.println(Arrays.toString(bytes));
//
//        byte[] gbks = "你".getBytes("GBK");
//        System.out.println(Arrays.toString(gbks));

        byte[] utf16 = "神".getBytes("UTF-16LE");
        System.out.println(Arrays.toString(utf16));

        byte[] utf16_2 = " ".getBytes("UTF-16LE");
        System.out.println(Arrays.toString(utf16_2));
    }
}
