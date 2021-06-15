// leetcode 49
// https://leetcode-cn.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 设计 map
        // eat: ["ate","eat","tea"],
        // nat: ["nat","tan"],
        // bat: ["bat"]

        // 错误点: 我写成 Map<String, List<List<String>>>
        // 我混淆了 return 类型和key-value中value的类型
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            // 错误点: 这里是char[] 而不是Character[]!!!!!!!
            char[] array = str.toCharArray();
            // 数组排序, 记住, 数组排序方法!!!!
            Arrays.sort(array);

            // 创建key char -> string
            String key = new String(array);
            
            // 重点关注这个方法: getOrDefault, 如果有, 直接get出来key对应的value, 如果没有直接新建 new
            List<String> list = map.getOrDefault(key, new ArrayList<String>());

            // 啰嗦的写法, 但是肯定能在考场里面写出来
            // List list;
            // if (map.containsKey(key)) {
            //     list = map.get(key); 
            // } else {
            //     list = new ArrayList<String>();
            // }
            
            list.add(str);
            map.put(key, list);
        }

        //  错误点1, 提取所有values放进一个List里面, 我不知道怎么写
        //  错误点2: 获取所有values of map, 这是一个方法, 我漏了括号
        //  错误点3: 不是这么写 new ArrayList<ArrayList<String>>
        //  返回值的类型  List<List<String>>
        return new ArrayList<List<String>>(map.values());
        // map.values()返回值就是ArrayList
    }
}
