package LeetCode;

/**
 * Created by aiya on 2019/8/19 上午11:46
 */
public class test {
    public static void main(String[] args) {
        String str = "2014.07.09-长期";
        String intf[] = str.split("-");
        String lepValidStart = intf[0].substring(0, 4) + "-" + intf[0].substring(5, 7) + "-" + intf[0].substring(8, 10);
        System.out.println(lepValidStart);
    }
}
