package dataStructure.arrayList;

/**
 * 线性表接口，和存储结构无关
 */
public interface List {
    //返回表中元素的个数
    int size();

    //返回线性表中序号为i的元素
    Object get(int i);

    //返回线性表是否为空
    boolean isEmpty();

    //返回线性表中是否包含某元素
    boolean contains(Object e);

    //返回某元素e在线性表中的序号
    int indexOf(Object e);

    //把元素e添加到线性表中i号位置
    void add(int i, Object e);

    //把元素e添加到线性表末尾
    void add(Object e);

    //把元素e添加到某元素之前
    boolean addBefore(Object obj, Object e);

    //把元素e添加到某元素之后
    boolean addAfter(Object obj, Object e);

    //删除线性表中序号为i的元素，并返回
    Object remove(int i);

    //删除线性表中第一个与e相同的元素
    boolean remove(Object e);

    //替换线性表中序号为i的数据元素e，返回原数据元素
    Object replace(int i, Object e);
}
