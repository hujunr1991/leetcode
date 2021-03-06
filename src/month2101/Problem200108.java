package month2101;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem200108 {

    /**
     * 顺势打印矩阵
     *
     * 得到列>start*2和行>start*2很关键
     *
     */


    public static ArrayList<Integer> printMatrixClockwisely(int [][]nums){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int rows = nums.length;
        int cols = nums[0].length;
        if(nums == null || cols <= 0 || rows <= 0){
            return null;
        }
        int start = 0;
        while(cols > start*2 && rows > start*2){
            printMatrixInCircle(list, nums, cols, rows, start);
            ++start;
        }
        return list;
    }

    private static void printMatrixInCircle(ArrayList<Integer> list, int[][] nums,
                                     int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; ++i) {
            int number = nums[start][i];
            list.add(number);
        }
        //从上到下打印一列
        if(start < endY){
            for (int i = start + 1; i <= endY; ++i) {
                int number = nums[i][endX];
                list.add(number);
            }
        }
        //从右向左打印一行
        if(start < endX && start < endY){
            for (int i = endX-1; i >= start; --i) {
                int number = nums[endY][i];
                list.add(number);
            }
        }
        //从下向上打印一列
        if(start < endX && start < endY - 1){
            for (int i = endY-1; i >= start + 1; --i) {
                int number = nums[i][start];
                list.add(number);
            }
        }
    }

    public static void main(String[] args) {
        int[][] array={
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        ArrayList<Integer> integers = printMatrixClockwisely(array);

        System.out.println(Arrays.toString(integers.toArray()));
    }
}
