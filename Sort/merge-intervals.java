// https://leetcode-cn.com/problems/merge-intervals/
// leetcode 56

// 输入：
// intervals = [
//                 [1,3],
//                 [2,6],
//                 [8,10],
//                 [15,18]
//             ]
// 输出：[
//         [1,6],
//         [8,10],
//         [15,18]
//     ]

// 排序 + 双指针
// 图解: https://leetcode-cn.com/problems/merge-intervals/solution/merge-intervals-by-ikaruga/

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
        
        // 对起点终点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // 这是前一个元素和后一个元素做比较的题型, 以下就是套路
        for (int i = 0; i < intervals.length; i++) {
            
            // 临时左右变量
            int left = intervals[i][0];
            int right = intervals[i][1];
            
            // 如果有重叠，循环判断哪个起点满足条件
            // 思考这里为什么要有一个while循环, 因为我不知道可以更新几次
            // 可以不停的更新本次的右边界, 直到无法更新为止
            // 错误点: 当你使用 i + 1的时候, 一定要防止溢出, i < intervals.length - 1
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                // 更新右边界
                right = Math.max(right, intervals[i][1]);
            }
            
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
        }

        return res.toArray(new int[0][]);
    }
}


// 不推荐的版本
public static int[][] merge(int[][] intervals) {
    if(intervals.length == 0){
        return new int[][]{};
    }
    // 关键: 按照start的升序排序
    Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
    
    int[][] res = new int[intervals.length][2];
    
    int rowIndex = 0;
    
    // 加入第一个元素的开始和结束区间
    int start =intervals[0][0];
    int end = intervals[0][1];
    
    //下一个数组的起始值必须要小于上一个数组的最大值才能合并
    // 为什么i 从1开始, 而不是从0, 因为只考虑第一组元素之后的元素
    for(int i = 1; i < intervals.length; i++){
        // -----------------
        //                 end
        //         ---------------
        //     intervals[i][0]
        //如果当前最小界比上一个的最大界小 说明可以合并 ，更新更新后的上界
        if(intervals[i][0] <= end){
            end = Math.max(intervals[i][1], end);
        } else {
            // -----------------
            //                 end
            //                      ---------------
            //                intervals[i][0]
            //说明不能继续合并了 ，把之前合并的结果存入结果集中
            res[rowIndex][0] = start;
            res[rowIndex][1] = end;
            rowIndex++;

            //更新start 和 end 为当前新范围
            start = intervals[i][0];
            end = intervals[i][1];
        }
    }

    // 如果每次都没有进入循环, 肯定要加入一次
    // 因为每次都是前一次比较, 后一次加入结果集, 所以最后一次的问题是出了循环, 结果集没有加入
    res[rowIndex][0] = start;
    res[rowIndex][1] = end;
    
    return Arrays.copyOfRange(res, 0, rowIndex + 1);
}

// 不推荐的版本
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     public int compare(int[] interval1, int[] interval2) {
        //         return interval1[0] - interval2[0];
        //     }
        // });        
        Arrays.sort(intervals, (a,b)->{return a[0]-b[0];});

        List<int[]> merged = new ArrayList<int[]>();
        
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                // 更新结果集
                merged.add(new int[]{L, R});
            } else {
                // 可以合并, 更新上界
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }

        // ArrayList to array
        return merged.toArray(new int[merged.size()][]);
    }
}