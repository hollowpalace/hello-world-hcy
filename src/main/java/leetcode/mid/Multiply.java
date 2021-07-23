package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/23
 * @description ：
 * @version: 1.0
 */
public class Multiply {
    public static void main(String[] args) {

    }

    public String multiply(String num1, String num2) {


        Long s1 = 0L;
        Long s2 = 0L;
        for (int i = 0; i < num1.length(); i++) {
            s1 =  Integer.parseInt(num1.charAt(i)+"") * 10 + s1;
        }
        for (int i = 0; i < num2.length(); i++) {
            s2 = Integer.parseInt(num2.charAt(i)+"") + s2;
        }
        String s = String.valueOf(s1 * s2);







        return s;

    }
}
