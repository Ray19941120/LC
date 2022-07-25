package lc_string;

/**
 * 判断数字是不是回文字符串
 * 策略：将后半部分的数字进行转置
 */
public class LC_9_Palindrome_Number {
    public static void main(String[] args) {
        LC_9_Palindrome_Number number = new LC_9_Palindrome_Number();
        System.out.println(number.isPalindrome(1221));
    }
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        //1221 121
        while (x > right) {//x在一位一位的缩小，而right在一位一位的扩大，直到两者基本持平
            right = right * 10 + x % 10;
            x /= 10;
        }
        //因为有奇数和偶数的区别
        return x == right || x == right / 10;
    }
}
