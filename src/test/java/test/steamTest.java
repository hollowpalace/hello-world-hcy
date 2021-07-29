package test;

import java.io.*;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/26
 * @description ：
 * @version: 1.0
 */
public class steamTest {
    public static void main(String[] args) throws IOException {
        File f = new File("test.txt");



        InputStreamReader inr = new InputStreamReader(new FileInputStream(f),"UTF-8");

        char[] buf = new char[1024];

        int len = inr.read(buf);
        System.out.println(new String(buf,0,len));

        inr.close();

    }
}
