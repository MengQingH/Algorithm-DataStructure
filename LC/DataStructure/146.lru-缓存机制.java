/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {

    /********************** 利用LinkedHashMap实现 ****************/

    private int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap= capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            return -1;
        }
        //把key更新为最近使用
        markRecently(key);
        return cache.get(key);

    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void markRevently(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }


    /********************** 手写数据结构实现 ********************/

    //存放key和节点的映射，方便找到节点
    private HashMap<Integer, Node> map;
    //保存节点的存放顺序
    private DoubleList cache;
    //容量
    private int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        markRecently(key);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if(cache.size == cap){
            deleteLeastRecently();
        }
        addRecently(key, value);
    }

    /********* 封装方法 ********/
    
    //把key提升为最近使用的
    private void markRecently(int key){
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    //添加最近使用的元素
    private void addRecently(int key, int val){
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    //删除某一个key
    private void deleteKey(int key){
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    //移除最久未使用的元素
    private void deleteLeastRecently(){
        //双链表的第一个节点就是最久未使用的
        Node delNode = cache.removeFirst();
        //还需要从map中删除key
        map.remove(delNode.key);
    }

    /********* 用到的数据结构 *********/

    //双链表的节点
    class Node{
        public int key, val;
        public Node prev, next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    //双链表实现
    class DoubleList{

        //虚头尾节点
        private Node head, tail;
        //链表元素个数
        private int size;

        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        //在链表尾部添加新的节点node  O(1)
        public void addLast(Node node){
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        //删除链表中的node节点（节点一定存在）
        //由于使用的是双链表并且给定了目标节点，所以时间复杂度O(1)
        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        //删除链表中的第一个节点，并返回该节点  O(1)
        public Node removeFirst(){
            if(head.next == tail)return null;
            Node delNode = head.next;
            remove(delNode);
            return delNode;
        }

        //返回链表长度  O(1)
        public int size(){
            return size;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

