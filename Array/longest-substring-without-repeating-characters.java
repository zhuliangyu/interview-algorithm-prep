// leetcode 3
// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/

class Solution {
    // 图解：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/

    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int ans = 0;
        
        // key 找unique
        // 比如 aaabb, 同一个字母会出现不同的位置, 所以一个key对应多个value, 我们只要保存最新的一个value即可 (a, 0)
        // 关键点: value = end + 1;
        Map<Character, Integer> map = new HashMap<>();

        // 滑动窗口, 双指针, 一个start指针, 一个end指针
        int start = 0;
        for (int curr = 0; curr < n; curr++) {

            char currChar = s.charAt(curr);
            
            if (map.containsKey(currChar)) {
                // 只有发现重复了, start才重头开始计算
                start = Math.max(map.get(currChar), start);
            }
            // 小本每次记录curr的字符, 走一格记录一次
            // 无论见过没见过, 见过了直接覆盖value
            // 为什么要 end + 1???, 因为下次直接直接用做start
            map.put(s.charAt(curr), curr + 1);

            // 此次循环的unique的长度
            int thisRoundLength = curr - start + 1;
            // 和历史组好记录打擂台
            ans = Math.max(ans, thisRoundLength);

        }
        return ans;
    }
}

