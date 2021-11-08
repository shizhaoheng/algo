package leetcode.editor.cn;

//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 480 👎 0


/**
 * @author : Zhaoheng Shi
 * @date : 2021-11-08 10:23:14
 * 二分查找
 */

public class P704BinarySearch {
    public static void main(String[] args) {
        Solution solution = new P704BinarySearch().new Solution();

        int[] nums = {-1,0,3,5,9,12};
        int result = solution.search(nums, 9);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            //解法1：循环
            /*
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
             */

            //解法2：递归
            return searchInternally(nums, 0, nums.length - 1, target);
        }

        private int searchInternally(int[] nums, int low, int high, int target) {

            if (low > high) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return searchInternally(nums,mid+1,high,target);
            } else {
                return searchInternally(nums,low,mid-1,target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}