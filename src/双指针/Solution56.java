package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/1 13:43
 * @Filename Solution56
 */

public class Solution56 {
	public int[][] merge(int[][] intervals) {
		int n = intervals.length;
		if (n == 1) {
			return intervals;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 按照每个小数组的第一位进行排序
				return o1[0] - o2[0];
			}
		});
		// 声明一个全是int[]的动态数组
		List<int[]> merged = new ArrayList<int[]>();
		for (int[] interval : intervals) {
			// 左右指针分别指向每一项的左右两个数
			int left = interval[0];
			int right = interval[1];
			// 如果数组长度还是0或者如果数组的最后一项的右边项目比新left小，那么就加入新List
			if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
				merged.add(new int[]{left, right});
			}
			// 否则将数组的右值和当前的right进行比较，更换为较大的那个
			else {
				merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}

	public static void main(String[] args) {
		Solution56 solution56 = new Solution56();
		int nums[][] = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		System.out.println(Arrays.deepToString(solution56.merge(nums)));
	}
}
