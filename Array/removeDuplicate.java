int removeDuplicate(int[] nums) {
	if (nums.size == 0) {
		return 0;
	}

	// 慢指针, 指向可以写入的位置的指针
	int len = 0;

	// i 是快指针, 是traverse的指针
	// 注意: 快指针要跳过0, 因为指向相同的地址没有意义
	for (int i = 1; i < nums.size(); i++) {
		// 如果 快慢指针指向相同的内容, 快指针++, 慢指针不动

		if (nums[len] != nums[i]) {
			// 快慢指针指向不同的数值
			// 快指针的内容复制到 *慢指针*+1指向的位置
			// 关键这里是先++len 而不是len++, 这个很关键!!!
			nums[++len] = nums[i];
		}
	}

	// 所有慢指针指向的位置都是non duplicate
	return len + 1;
}