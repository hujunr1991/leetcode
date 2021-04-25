package month2104;


/**
 * 丑数----34，判断为丑数，利用丑数的特征，分别是2.3.5的倍数
 */
public class Problem340405 {

    public static void main(String[] args) {

        Problem340405 p=new Problem340405();
        System.out.println(p.getUglyNumber(1500));
    }

    private int getUglyNumber(int n) {
        if (n < 0 ) {
            return 0;
        }

        int[] uglyArray=new int[n];
        uglyArray[0]=1;
        int multiply2=1;
        int multiply3=1;
        int multiply5=1;
        for(int i=1;i<uglyArray.length;i++){
            int min=min(multiply2*2,multiply3*3,multiply5*5);
            uglyArray[i]=min;
            while(multiply2*2<=min)
                multiply2++;
            while(multiply3*3<=min)
                multiply3++;
            while(multiply5*5<=min)
                multiply5++;
        }

        return uglyArray[n-1];
    }

    private int min(int i, int j, int k) {
        int min=(i<j)?i:j;
        return (min<k)?min:k;
    }

}
