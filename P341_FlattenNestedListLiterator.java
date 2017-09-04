import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by linzhou on 9/3/17.
 */
public class P341_FlattenNestedListLiterator {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
            this.load();
        }

        private void load() {
            if (this.stack.isEmpty()) {
                return;
            }

            NestedInteger n = this.stack.pop();
            if (n.isInteger()) {
                this.stack.push(n);
            } else {
                List<NestedInteger> list = n.getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    this.stack.push(list.get(i));
                }

                if (!this.stack.isEmpty() && !this.stack.peek().isInteger()) {
                    this.load();
                }
            }
        }

        @Override
        public Integer next() {
            Integer res = this.stack.pop().getInteger();
            this.load();
            return res;
        }

        @Override
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }
    }
}
