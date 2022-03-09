
/**
 * @Author YixiaoZeng
 * @Date 2022/3/6 15:24
 * @Filename Solution88
 */

public class Solution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];
        // nums1指针
        int p1 = 0;
        // nums2指针
        int p2 = 0;
        while (p1 < m || p2 < n) {
            int value;
            // 边界情况，如果p1已经等于被拷贝数值了，那么就拷贝p2的进去
            if (p1 == m) {
                value = nums2[p2];
                p2++;
            } else if (p2 == n) {
                value = nums1[p1];
                p1++;
            } else if (nums2[p2] > nums1[p1]) {
                value = nums1[p1];
                p1++;
            } else {
                value = nums2[p2];
                p2++;
            }
            sorted[p1 + p2 - 1] = value;
        }
        if (m + n >= 0) System.arraycopy(sorted, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
