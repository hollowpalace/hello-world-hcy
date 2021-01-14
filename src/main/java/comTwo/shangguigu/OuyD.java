package comTwo.shangguigu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ：hcy
 * @date ：Created in 2020/7/15
 * @description ：
 * @version: 1.0
 */
public class OuyD {
    public static void main(String[] args) throws IOException {
        int count2=0;
        BufferedReader br = new BufferedReader(new FileReader("out.txt"));
        // 定义字符串,保存读取的一行文字
        String line  = null;
        // 循环读取,读取到最后返回null
        while ((line = br.readLine())!=null) {
            System.out.print(line);
            System.out.println();
            count2++;
            String[] split = line.split(".");
//            System.out.println(split);
        }
        // 释放资源
        br.close();
    }
}
