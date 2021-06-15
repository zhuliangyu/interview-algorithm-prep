// https://leetcode-cn.com/problems/max-points-on-a-line/
// leetcode 149


// 解题思路: https://leetcode-cn.com/problems/max-points-on-a-line/solution/javamei-ju-fa-si-lu-jian-dan-by-vigilant-5iu4/
public class Solution {
    // 思路：枚举所有点(外循环)，在必定经过的直线中抓出穿过最多点的直线必然是正确答案
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }  
        
        // 用哈希表来存，<斜率，穿过的点数>
        HashMap<Double, Integer> map=new HashMap<Double, Integer>();
        
        int max = 1;

        // AB两个在数组中的无重复的组合
        // 枚举法: 两重for循环, 外循环, 内循环
        // 外遍历所有的点
        for(int i = 0 ; i < points.length; i++) {
            // shared point changed, map should be cleared and server the new point
            map.clear();

            // maybe all points contained in the list are same points,and same points' k is 
            // represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);

            int dup = 0;

            // 内循环, 遍历的点, 是从i之后开始的!!! 这是求不同组合的技巧
            // 这样避免了 [1, 2]和[2, 1]只会出现一次
            for(int j = i + 1; j < points.length; j++) {

                // 完全相同的点, 根本不用去求斜率
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem

                // if the line through two points are parallel to y coordinator, then K(slop) is 
                // Integer.MAX_VALUE
                double key = points[j].x - points[i].x == 0 ? 
                    Integer.MAX_VALUE :
                    0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if (map.containsKey(key)) {
                    // 为什么这里只是 + 1? 
                    // 因为前面2个点都被加了, 现在多一个点, 只要多 + 1个点, 即可
                    map.put(key, map.get(key) + 1);
                } else {
                    // 初始化, 为什么是2? 不是1
                    // 一个斜率肯定有两个点穿过, 不是1个点!
                    map.put(key, 2);
                }
            }


            // 定住一个外循环, 在所有的内循环中, 求最多数量的斜率
            for (int temp: map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }

        }
        return max;
    }
}