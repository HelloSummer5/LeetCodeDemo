package com.leetcode.everyday;

/**
 * @Date 2020/6/3
 * @NO  题目编号：LeetCode837
 * @Description 题目描述：
 *    爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 *
 * @Example 示例1:
 *      输入：N = 10, K = 1, W = 10
 *      输出：1.00000
 *      说明：爱丽丝得到一张卡，然后停止。
 *
 * @Example 示例2:
 *      输入：N = 6, K = 1, W = 10
 *      输出：0.60000
 *      说明：爱丽丝得到一张卡，然后停止。
 *      在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
 *
 * @Example 示例3:
 *      输入：N = 21, K = 17, W = 10
 *      输出：0.73278
 */
public class LeetCode837 {

    public static void main(String[] args) {
        System.out.println(new21Game2(21,17,10));
        System.out.println(new21Game3(21,17,10));
    }

    public static double new21Game(int N, int K, int W) {
        double[] f = new double[K + W];
        for (int i = K; i <= N; i++) {
            f[i] = 1.0;
        }
        double s = N - K + 1;
        for (int x = K - 1; x >= 0; x--) {
            f[x] =  s / W;
            // 原等式便于理解：s = s - f[x + W] + f[x + 1]，下面这行原等式基础之上优化
            s += f[x] - f[x + W];
        }
        return f[0];
    }
    /**
     * @Author 啵酱
     * @Description 这个答案超时了
     * @param N 分数小<=n
     * @param K 不少于K分
     * @param W 牌面范围Max
     * @return
     */
    public static double new21Game1(int N, int K, int W) {
        if (K == 0){
            return 1.0;
        }
        double[] dp = new double[K + W];
//        for (int i = K; i <= N && i < K + W; i++) {
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        for (int i = K - 1; i >= 0; i--) {
            // 第一轮的概率
            for (int j = 1; j <= W; j++) {
                // 每次算出
                double tmp = dp[i + j];
                dp[i] += tmp / W;
            }
        }
        return dp[0];
    }


    /**
     * @Author
     * @Description 优化1
     * @param N 分数小<=n
     * @param K 不少于K分
     * @param W 牌面范围Max
     * @return
     */
    public static double new21Game2(int N, int K, int W) {
        if (K == 0){
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }

        double s = N - K + 1;
        for (int i = K - 1; i >= 0; i--) {
           dp[i] = s / W;
           s += dp[i] - dp[i + W];
        }
        return dp[0];
    }

    /**
     * @Author 啵酱
     * @Description 优化2：公式优化
     * @param N 分数小<=n
     * @param K 不少于K分
     * @param W 牌面范围Max
     * @return
     */
    public static double new21Game3(int N, int K, int W) {
        if (K == 0){
            return 1.0;
        }
        double[] f = new double[K + W];
        for (int i = K; i <= N; i++) {
            f[i] = 1.0;
        }
        // 初始化f[K - 1]即 f(16), Math.min以 N - K > W 导致概率超过1
        f[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int x = K - 1; x >= 1; x--) {
            f[x - 1] = f[x] - (f[x + W] - f[x]) / W;
        }
        return f[0];
    }

    public static double new21GameP2(int N, int K, int W) {
        if (K == 0){
            return 1.0;
        }
        double[] f = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            f[i] = 1.0;
        }

        double s = N - K + 1;
        for (int i = K - 1; i >= 0; i--) {
            f[i] = s / W;
            s += f[i] - f[i + W];
        }
        return f[0];
    }

    public static double new21GameP3(int N, int K, int W) {
        // 初始化一个数组(长度为K+W，包含0)来表示蓝色部分的概率
        double f[] = new double[K + W];
        // [K, N]初始化为1，剩下初始化为0
        for (int i = K; i <= N; i++) {
            f[i] = 1.0;
        }

        for (int x = K - 1; x >= 0 ; x--) {
            for (int j = 0; j <= N; j++) {
                // 无脑堆公式
                double tmp = f[x + j];
                f[x] += tmp / W;
            }
        }
        return f[0];
    }
}
