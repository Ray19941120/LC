package lc_string;

import java.util.HashMap;

/**
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 */
public class LC_242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        for (char c : s.toCharArray()) {
            ints[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            ints[c - 'a']--;
        }
        for (int cnt : ints) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isanagram2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c,map.get(c)+1);
            }
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c,map.get(c)-1);
            }
        }
        for (Character c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaddefhg";
        String t = "ddehgfac";
        //System.out.println(isAnagram(s, t));
        System.out.println(isanagram2(s, t));
    }
}
