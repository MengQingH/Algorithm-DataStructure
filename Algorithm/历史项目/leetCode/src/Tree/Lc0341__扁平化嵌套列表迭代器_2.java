package Tree;

import java.util.Iterator;
import java.util.List;

public class Lc0341__扁平化嵌套列表迭代器_2 {

    public class NestedIterator implements Iterator<Integer> {

        public NestedIterator(List<NestedInteger> nestedList) {

        }

        @Override
        public Integer next() {
            return null;
        }

        @Override
        public boolean hasNext() {
            return false;
        }
    }

    /**
     * 题目中需要的数据结构
     */
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
  }

}
