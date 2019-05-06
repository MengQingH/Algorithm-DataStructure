package leetcode;

/**
 * 到最近的人的最大距离：
 * 在一排座位（seats）中，1代表有人坐在座位上，0代表座位上是空的。其中至少有一个座位，且至少有一人坐在座位上.
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。返回他到离他最近的人的最大距离。
 * 示例：[1，0，0，0，1，0，1]
 * 结果：2。如果坐在第二个空位（seats[2]）上，离他最近的人的距离为2；如果坐在其它任何一个空位上，离他最近的人的距离为1。因此，最大距离是2。
 */
public class Seats {
    public static void main(String[] args) {
        Seats seats = new Seats();
        System.out.println(seats.maxDistToClosest(new int[]{1, 0, 0, 1}));
    }

    /**
     * 解题思路：
     * 空位两边都有人的情况：记录值为1的元素索引，遇到下一个值为1的元素，就计算这两个值的差值并除以2，结果即为距离最大值。
     * 空位一边有人的情况：即开头和结尾的情况，计算开头和结尾元素距离最近的1的距离，此时为距离空位的距离。
     * 比较这几种情况的值，最大值即为所求的解。
     *
     * 思路2：寻找连续值为0的最大长度
     *
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int length = 0;
        int f = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                //数组开始位置的距离
                if (f == -1) {
                    length = i;
                } else length = length > (i - f) / 2 ? length : (i - f) / 2;
                f = i;
            }
            //数组最后有人的位置距离末尾的最大长度，需要末尾的值为0
            if (i + 1 == seats.length && seats[i] == 0) {
                length = length > i - f ? length : i - f;
            }
        }
        return length;
    }
}