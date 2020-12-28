package month12;


/**
 * 剑指offer第11题
 */
public class Power1227 {

    /**
     *考察对异常情况的判断,分析各种异常情况
     * 对于0的逻辑判断
     */


    public static double power(double base, int exp) throws Exception {
        double result = 0.0;

        if (equal(base, 0.0) && exp < 0) {
            throw new Exception("0的负数次幂没有意义");
        }

        if (exp <0) {
            result = 1.0/powerWithExp(base, -exp);
        } else {
            result = powerWithExp(base, exp);
        }

        return result;
    }

    private static double powerWithExp(double base, int i) {
        if (i == 0) {
            return 1;
        }

        if (i == 1) {
            return base;
        }

        double result = 1.0;
        for (int j = 0; j < i; j++) {
            result = result*base;
        }

        return result;
    }

    private static boolean equal(double base, double v) {
        if (base - v > -0.000001  && base - v < -0.000001) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        double power = power(2, 3);
        double power1 = power(-2, 1);
        double power2 = power(0, 3);
        double power3 = power(2, 3);

        System.out.println(power+ "===" + power1 + "===" + power2 +"===" + power3);

    }

}
