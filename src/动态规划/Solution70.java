package 动态规划;

// 70. 爬楼梯
// 典型动态规划算法的实现

public class Solution70 {
    public static int dynamicClimbStairs(int n) {
//      如果小于两层楼直接返回就好
        if (n <= 2){
            return n;
        }
//      创建状态转移表格，因为楼梯我们没有设置第0层，所有是n + 1
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
//      因为楼梯直接输入的是10，在数组中是Index 11，如果是i < n的话就到不了第十层（i = 11）
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(dynamicClimbStairs(10));
    }
}
