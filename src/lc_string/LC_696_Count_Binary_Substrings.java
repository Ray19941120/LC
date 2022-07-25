package lc_string;

/**
 * "00110011"
 */
public class LC_696_Count_Binary_Substrings {
    public static int countBinarySubstrings(String s) {
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "00110011";
        int i = countBinarySubstrings(str);
        System.out.println(i);
    }
}
