package month06;


import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author 米兜,今日头条
 * @description Java中不使用HashMap怎么实现统计字符串中每个字符出现的次数？
 * @date 2020/6/26 22:23
 * @modified by
 */
public class CountString {

    public static void main(String[] args) {
        String str = "guanzhuchengxuyuanmidou";

        System.out.println("-----------1.数组的索引法【start】-----------");
        count1(str);
        System.out.println("-----------1.数组的索引法【end】-----------");

        System.out.println("---------------------------------------------");

        System.out.println("-----------2.使用流（使用TreeMap）【start】-----------");
        count2(str);
        System.out.println("-----------2.使用流（使用TreeMap）【end】-----------");

        System.out.println("---------------------------------------------");

        System.out.println("-----------3.巧用split【start】-----------");
        count3(str);
        System.out.println("-----------3.巧用split【end】-----------");

        System.out.println("---------------------------------------------");

        System.out.println("-----------4.巧用Pattern【start】-----------");
        count4(str);
        System.out.println("-----------4.巧用Pattern【end】-----------");
    }

    private static void count4(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            int count = 0;
            Matcher m = Pattern.compile(String.valueOf(c)).matcher(str);
            if (arrayList.contains(String.valueOf(c))) {
                continue;
            }

            while (m.find()) {
                count++;
            }
            System.out.println("字符：" + String.valueOf(c) + "====" + "个数" + count);
            arrayList.add(String.valueOf(c));
        }
    }

    /**
     * @author 米兜
     * @param
     * @description 3.巧用split
     * @date 2020/6/26 22:51
     */
    private static void count3(String str) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (char c : str.toCharArray()) {
            String[] split = str.split(String.valueOf(c));
            int a = split.length;
            int count=str.split(String.valueOf(c)).length - 1;
            //最后一个字符串split要+1
            if (str.substring(str.length()-1, str.length()).equals(String.valueOf(c))) {
                count++;
            }

            if (arrayList.contains(String.valueOf(c))){
                continue;
            }
            System.out.println("字符：" + String.valueOf(c) + "====" + "个数" +count);
            arrayList.add(String.valueOf(c));
        }
    }

    private static void count2(String str) {
        TreeMap<String, Long> result = Arrays.stream(str.split("")).sorted()
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        Iterator<Map.Entry<String, Long>> iterator = result.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Long> next = iterator.next();
            System.out.println("字符：" + next.getKey() + "===个数" + next.getValue());
        }
    }

    private static void count1(String str) {
        //利用字符串的asci码，用一个数组存储各自的asci码
        //创建26个空间大小的数组，存放26个字母
        int[] nums = new int[26];
        for (char i: str.toCharArray()) {
            if (i>= 97 && i <=122) {
                //利用数组的索引进行存储
                nums[i-97]++;
            }
        }

        for (int i=0; i< nums.length; i++) {
            if (nums[i] != 0) {
                char j = (char)(i+97);
                System.out.println("字符：" + j + "====" + "个数" + nums[i]);
            }
        }
    }
}
