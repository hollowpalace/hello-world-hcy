package Algorithm.dac;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @author ：hcy
 * @date ：Created in 2020/12/15
 * @description ：
 * @version: 1.0
 */
public class testDemo {
    public static void main(String[] args) {

////这里的数后面加“D”是表明它是Double类型，否则相除的话取整，无法正常使用
//        double percent = 50.5D / 150D;
//
////输出一下，确认你的小数无误
//        System.out.println("小数：" + percent);
//
////获取格式化对象
//        NumberFormat nt = NumberFormat.getPercentInstance();
//
////设置百分数精确度2即保留两位小数
//        nt.setMinimumFractionDigits(2);
//
////最后格式化并输出
//        System.out.println("百分数：" + nt.format(percent));

//        Integer a = 7;
//        Integer b = 3;
//        Double c = (double) a / b;
//        System.out.println(c);
        method();

    }

    public static void metgod() {
        Object o = "5.4%";
        NumberFormat nf = NumberFormat.getPercentInstance();
        Number m = null;
        try {
            m = nf.parse((String) o);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer total = 56;
        double v = total * m.doubleValue();
        Integer fi = (int) Math.round(v);
        System.out.println(fi);
    }

    public static void method() {
        double d = 114.145;
        BigDecimal b = new BigDecimal(d);
        d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);
    }
}
