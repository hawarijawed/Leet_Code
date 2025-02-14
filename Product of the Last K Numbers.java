/*
Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

Implement the ProductOfNumbers class:

ProductOfNumbers() Initializes the object with an empty stream.
void add(int num) Appends the integer num to the stream.
int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers.
The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
*/
class ProductOfNumbers {
    ArrayList<Integer> lst;
    public ProductOfNumbers() {
        lst = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            lst.clear();
            return;
        }

        int prev = lst.size()==0?1:lst.get(lst.size()-1);
        lst.add(prev * num);
    }
    
    public int getProduct(int k) {
        int n = lst.size();
        if(n<k) return 0;
        else if(n==k) return lst.get(n-1);
        else{
            return (lst.get(n-1)/lst.get(n-1-k));
        }
    
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
