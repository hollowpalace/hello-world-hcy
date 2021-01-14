package test;

/**
 * @author ：hcy
 * @date ：Created in 2020/9/24
 * @description ：
 * @version: 1.0
 */
public class code {
    public static void main(String[] args) {
        String s = "00101000";
        System.out.println((byte)Integer.parseInt(s,2));


        int temp = -10;
        int a;

//        temp |= 256;


        String string = Integer.toBinaryString(temp);
        System.out.println(string);
        System.out.println("///////////////////////");
        String s2 ="1111000000";
        int i = Integer.parseInt(s2,2);
        byte b = (byte) i;
        System.out.println(i);
        System.out.println(b);

        byte b2 = 127;
        String string1 = Integer.toBinaryString(b2);
        System.out.println(string1);
    }
}
