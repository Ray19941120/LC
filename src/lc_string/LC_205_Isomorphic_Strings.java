package lc_string;

/**
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * 转换思维：egg->122
 * "bbbaaaba"
 * "aaabbbba"
 */
public class LC_205_Isomorphic_Strings {
    public static void main(String[] args) {
        String str1 = "bbbaaaba";
        String str2 = "aaabbbba";
        boolean isomorphic = isIsomorphic(str1, str2);
        System.out.println(isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char target1 = s.charAt(i);
            char target2 = t.charAt(i);
            if (arr1[target1] != arr2[target2]) {
                return false;
            }
            //这里的核心逻辑是i+1，为什么i+1呢？
            //这里记录的是这个元素最后一次出现的位置
            arr1[target1]=i+1;
            arr2[target2]=i+1;

            //arr1[target1]+=i;
            //arr2[target2]+=i;
        }
        return true;
    }
    }
