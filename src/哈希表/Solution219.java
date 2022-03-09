package 哈希表;

import java.util.HashMap;

// 219. 存在重复元素 II
// 哈希表做法，题目有点疯批，注意理解哈希表的Get是Get的Key对应的Value

public class Solution219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k){
                return true;
            }
            // 关键在这里， 要把Key和Value对调放置，get的是Key对应的Value，这里的Hashmap我们将Value作为下标，Key为保存的值
            map.put(nums[i], i);
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1},1));
    }
}
