
// leetcode 26

// 快慢指针题型
// 要了解快慢指针各自代表什么意义;
// 快慢指针如何移动的规律;
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
		return 0;
	}

	// 数组已经排好序, 所以肯定是前后才会相等

	// 慢指针, 指向可以写入的位置的指针
	int slow = 0;

	// 快指针, 是traverse的指针, 从1开始, 不是从0
	for (int fast = 1; fast < nums.length; fast++) {

		if (nums[slow] != nums[fast]) {
			// 前后不相等
			
			// 快慢指针指向不同的数值
			// 快指针的内容复制到 *慢指针*+1指向的位置

            // 关键点: 每次要写入之前, 要把慢指针往前走一个, 这是新的可以写入的地点
            // 错误点: slow++写在了赋值语句的下面
            slow++;
			nums[slow] = nums[fast];
		} else {
			// do nothing
            // 如果 快慢指针指向相同的内容, 快指针++(在for循环里面), 慢指针不动
		}
	}


	// 所有慢指针指向的位置都是non duplicate
	return slow + 1;

    }
}