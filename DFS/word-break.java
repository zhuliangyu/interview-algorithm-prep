// https://leetcode-cn.com/problems/word-break/
// leetcode 139

// DFS 回溯
// 时间复杂度：O(2^n)
// 空间复杂度：O(N)，递归深度最深为N层
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        return dfs(s, dict, 0); 
    }
    
    /**
     * 递归的定义
     * 判断字符串s[start: ]能否通过wordDict中的单词组成
    **/
    public boolean dfs(String s, Set<String> dict, int startIndex) {
        // 递归的出口
        // 如果起始点已经在字符串的尾部, 停止，返回可以组成该字符串
        // startIndex = 起始点
        if (startIndex == s.length()) {
            return true;
        }
        
        // 以下还未到结尾

        // 递归的拆解，枚举下一个字符串的长度len
        // 递归每一种可能性
        // 递归图解: https://leetcode-cn.com/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
        for (int len = 1; startIndex + len <= s.length(); len++) {
            // 判断s[startIndex: startIndex + len]是否满足条件
            // 递归的步进是 startIndex + len
            if (dict.contains(s.substring(startIndex, startIndex + len)) // 对于每种可能，判断该字符串是否在字典中
                && dfs(s, dict, startIndex + len)                 // 如果在字典中：判断剩下的字符串也在字段中 (递归)
                ) {
                return true;
                // 思考, 这里为什么没有撤销的行为? 
                // 因为你只是判断true or false, 没有做任何的修改, 自然不用撤销
            }
        }
        return false;
    }
}

// 思考: 有哪些重复操作?

// 记忆化 DFS
// 时间复杂度：O(N)
// 空间复杂度：O(N)
// https://www.jiuzhang.com/solution/word-break/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {

        // The default value for a Boolean (object) is null . 
        // The default value for a boolean (primitive) is false .
        HashMap<String, Boolean> memo = new HashMap<String, Boolean> ();
        
        return dfs(s, dict, 0, memo); 
    }
    
    /**
     * 递归的定义
     * 判断字符串s[start: ]能否通过wordDict中的单词组成
    **/
    public boolean dfs(String s, Set<String> dict, int now, HashMap<String, Boolean> memo) {
        // 递归的出口
        if (now == s.length()) {
            return true;
        }

        // 递归前先查memo
        if (memo.containsKey(s.substring(now))) {
            return memo.get(s.substring(now));
        }
        
        // 递归的拆解，枚举下一个字符串的长度
        for (int len = 1; now + len <= s.length(); len++) {
            // 判断s[now: now + len]是否满足条件
            if (dict.contains(s.substring(now, now + len)) && dfs(s, dict, now + len, memo)) {
                return true;
            }
        }

        // 记录memo
        memo.put(s.substring(now), false);
        // 为什么不用记录true, 因为true就是结果了, 你只要记录曾经做过错的, 不再踩坑就行

        return false;
    }
}