package leetcode;

/**
 * ConstructRectangle：
 * 设计一个长度为 L 和宽度为 W 且满足以下要求的矩形：
 * 1.你设计的矩形页面必须等于给定的目标面积。
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小，且都为整数。
 * 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
 */
public class ConstructRectangle {
    /**
     * 解题思路：求面积的开方值，距离开方值最近且能被整除的的两个值为要求的长和宽，其中一个大于开方值，一个小于开方值。
     *
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int[] lw = new int[2];
        int sqrt = (int) Math.sqrt(area);

        while (area % sqrt != 0) {
            sqrt--;
        }
        int[] i = new int[]{area / sqrt, sqrt};
        return i;

    }
}
