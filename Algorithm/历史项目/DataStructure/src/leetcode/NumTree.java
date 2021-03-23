package leetcode;

/**
 * NumTree：
 * 给定一个整数n，求以1-n为结点组成的二叉搜索树有多少种？
 */
public class NumTree {

    public static void main(String[] args) {
        NumTree n = new NumTree();
        System.out.println(n.numTree(3));
    }

    /**
     * 解题思路：使用动态规划解决问题。设n个结点的二叉排序树的个数是G(n)，f(i)为以i为根的二叉搜索树的个数。
     * 则有G(n) = f(1)+f(2)+f(3)+...+f(n)，因为n个结点每一个结点都可能是根节点。
     * 当i为根节点时，由于二叉搜索树的性质，左子树的结点为1...i-1，右子树的结点为i+1...n，即f(i)=G(i-1)*G(n-i)。
     * 由上面两式得G(n) = G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)
     *
     * @param n
     * @return
     */
    public int numTree(int n) {
        //当结点为0或1的时候只有一种情况
        if (n <= 1) {
            return 1;
        }
        //dp[i]表示i个结点的二叉搜索树的个数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //对dp进行遍历，结点个数从1到n进行遍历
        for (int i = 1; i <= n; i++) {
            int num = 0;
            //当有i个结点时求其中的二叉树的个数
            for (int j = 0; j < i; j++) {
                num += dp[j] * dp[i - j - 1];
            }
            dp[i] = num;
        }
        return dp[n];
    }
}
