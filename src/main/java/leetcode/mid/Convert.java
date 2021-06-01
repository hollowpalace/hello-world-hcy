package leetcode.mid;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/1
 * @description ：
 * @version: 1.0
 */
public class Convert {
    public static void main(String[] args) {
        String s = "ABCD";
        int numRows = 2;
        String array = convert(s, numRows);
        System.out.println(array);
    }


    public static String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }

        int len = 2 * numRows - 2;
        int j = s.length() / len;
        int i = s.length() % len;
        int line = 0;
        if (i == 0) {
            line = j * (numRows - 1);
        } else if (i <= numRows) {
            line = j * (numRows - 1) + 1;
        } else if (i > numRows && i < len) {
            line = j * (numRows - 1) + 1 + i - numRows;
        }

        String[][] array = new String[numRows][line];
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < line; l++) {
                array[k][l] = "*";
            }
        }

        int sringLen = 0;
        for (int k = 0; k < s.length(); k++) {
            sringLen = k + 1;
            if (sringLen % len == 0) {
                int n = len - numRows;

                array[numRows-n-1][(sringLen / len) * (numRows - 1) - 1] = s.charAt(k) + "";
            } else if (sringLen % len <= numRows) {
                array[k % len][(sringLen / len) * (numRows - 1)] = s.charAt(k) + "";
            } else if (sringLen % len > numRows) {
                int m = sringLen % len - numRows;
                array[numRows - m - 1][(sringLen / len) * (numRows - 1) + m] = s.charAt(k) + "";
            }

        }


        StringBuffer stringBuffer = new StringBuffer();
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < line; l++) {
                if (!array[k][l].equals("*")) {
                    stringBuffer.append(array[k][l]);
                }
            }
        }
        return stringBuffer.toString();
    }
}
