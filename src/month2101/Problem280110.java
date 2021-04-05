package month2101;

import java.util.ArrayList;
import java.util.Collections;

public class Problem280110 {
    /**
     * lettcode第28题，输出abc的所有排序
     * 解题思路：问题化简，将第一个字符和后面的字符看成两个字符，
     * a-----bc,然后后面在将bc看出另外一个字符---bc：b----c；依次完成每次的求解
     */


    /**
     * 没有写出来程序
     * 解题思路】
     *
     * 把字符串分为两部分：一部分是字符串的第一个字符，另一部分是第一个字符以后的所有字符。
     *
     * 第一步是求所有可能出现在第一个位置的字符，即把第一个字符和后面所有字符交换。（for循环、交换操作）
     * 第二步是固定住第一个字符，求后面所有字符的排列。（递归）
     * 而“求后面所有字符的排列”即可按照上面的思路递归进行。
     * 实现借助一个char[]，通过交换元素得到不同的排列，在递归返回时将其装入ArrayList。
     *
     * 如下图所示，有两点需要注意：
     *
     * 在每个分支进行完后，要将交换过的元素复位，从而不会影响其他分支。
     * 因为有“Swap A with A”这样的操作，并且题目指出可能有字符重复，所以分支末尾可能有重复的序列，在加入ArrayList要进行去重判断，不重复再加入。
     * https://blog.csdn.net/darlingwood2013/article/details/90243937
     */

    // 132ms 1186K
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.length() == 0)
            return list;
        char[] strArr = str.toCharArray();
        permu(list, strArr, 0);
        Collections.sort(list);
        return list;
    }

    private void permu(ArrayList<String> list, char[] strArr, int start) {
        // 递归终止条件
        if(start == strArr.length-1){
            String result = String.valueOf(strArr);
            // indexOf() 返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1。
            // 因为可能有字符重复，所以要做此判断
            if(list.indexOf(result) < 0){
                list.add(result);
            }
        }

        for(int i = start; i < strArr.length; i++) {
            char temp = strArr[start];
            strArr[start] = strArr[i];
            strArr[i] = temp;
            System.out.println(temp + "---" + ",i是" + i+ ":"+strArr[i] + ",start是" + strArr[start]);
            System.out.println("===========");

            permu(list, strArr, start+1);

            temp = strArr[start];
            strArr[start] = strArr[i];
            strArr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Problem280110 problem280110 = new Problem280110();
        ArrayList<String> abcd = problem280110.Permutation("abc");
        System.out.println(abcd);

    }
}
