package lc_string;

/**
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串
 * 策略：遍历字符串，对每一个字符进行扩展
 * 对每一个字符，因为首尾指针同时移动也就是2位2位的移动，那么有2种情况
 * 1）奇数+偶数=奇数
 * 2）偶数+偶数=偶数
 * 这样字串的奇偶就确定下来了
 */
public class LC_647_Palindromic_Substrings {
    private int count = 0;
    public static void main(String[] args) {
        LC_647_Palindromic_Substrings substrings = new LC_647_Palindromic_Substrings();
        System.out.println(substrings.countSubstrings("aaa"));
    }
    public int countSubstrings(String s) {
        //遍历字符串的每一个字符，对每一个字符进行扩展
        //第一种是奇数的扩展，即开始的时候双指针都指向这个元素，然后向两边扩展因为两边都扩展1位所以整体还是奇数的情形
        //第二种是偶数的扩展，即开始的时候双指针一个指向这个元素，一个指向这个数的下一位，然后向两边进行扩展1位所以整体还是偶数
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);
            extendSubstrings(s, i, i + 1);
        }
        return count;

    }

    public void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
    }
}
