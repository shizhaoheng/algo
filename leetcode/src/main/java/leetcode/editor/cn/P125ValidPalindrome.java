package leetcode.editor.cn;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 385 👎 0


/**
 * @author : Zhaoheng Shi
 * @date : 2021-06-03 13:47:35
 * 验证回文串
 */

public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            System.out.println(c);
//        }
//        System.out.println(Character.isLetterOrDigit('中'));
//        System.out.println(solution.isPalindrome1(s1));
//        System.out.println(solution.isPalindrome1(s2));
//        System.out.println("------------------------");
//        System.out.println(solution.isPalindrome2(s1));
//        System.out.println(solution.isPalindrome2(s2));
//        System.out.println("------------------------");
        System.out.println(solution.isPalindrome(s1));
//        System.out.println(solution.isPalindrome(s2));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一:字符串翻转
        public boolean isPalindrome1(String s) {
            StringBuffer sqood = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    sqood.append(c);
                }
            }
            StringBuffer sqood_rev = new StringBuffer(sqood).reverse();
            return sqood.toString().equalsIgnoreCase(sqood_rev.toString());
        }

        //方法二:双指针
        public boolean isPalindrome2(String s) {
            StringBuffer sqood = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    sqood.append(c);
                }
            }
            int n = sqood.length();
            int left = 0, right = n - 1;
            while (left < right) {
                if (Character.toLowerCase(sqood.charAt(left)) != Character.toLowerCase(sqood.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
            return true;
        }

        //方法三:原字符串上使用双指针判断
        public boolean isPalindrome(String s) {

            int n = s.length();
            int left = 0, right = n - 1;
            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    ++left;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    --right;
                }
                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    ++left;
                    --right;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}