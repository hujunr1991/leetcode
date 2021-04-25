package month2104;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * N皇后的问题
 */
public class Leecode010422 {


    private List<List<String>> solveNQueens(int n ) {
        char[][] chs=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chs[i][j]='.';
            }
        }
        List<List<String>> res=new ArrayList<>();
        backTracing(chs,0,n,res);
        return res;
    }

    private void backTracing(char[][] chs, int row, int n, List<List<String>> res) {
        //出发条件,每行都摆满皇后时，则产生了一种解法
        if (row == n) {
            res.add(chsToList(chs));
            return;
        }

        //一行一行地摆放，在确定一行中的那个皇后应该摆在哪一列时，需要当前列是否合法。
        //如果合法，则将皇后放置在当前位置，并进行递归，回溯。
        for(int col=0;col<chs[0].length;col++){
            if(isValid(chs,row,col)){
                chs[row][col]='Q';
                //递归
                backTracing(chs,row+1,n,res);
                //回溯
                chs[row][col]='.';
            }
        }
    }

    //判断合法：当前将要摆放'Q'的位置和其他已摆放‘Q’的位置不能在同一列，且不能在同一条45度斜线或135度斜线上。
    //这里判断是否在同一条斜线上可通过当前将要摆放'Q'的位置和其他已摆放‘Q’的位置横坐标之差和纵坐标之差的绝对值是否相等来判断。
    private boolean isValid(char[][] chs, int row, int col) {

        for (int i =0; i<= row; i++) {
            for (int j =0; j<chs[0].length; j++) {
                if(chs[i][j]=='Q'&&(j==col||Math.abs(row-i)==Math.abs(col-j))){
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> chsToList(char[][] chs){
        List<String> list=new ArrayList<>();
        for(int i=0;i<chs.length;i++){
            list.add(new String(chs[i]));
        }
        return list;
    }


    public static void main(String[] args) {
        Leecode010422 leecode010422 = new Leecode010422();
        List<List<String>> lists = leecode010422.solveNQueens(8);
        System.out.println(lists);
    }



}
