//This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

 //TODO Complete the Queue implementation
 private NodeBase<V>[] queue;
 private int capacity, currentSize, front, rear;
	
 public Queue(int capacity) {    
	 this.capacity = capacity;
	 this.queue = new Node[this.capacity];
	 this.currentSize = 0;
	 this.front = 0;
	 this.rear = -1;
 }

 public int size() {
	 return this.currentSize;
 }

 public boolean isEmpty() {
	return (this.size()==0); 
 }
	
 public boolean isFull() {
	 return (this.size() == capacity );
	 /*	 if((front == 0 && rear == capacity-1) || (front == rear+1)) {
		 return true;
	 }
	 else
		 return false; */
 }

 public void enqueue(Node<V> node) {
	 if(isFull()) {
		System.out.println("Inventory is full");
	 	return;
	 }
	 else {
		 rear = (rear + 1) % this.capacity;
		 queue[rear] = node;
		 currentSize++;
	 }
 }

 public NodeBase<V> dequeue() {
	 if(isEmpty()) {
		 System.out.println("Inventory Empty");
		 return null;
	 }
	 NodeBase<V> n = queue[front];
	 /*if(rear == front) {
		 front = 0;
		 rear = -1;
	 }
	 else*/
		 front = (front + 1) % this.capacity;
	 currentSize--;
	 return n;
 }

}

