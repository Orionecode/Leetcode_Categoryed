package Microsoft_Intership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/26 15:52
 * @Filename Demo
 */
public class Demo {
    public static int solution(int[] A) {
        List<Integer> aList = new ArrayList<>();
        for (int j : A) {
            if (j > 0) {
                aList.add(j);
            }
        }
        if (aList.isEmpty()) {
            return 1;
        }
        aList.sort(Comparator.naturalOrder());
        int compare = 1;
        for (int i = 0; i < aList.size() - 1; i++) {
            if (i > 0 && aList.get(i).equals(aList.get(i - 1))) {
                continue;
            }
            if (compare != aList.get(i)) {
                return compare;
            } else {
                compare++;
            }
        }
        if (compare == aList.get(aList.size() - 1)){
            compare ++;
        }
        return compare;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
    }
}
