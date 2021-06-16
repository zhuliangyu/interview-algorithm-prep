// https://leetcode-cn.com/problems/two-sum/
// leetcode 1

// 排序 + 双指针的做法
// 如果题目中, 数组已经排好序, 这个双指针肯定比hashmap来的好
// 但是其实hashmap的解法比这个方法代码简洁的多

public class Solution {
    class Pair implements Comparable<Pair> {
        
        // index 存放的是原始下标
        int number, index;
        
        public Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }
        
        // 比较器
        public int compareTo(Pair other) {
            return number - other.number;
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1};
        
        if (numbers == null) {
            return result;
        }
        
        // 这里有一个思考问题: 为什么要这么做? 为什么不能直接排序? 
        // 因为返回值需要返回的是你原来的数组的index, 但是现在的问题是你sort之后, 你的index就乱了
        // 所以我们用一个新的class point先把原先的下标存起来
        // 现在有两套的下标: 原始下标, 存在Point的class里面, 另外一个是 Pair[] pairs的下标, 这个是新的index
        Pair[] pairs = getSortedPairs(numbers);
        
        int left = 0, right = pairs.length - 1;
        while (left < right) {
            if (pairs[left].number + pairs[right].number < target) {
                left++;
            } else if (pairs[left].number + pairs[right].number > target) {
                right--;
            } else {
                // 因为两个数字我不知道谁大, 所以去min放0,取max放1
                result[0] = Math.min(pairs[left].index, pairs[right].index);
                result[1] = Math.max(pairs[left].index, pairs[right].index);
                return result;
            }
        }
        
        return result;
    }
    
    private Pair[] getSortedPairs(int[] numbers) {
        Pair[] pairs = new Pair[numbers.length];
        
        // 每一个数组元素存入pairs中
        for (int i = 0; i < numbers.length; i++) {
            pairs[i] = new Pair(numbers[i], i);
        }

        // 关键: 排序
        Arrays.sort(pairs);

        return pairs;
    }
}
