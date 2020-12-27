package month12;

public class findMin1220 {

    /**
     * 剑指offer面试题8--查找旋转后的最小的元素
     */
    public  static  int findMin(int[] num) {
        int min = 0;
        int max = num.length-1;
        int mid = 0;
       while(num[min] >= num[max]) {
           if (max- mid <=1) {
               mid = max;
               return num[mid];
           }
           mid = (max + min)/2;
           if (num[mid] > num[min]) {
               min = mid;
               break;
           } else {
               max = mid;
               break;
           }
       }
        return num[mid];
    }

    public static void main(String[] args) {
//        int[] num = {3, 4, 5, 1, 2};

        int[] num = { 1, 0, 1, 1, 1 };
        int min1 = GetMin(num);
        System.out.println(min1);
    }


    //没有考虑重复数据
    public static int GetMin(int[] num){
       int min = 0;
       int max = num.length - 1;
       int mid = min;
       while (num[min] >= num[max]) {
           // 如果index1和index2指向相邻的两个数，
           // 则index1指向第一个递增子数组的最后一个数字，
           // index2指向第二个子数组的第一个数字，也就是数组中的最小数字
           if (max - min == 1) {
                mid = max;
                break;
           }

           mid = (min + max)/2;


           // 特殊情况：如果下标为min、mid和max指向的三个数字相等，则只能顺序查找
           if (num[min] == num[mid] && num[min] == num[max])
           {
               return GetMinInOrder(num, min, max);
           }
           if (num[mid] >= num[min]) {
               min = mid;
           } else if (num[mid] <= num[max]) {
               max = mid;
           }
       }

       return num[mid];
    }

    private static int GetMinInOrder(int[] num, int min, int max) {
        int res = num[min];
        for (int i = min + 1; i <= max; i++) {
            if (res > num[i]) {
                res = num[i];
            }
        }
        return res;

    }

}
