/*
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.
A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).
The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
Implement the MyCalendarTwo class:

MyCalendarTwo() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
*/
class Event
{
  int start;
  int end;
  public Event(int start, int end)
  {
    this.start = start;
    this.end = end;
  }  
}

class MyCalendarTwo {
    List<Event> overLapBookings;
    List<Event> bookings;

    public MyCalendarTwo() {
        overLapBookings = new ArrayList<>();
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        
    for(Event e : overLapBookings)
    {
      if(isOverlap(e, start, end))
      return false;  
    } 

    for(Event e : bookings)
    {
      if(isOverlap(e, start, end))
      {
        overLapBookings.add(getOverlapEvent(e, start, end));
      }    
    }  
       bookings.add(new Event(start, end));

       return true; 
    }

    public boolean isOverlap(Event e, int start, int end)
    {
      return Math.max(e.start, start)<Math.min(e.end, end); 
    }

    public Event getOverlapEvent(Event e, int start, int end)
    {
      return new Event(Math.max(e.start, start), Math.min(e.end, end));  
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
