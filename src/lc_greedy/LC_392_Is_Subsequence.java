package lc_greedy;

/**
 *
 */
public class LC_392_Is_Subsequence {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        int l = 0;
        int r = 0;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) == t.charAt(r)) {
                l++;
                r++;
            } else {
                r++;
            }
        }
        //因为上面的循环r是多移的，那么r会先便利完
        if (l != s.length()) {
            return false;
        }
        return true;
    }
}
