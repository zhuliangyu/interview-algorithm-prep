// leetcode 49
// https://leetcode-cn.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // eat: ["ate","eat","tea"],
        // nat: ["nat","tan"],
        // bat: ["bat"]
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            char[] array = str.toCharArray();
            // 数组排序, 记住, 数组排序方法!!!!
            Arrays.sort(array);
            // 创建key
            String key = new String(array);
            
            // 重点关注这个方法: getOrDefault, 如果有, 直接get出来key对应的value, 如果没有直接新建 new
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
