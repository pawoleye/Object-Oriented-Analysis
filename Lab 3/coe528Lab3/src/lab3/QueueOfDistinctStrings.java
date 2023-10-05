package lab3;

import java.util.ArrayList;

public class QueueOfDistinctStrings {
    // Overview: QueueOfDistinctStrings are mutable, bounded
    // collection of distinct strings that operate in
    // FIFO (First-In-First-Out) order.
    //
    // The abstraction function is:
    // a)
    // AF(c) = an abstract queue q such that:
    // q.queueOfStrings = c.items 
    // q.front = c.items.get(0)
    // q.end = c.items.get(items.size()-1)
    //
    // The rep invariant is: 
    // b) Write the rep invariant here
    // RI(c) = false if  
    // for (int i = 0; i < items.size(); i++) 
    // for (int j = i+1; j < items.size(); j++)
    //  if (items.get(i) == items.get(j))
    //  && if(items.size() == 0)
    //  otherwise = true
    // Informal
    // (If any array element has same value as another array element) = false
    //(If the array is empty) = false
    // otherwise true
    //the rep
    private ArrayList<String> items;
    
   
    // constructor
    public QueueOfDistinctStrings () {
        // EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }
        // MODIFIES: this
        // EFFECTS: Appends the element at the end of the queue
        // if the element is not in the queue, otherwise
        // does nothing.
    public void enqueue(String element) throws Exception {
        if(element == null) throw new Exception();
        if(false == items.contains(element))
        items.add(element);
    }
        
    public String dequeue() throws Exception {
        // MODIFIES: this
        // EFFECTS: Removes an element from the front of the queue
        if (items.size() == 0) throw new Exception();
        return items.remove(0);
    }
        
    public boolean repOK() {
    // EFFECTS: Returns true if the rep invariant holds for this
    // object; otherwise returns false
    // c) Write the code for the repOK() here
    if (items.isEmpty()){
        return false;
    }
    for (int i = 0; i < items.size(); i++){
        for (int j = i+1; j < items.size(); j++){
            if (items.get(i) == items.get(j)){
            return false;
            }
        }
    }
    return true;
    }
    
    
    @Override
    public String toString() {
        // EFFECTS: Returns a string that contains the strings in the
        // queue, the front element and the end element.
        // Implements the abstraction function.
        // d) Write the code for the toString() here
        return "The queue of strings is: "+ items + " the string in front is: " + items.get(0) + " the string at the end is: " + items.get(items.size()-1);
    }
    
    public static void main(String[] args) throws Exception {
        QueueOfDistinctStrings q = new QueueOfDistinctStrings();
        
        q.enqueue("hi");
        q.enqueue("dude");
        q.enqueue("Fun");
        q.dequeue();
        System.out.println(q.repOK());
        System.out.println(q);
    }

}
