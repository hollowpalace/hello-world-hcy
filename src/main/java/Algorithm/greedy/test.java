package Algorithm.greedy;

/**
 * @author ：hcy
 * @date ：Created in 2021/3/29
 * @description ：
 * @version: 1.0
 */
public class test {
    public static void main(String[] args) {
        String s1="50 21 10 2-2 * ?";
        String[] s = s1.split(" ");

        System.out.println("每月第" + s[3] + "天");


        String s2="59 06 17 ? * FRI,SAT";
        String[] split = s2.split(" ");

        for (String str :split){
            System.out.println(str);
        }
        String s3 = transferWeek(split);
        System.out.println(s3);
    }

    
    public static String transferWeek(String[] split) {
        String week = split[5];
        String[] weekEnglish = week.split(",");
        StringBuilder cn = new StringBuilder();
        int count = 0;
        for (String s : weekEnglish) {
            switch (s) {
                case "MON":
                    cn.append("每周一");
                    break;
                case "TUE":
                    cn.append("每周二");
                    break;
                case "WED":
                    cn.append("每周三");
                    break;
                case "THU":
                    cn.append("每周四");
                    break;
                case "FRI":
                    cn.append("每周五");
                    break;
                case "SAT":
                    cn.append("每周六");
                    break;
                case "SUN":
                    cn.append("每周日");
                    break;
                default:
                    cn.append("");
                    break;
            }
            count++;
            if (weekEnglish.length != count) {
                cn.append("、");
            }
        }
        return cn.toString();
    }

}
