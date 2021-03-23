# Java中的查找树
## TreeSet
TreeSet的底层结构采用TreeMap，TreeMap的底层实现采用了红黑树
```java
//构造方法，新建一个TreeSet实际上创建了一个TreeMap
private transient NavigableMap<E,Object> m;
public TreeSet() {
    this(new TreeMap<E,Object>());
}
TreeSet(NavigableMap<E,Object> m) {
    this.m = m;
}

//向TreeSet中添加元素时，实际上是向TreeMap中添加了一个元素，元素的值作为map的key存在，对应的value是一个空的Object对象
private static final Object PRESENT = new Object();
public boolean add(E e) {
    return m.put(e, PRESENT)==null;
}

//以下方法都是调用的map的方法
public int size() {
    return m.size();
}
public boolean isEmpty() {
    return m.isEmpty();
}
public void clear() {
    m.clear();
}
```

# 哈希表
## HashSet
与TreeSet类似，HashSet的底层结构使用的是HashMap。Set中的元素作为HashMap的key，value值是一个空的Object对象。
```java
//底层使用HashMap
private transient HashMap<E,Object> map;
public HashSet() {
    map = new HashMap<>();
}

//add方法
private static final Object PRESENT = new Object();
public boolean add(E e) {
    return map.put(e, PRESENT)==null;
}
//其他如size(), isEmpty(), clear()等方法也是直接调用的map的对应方法
```
## HashMap
底层使用了哈希表HashTable。在jdk1.7之前一直使用的是普通的哈希表，即一个链表数组。在1.7之后，采用了下面的结构：
<br><img src=img/hashmap.png><br>
当链表中元素超过8的时候，就不使用链表而采用红黑树。这么做的原因是在查询的复杂度上，链表是n，而红黑树一直是log(n)，如果冲突多，使用红黑树来提高效率。
