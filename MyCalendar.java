/*
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
*/
class MyCalendar {
    TreeMap<Integer, Integer> calcy;
    public MyCalendar() {
    calcy = new TreeMap();

    }
    
    public boolean book(int start, int end) {
    Integer prevBook = calcy.floorKey(start);
    Integer nextBook = calcy.ceilingKey(start);
    if((prevBook==null || calcy.get(prevBook)<=start) && (nextBook==null || end<=nextBook)) 
    { 
    calcy.put(start, end);
    return true;
    }
    return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
