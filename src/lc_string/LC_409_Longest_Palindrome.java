package lc_string;

/**
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LC_409_Longest_Palindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    //第一个知识点：一共有多少个字符，256个字符
    public static int longestPalindrome(String s) {
        int[] ints = new int[256];
        for (char c : s.toCharArray()) {
            ints[c]++;
        }
        //申请变量用于记录偶数字符的对数
        int palindrome = 0;
        for (int cnt : ints) {
            palindrome += (cnt / 2) * 2;
        }
        //经历了上面的for循环可以得到回文的偶数的数量，如果没有到达末尾，说明
        if (palindrome != s.length()) {
            palindrome++;
        }
        return palindrome;
    }
}
