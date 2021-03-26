/*
 * @Author: QingHui Meng
 * @Date: 2021-03-23 10:39:44
 */
/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存
 */

// @lc code=start
class LFUCache {

    //key 到 val 的映射
    private HashMap<Integer, Integer> keyToVal;
    //key 到 freq 的映射
    private HashMap<Integer, Integer> keyToFreq;
    //greg 到 key 列表的映射
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    //记录最小的频次
    private int minFreq;
    //记录LUF的最大容量
    private int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if(!keyToVal.containsKey(key))
            return -1;
        //增加key对应的freq
        increaseFreq(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        //这个条件不能少
        if(this.cap <= 0)return;
        //如果key已经存在，修改对应的val
        if(keyToVal.containsKey(key)){
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        //key不存在需要插入
        //容量已满，淘汰一个freq最小的key
        if(this.cap <= keyToVal.size()){
            removeMinFreqKey();
        }

        //插入KV表
        keyToVal.put(key, value);
        //插入KF表
        keyToFreq.put(key, 1);
        //插入FK表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<Integer>());
        freqToKeys.get(1).add(key);
        //插入后最小的freq肯定是1
        this.minFreq = 1;
    }

    /**
     * 增加key对应的频次
     * 
     * @param {*}
     * @return {*}
     */
    private void increaseFreq(int key){
        int freq = keyToFreq.get(key);
        //更新KF表
        keyToFreq.put(key, freq+1);
        //更新FK表
        //首先把key从freq对应的列表中删除
        freqToKeys.get(freq).remove(key);
        //把key加入freq+1对应的列表中
        freqToKeys.putIfAbsent(freq+1, new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
        //如果freq对应的列表空了，移除这个freq
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            //如果freq刚好是minFreq，更新minFreq
            if(this.minFreq == freq){
                this.minFreq++;
            }
        }
    }

    /**
     * 移除freq最小且最早的key
     * 
     * @param {*}
     * @return {*}
     */
    private void removeMinFreqKey(){
        //找到freq最小的列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        //最先插入的肯定就是应该被淘汰的key
        int deleteKey = keyList.iterator().next();

        //更新FK表
        keyList.remove(deleteKey);
        if(keyList.isEmpty()){
            //如果keyList为空，删除这个freq
            freqToKeys.remove(this.minFreq);
            //删除freq之后，理论上是需要更新minFreq，
            //但是实际上调用removeMinFreqKey方法的地方是在插入时，所以之后肯定会插入新元素并把minFreq设置为1
        }
        //更新KV表
        keyToVal.remove(deleteKey);
        //更新KF表
        keyToFreq.remove(deleteKey);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

