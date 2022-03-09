package Microsoft_Intership;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/27 10:28
 * @Filename Task2
 */
public class Task2 {
    public static int solution(String A, String B) {
        if (A.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j < B.length() + 1; j++) {
                // if (canPair(A.substring(5,6),B.substring(5,6))){
                //     System.out.println(A.substring(5,6));
                // }
                if (canPair(A.substring(i, j), B.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean canPair(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[256];
        for (char c : s.toCharArray()) {
            counter[c]++;
        }
        for (char c : t.toCharArray()) {
            if (--counter[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
