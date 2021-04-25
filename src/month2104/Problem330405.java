package month2104;


/**
 * 题目：面试题 33：把数组排成最小的数
 * 问题：1、拼接后可能出现超过int的长度，大数问题
 * 2、int类型不好比较大小，转为string
 */

public class Problem330405 {

    public static void main(String[] args) {
        Problem330405 test = new Problem330405();
        int[] array = {3, 32, 321};
        test.printMin(array);
    }

    private void printMin(int[] array) {
        //获取元素转换为字符串
        int[] clone = array.clone();
        printMinNumber(clone, 0, clone.length - 1);
        for (int i : clone)
            System.out.print(i);

        //比较字符串的值，从首位开始比较
    }

    private void printMinNumber(int[] array, int start, int end) {
        if (start < end) {
            int main_number = array[end];
            int small_cur = start;
            for (int j = start; j < end; j++) {
                if (isSmall(String.valueOf(array[j]), String.valueOf(main_number))) {
                    int temp = array[j];
                    array[j] = array[small_cur];
                    array[small_cur] = temp;
                    small_cur++;
                }
            }
            array[end] = array[small_cur];
            array[small_cur] = main_number;
            printMinNumber(array, 0, small_cur - 1);
            printMinNumber(array, small_cur + 1, end);
        }

    }

    //比较字符串的大小
    private boolean isSmall(String m, String n) {
        String left = m + n;
        String right = n + m;
        boolean result = false;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) < right.charAt(i))
                return true;
            else if (left.charAt(i) > right.charAt(i))
                return false;
        }
        return result;
    }
}


