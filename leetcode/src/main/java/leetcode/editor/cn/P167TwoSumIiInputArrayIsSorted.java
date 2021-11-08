package leetcode.editor.cn;

//给定一个已按照 非递减顺序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
// < answer[1] <= numbers.length 。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
// 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
// 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
// Related Topics 数组 双指针 二分查找 👍 611 👎 0


import java.util.Arrays;

/**
 * @author : Zhaoheng Shi
 * @date : 2021-11-08 15:14:11
 * 两数之和 II - 输入有序数组
 */

public class P167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            //解法1：二分查找
            /*时间复杂度：O(nlogn)，其中 n是数组的长度。需要遍历数组一次确定第一个数，时间复杂度是 O(n)，
            寻找第二个数使用二分查找，时间复杂度是O(logn)，
            因此总时间复杂度是O(nlogn)。
            空间复杂度：O(1)
            */

            /*
            for (int i = 0; i < numbers.length; i++) {
                int low = i + 1, high = numbers.length - 1;
                while (low <= high) {
                    int mid = low + ((high - low) >> 1);
                    if (numbers[mid] == target - numbers[i]) {
                        return new int[]{i + 1, mid + 1};
                    } else if (numbers[mid] < target - numbers[i]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

            }
            return new int[]{-1, -1};
             */
            //解法2：双指针
            /*
            时间复杂度：O(n))，其中 n 是数组的长度。两个指针移动的总次数最多为 n 次。
            空间复杂度：O(1)
             */
            int low = 0, high = numbers.length - 1;
            while (low < high) {
                int sum = numbers[low] + numbers[high];
                if (target == sum) {
                    return new int[]{low + 1, high + 1};
                } else if (sum < target) {
                    ++low;
                } else {
                    --high;
                }
            }


            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}