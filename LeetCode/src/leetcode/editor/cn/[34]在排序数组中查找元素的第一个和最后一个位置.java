package leetcode.editor.cn;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 743 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        // 特殊情况
        if (length == 0)
            return new int[]{-1, -1};
        int begin = 0;
        int end = length - 1;
        int mid = (end - begin) / 2;
        // 开始二分查找
        while (begin < end) {
            if (nums[mid] == target)
                break;
            if (nums[mid] < target) {
                begin = mid + 1;
                mid = (end + begin) / 2;
            } else {
                end = mid - 1;
                mid = (end + begin) / 2;
            }
        }
        // 查找结束，看此时的nums[mid]处是否等于target
        // 1)若等于target，则从mid开始两边分散，直到边界值结束并返回
        if (nums[mid] == target) {
            begin = mid;
            end = mid;
            while ((nums[begin - 1] == target) && (nums[end + 1] == target)) {
                if (begin - 1 >= 0 && nums[begin - 1] == target)
                    begin--;
                if (end + 1 <= length && nums[end] == target)
                    end++;
            }
            return new int[]{begin, end};
        }
        // 若不等于target，则说明没有找到target，返回[-1,-1]
        else {
            return new int[]{-1, -1};
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
