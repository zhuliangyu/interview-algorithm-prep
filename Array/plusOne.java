// https://www.jiuzhang.com/solution/plus-one/
// 输入：[1,2,3]
// 输出：[1,2,4]

// 输入：[9,9,9]
// 输出：[1,0,0,0]

public class Solution {
    // The complexity is O(1)
    // f(n) = 9/10 + 1/10 * O(n-1)
    //  ==>  O(n) =  10 / 9 = 1.1111 = O(1)
    
    public int[] plusOne(int[] digits) {
        // 题目要求 plus one
        int carries = 1;
        for(int i = digits.length-1; i>=0 && carries > 0; i--){  // fast break when carries equals zero
            // 划重点: 这里一个小技巧, 因为carry和plus 都是1, 所以刚开始进入的时候, 直接+1是因为题目要求plus one
            // 之后+1, 是因为进位
            int sum = digits[i] + carries;

            // 个位
            digits[i] = sum % 10;
            // 十位
            carries = sum / 10;
        }

        // 首位无进位, 直接返回
        // [1,2,3] -> [1,2,4]
        if(carries == 0)
            return digits;
            
        // 首位需要进位: [9,9,9] -> [1,0,0,0]这样的情况 
        // 数组扩一位
        int[] rst = new int[digits.length+1];
        
        // 首位需要进位
        // [1, null, null, null]
        rst[0] = 1;

        // 数组拷贝 
        // [0, 0, 0] -> [1, 0, 0, 0]
        for(int i=1; i< rst.length; i++){
            rst[i] = digits[i-1];
        }
        return rst;
    }
}