package month11;


/*
11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxArea1122 {

    /**
     * 解法1.暴力解法，依次计算所有的,每次取最大的
     * 解法2，夹逼法，每次从最外面向里面挪动，那个小挪动哪个
     */
    public int getMaxArea(int[] height) {
        int max = 0;
        //遍历数据
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length;j++) {
                int area = (j-i)* Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public int getMaxAreaTwo(int[] height) {

        int max = 0;
        for (int i =0, j= height.length-1; i <j;) {
            //哪个小哪个移动
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j-i+1) * minHeight;
            max = Math.max(max,area);
        }
        return max;
    }
}
