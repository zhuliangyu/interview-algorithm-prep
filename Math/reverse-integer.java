// https://leetcode-cn.com/problems/reverse-integer/
// leetcode 7

// https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/

1、将12345 % 10 得到5，之后将12345 / 10
2、将1234 % 10 得到4，再将1234 / 10
3、将123 % 10 得到3，再将123 / 10
4、将12 % 10 得到2，再将12 / 10
5、将1 % 10 得到1，再将1 / 10

class Solution {
    public int reverse(int x) {
        int res = 0;

        // 注意: 结束条件
        while(x != 0) {
            //每次取末尾数字
            int tmp = x % 10;

            res = res*10 + tmp;

            // 每次都除以10
            x /= 10;
        }
        return res;
    }
}		



class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }
}		
