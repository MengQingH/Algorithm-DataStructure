/*
 * @Author: QingHui Meng
 * @Date: 2021-04-07 15:16:06
 */
/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] 常数时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> valToIndex;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToIndex.containsKey(val))
            return false;
        list.add(list.size(), val);
        valToIndex.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valToIndex.containsKey(val))
            return false;
        int lastIndex = list.size()-1;
        int last = list.get(lastIndex);
        int valIndex = valToIndex.get(val);

        //list的add方法是把元素添加到某个位置上，把所有的元素向后移；set方法是直接替换
        list.set(valIndex, last);
        valToIndex.put(last, valIndex);

        list.remove(lastIndex);
        valToIndex.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

