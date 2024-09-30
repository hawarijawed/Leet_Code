/*
Design a stack that supports increment operations on its elements.

Implement the CustomStack class:

CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
int pop() Pops and returns the top of the stack or -1 if the stack is empty.
void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
*/
class CustomStack {
    private int n;
    private Stack<Integer> stack;
    private List<Integer> inc;

    public CustomStack(int n) {
        this.n = n;
        this.stack = new Stack<>();
        this.inc = new ArrayList<>();
    }

    public void push(int x) {
        if (stack.size() < n) {
            stack.push(x);
            inc.add(0);
        }
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        if (inc.size() > 1) inc.set(inc.size() - 2, inc.get(inc.size() - 2) + inc.get(inc.size() - 1));
        return stack.pop() + inc.remove(inc.size() - 1);
    }

    public void increment(int k, int val) {
        if (!stack.isEmpty()) {
            int index = Math.min(k, inc.size()) - 1;
            inc.set(index, inc.get(index) + val);
        }
    }
}
