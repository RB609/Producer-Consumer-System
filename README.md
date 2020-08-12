# Producer-Consumer-System

#### A producer-consumer system implemented in java
Uses multithreading to facilitate simultaneous operations of both buyers and sellers. Has functionality to include preferred sellers through a Priority Queue.
#### Docs:


class PriorityQueue<V>: implements QueueInterface<V>
   - private NodeBase<V>[] queue: Stores the queue.
   - private int capacity: Stores max capacity of the queue
   - private int currentSize: Stores current size of the queue.
   - public void add(int, V): Takes two args (int and V(generic)). Calls enqueue to add element to queue.
   - public void enqueue(Node<V>): Takes arg of Node<V> type, adds element according to its priority, implemented using heap data structure.
   - public NodeBase<V> dequeue(): Pops out the element of highest priority in the queue. Returns the element( NodeBase<V> type).

class Queue<V>: implements QueueInterface<V>
   - Methods implement Circular Queue.
   - private int front: Pointer to the first element in the queue. 
   - private int rear: pointer to last element in the queue.
   - public void enqueue(Node<V>): Adds element at the rear (wraps around ), implements circular queue.
   - public NodeBase<V> dequeue(): Pops out the last element in the queue, returns the element (NodeBase<V>).

class Buyer<V>: Extends abstractClass BuyerBase<V>
   - public void buy(): throws InterruptedException
        - Signals the thread to wait while the catalog is empty, takes element out of it when it becomes non empty, gives the non - empty signal.

class Seller<V>: Extends AbstractClass SellerBase<V>
   - public void sell(): throws InterruptedException
      - Signals the thread to wait till the catalog is full
      - If catalog not full, takes out element from the inventory queue, adds into the catalog.

class Node<V>: extends NodeBase<V>
   - public int getPriority(): returns priority of the node.
   - public V getValue(): Returns content of the node.

class Item
   - public String toString(): Converts the data of Item into a single String, returns String.

public Class Assignment2Driver: 
   - public int catalogSize: Stores Catalog size.
   - public int numSellers: Stores No. of Sellers.
   - public int numBuyers: Stores No. of Buyers.
   - public Queue<Item> inventory: Maintains the list of inventory items.
   - public static void main(String[]): throws InterruptedException
      - Reads the file with name taken as runtime argument, using bufferedReader.
      - Initializes the object a_driver with data from the file.
      - Creates an array of sellers and buyers
      - Creates and starts a thread for each buyer and seller.   
