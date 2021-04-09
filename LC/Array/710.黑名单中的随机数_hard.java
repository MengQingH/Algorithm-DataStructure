/*
 * @Author: QingHui Meng
 * @Date: 2021-04-09 09:38:39
 */
/*
 * @lc app=leetcode.cn id=710 lang=java
 *
 * [710] 黑名单中的随机数
 */

// @lc code=start
class Solution {

    private int size;
    private HashMap<Integer, Integer> mapping;
    private Random random;

    /**
     * 思路：去除0-n之前在黑名单内的数据，但是常规解法中，需要轮询n个数据，再轮询一遍blacklist表，所以时间复杂度为O(mn)
     *  可以换一种思路，不需要删除这些元素，而是把黑名单中的元素和数组最后的元素做一个映射，随机取值的时候取N-blacklist.length个元素
     * 
     * @param {*}
     * @return {*}
     */
    public Solution(int N, int[] blacklist) {
        random = new Random();
        mapping  = new HashMap<>();
        size = N - blacklist.length;

        // 先把blacklist中所有元素放入映射
        for(int i : blacklist){
            mapping.put(i, 1);
        }
        int last = N-1;
        for(int i : blacklist){
            // 如果i已经zai区间[size, N)，可以直接忽略
            if(i >= size){
                continue;
            }
            // 如果last在balcklist中，跳过取下一个
            while(mapping.containsKey(last)){
                last--;
            }
            mapping.put(i, last);
            last--;
        }
        
    }

    public int pick() {
        // 随机取一个随机数
        int index = random.nextInt(size);
        // 如果这个索引在黑名单中，映射到其他位置
        if(mapping.containsKey(index)){
            return mapping.get(index);
        }
        return index;
    }


    /******************************* 常规解法 *******************************/

    private List<Integer> list;
    private Random random1;

    /**
     * 使用常规解法，把不在黑名单中的数放入一个list中，取list中的元素。
     * 两个测试用例超时
     * 
     * @param {*}
     * @return {*}
     */
    public void Solution1(int N, int[] blacklist) {
        random = new Random();
        list = new ArrayList<>();
        List<Integer> bl = Arrays.stream(blacklist).boxed().collect(Collectors.toList());
        for(int i = 0; i<N; i++){
            if(!bl.contains(i)){
                list.add(i);
            }
        }
    }
    
    public int pick1() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end

